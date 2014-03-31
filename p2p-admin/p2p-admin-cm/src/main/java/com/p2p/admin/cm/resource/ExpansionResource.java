package com.p2p.admin.cm.resource;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.p2p.commons.core.dto.ExpansionInfo;
import com.p2p.commons.models.mtg.Expansion;
import com.p2p.commons.repo.mtg.ExpansionRepo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author mbmartinez
 */
@Api(value = "", description = "Expansion operations")
@RequestMapping({"/expansion", "/e"})
@RestController
public class ExpansionResource {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ExpansionRepo expansionRepo;

    @RequestMapping(method = GET)
    @ApiOperation("Get an expansion, by Id")
    public ResponseEntity<ExpansionInfo> get(@ApiParam @RequestParam Long id) {
        return new ResponseEntity<>(mapper.map(expansionRepo.findOne(id), ExpansionInfo.class), OK);
    }

    @RequestMapping(value = "/chronological", method = GET)
    @ApiOperation("Get all expansions, ordered by release date")
    public ResponseEntity<List<ExpansionInfo>> chronological() {
        Sort sort = new Sort(Direction.ASC, "series");
        List<ExpansionInfo> expansions = Lists.newArrayList();
        for (Expansion expansion : expansionRepo.findAll(sort)) {
            expansions.add(mapper.map(expansion, ExpansionInfo.class));
        }
        return new ResponseEntity<>(expansions, OK);
    }

    @RequestMapping(value = "/create", method = POST)
    @ApiOperation("Create an expansion")
    public ResponseEntity<ExpansionInfo> create(@ApiParam @RequestBody ExpansionInfo expansionInfo) {
        Expansion expansion = mapper.map(expansionInfo, Expansion.class);
        return new ResponseEntity<>(mapper.map(expansionRepo.save(expansion), ExpansionInfo.class), OK);
    }

}
