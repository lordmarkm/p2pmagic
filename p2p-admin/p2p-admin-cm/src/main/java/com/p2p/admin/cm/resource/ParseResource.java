package com.p2p.admin.cm.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.p2p.admin.cm.parser.GathererParser;
import com.p2p.commons.core.dto.CardInfo;
import com.p2p.commons.core.models.Card;
import com.p2p.commons.core.models.Expansion;
import com.p2p.commons.core.repo.CardRepo;
import com.p2p.commons.core.repo.ExpansionRepo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Parse data from magic sites
 * @author mbmartinez
 */
@Api(value = "", description = "Parse operations")
@RequestMapping("/parse")
@RestController
@Transactional
public class ParseResource {

    private static final Logger log = LoggerFactory.getLogger(ParseResource.class);

    @Autowired
    private GathererParser parser;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private ExpansionRepo expansionRepo;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = POST)
    @ApiOperation("Parse an SCG URL")
    public ResponseEntity<List<CardInfo>> parse(
            @ApiParam @RequestParam String expCode,
            @ApiParam @RequestParam String url,
            @ApiParam(defaultValue = "false") @RequestParam(defaultValue = "false") boolean deleteFirst) throws IOException {

        log.debug("Parsing for expansion. exp={}, url={}", expCode, url);

        Expansion expansion = expansionRepo.findByCode(expCode);
        Preconditions.checkNotNull(expansion);

        if (deleteFirst) {
            List<Card> cards = cardRepo.findByExpansion(expansion);
            cardRepo.delete(cards);
        }

        List<Card> cards = parser.parsePage(url);
        List<CardInfo> cardInfos = Lists.newArrayList();
        for (Card card : cards) {
            card.setExpansion(expansion);
            Card saved = cardRepo.save(card);
            cardInfos.add(mapper.map(saved, CardInfo.class));
        }

        log.debug("Parsed and saved {} cards.", cards.size());
        return new ResponseEntity<>(cardInfos, OK);
    }
}
