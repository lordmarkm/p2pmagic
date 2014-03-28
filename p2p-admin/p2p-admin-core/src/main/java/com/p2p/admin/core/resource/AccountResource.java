package com.p2p.admin.core.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.annotation.PostConstruct;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baldy.commons.security.models.Account;
import com.p2p.admin.core.dto.AccountInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "", description = "Account operations")
@RequestMapping("/accounts")
@RestController
public class AccountResource {

    private static Logger log = LoggerFactory.getLogger(AccountResource.class);

//    @Autowired
//    private AccountService accountService;

    @Autowired
    private Mapper mapper;

    @PostConstruct
    public void init() {
        log.debug("Initialized.");
    }

    @RequestMapping(value = "/create", method = POST)
    @ApiOperation("Create a new user")
    public ResponseEntity<AccountInfo> create(@ApiParam("account") @RequestBody AccountInfo accountInfo) {
        Account account = mapper.map(accountInfo, Account.class);
        log.debug("Got account. acct={}", account);
        return new ResponseEntity<>(accountInfo, OK);
        //return new ResponseEntity<>(mapper.map(accountService.save(account), AccountInfo.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = GET)
    @ApiOperation("Test string return value")
    public ResponseEntity<Account> test(@ApiParam("name") @RequestParam String name) {
        log.debug("Test requested.");

        Account account = new Account();
        account.setPassword("123qwe");
        account.setUsername(name);

        return new ResponseEntity<>(account, OK);
    }
}
