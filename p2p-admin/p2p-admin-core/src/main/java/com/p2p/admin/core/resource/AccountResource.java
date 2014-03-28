package com.p2p.admin.core.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baldy.commons.security.models.Account;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "", description = "Account operations")
@RequestMapping("/accounts")
@RestController
public class AccountResource {

    private static Logger log = LoggerFactory.getLogger(AccountResource.class);

    //@Autowired
    //private AccountService accountService;

    @PostConstruct
    public void init() {
        log.debug("Initialized.");
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
