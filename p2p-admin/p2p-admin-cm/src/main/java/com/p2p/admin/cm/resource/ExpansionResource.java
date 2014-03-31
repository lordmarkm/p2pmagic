package com.p2p.admin.cm.resource;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p2p.commons.core.dto.ExpansionInfo;
import com.p2p.commons.repo.mtg.ExpansionRepo;
import com.wordnik.swagger.annotations.Api;

/**
 * @author mbmartinez
 */
@Api(value = "", description = "Expansion operations")
@RequestMapping({"/expansion", "/e"})
@RestController
public class ExpansionResource {

    @Autowired
    private ExpansionRepo expansionRepo;

    @RequestMapping(value = "/create", method = POST)
    public void create(ExpansionInfo expansionInfo) {
        
    }

}
