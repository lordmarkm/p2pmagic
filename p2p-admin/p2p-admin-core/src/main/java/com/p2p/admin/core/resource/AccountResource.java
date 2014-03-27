package com.p2p.admin.core.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baldy.commons.security.models.Account;
import com.baldy.commons.security.services.AccountService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "", description = "Account operations")
@RequestMapping("/accounts")
@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;
    
    @RequestMapping(method = GET)
    @ApiOperation("Get all accounts")
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(accountService.findAll(), OK);
    }
}
