package com.p2p.admin.core.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baldy.commons.security.models.Account;
import com.baldy.commons.security.services.AccountService;
import com.p2p.admin.core.dto.AccountInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author mbmartinez
 */
@Api(value = "", description = "Account operations")
@RequestMapping("/accounts")
@RestController
public class AccountResource {

    private static Logger log = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = GET)
    @ApiOperation("Get an account")
    public ResponseEntity<Account> get(@ApiParam("id") @RequestParam Long id) {
        return new ResponseEntity<>(accountService.findOne(id), OK);
    }

    @RequestMapping(value = "/all", method = GET)
    @ApiOperation("Get all accounts")
    public ResponseEntity<Page<Account>> get(@ApiParam("start") @RequestParam Integer start,
            @ApiParam("length") @RequestParam Integer length) {
        return new ResponseEntity<>(accountService.findAll(new PageRequest(start, length)), OK);
    }

    @RequestMapping(value = "/create", method = POST)
    @ApiOperation("Create a new user")
    public ResponseEntity<AccountInfo> create(@ApiParam("account") @RequestBody AccountInfo accountInfo) {
        Account account = mapper.map(accountInfo, Account.class);
        log.debug("Got account. acct={}", account);
        return new ResponseEntity<>(mapper.map(accountService.save(account), AccountInfo.class), OK);
    }

    @RequestMapping(value = "/delete", method = DELETE)
    @ApiOperation("Delete a user")
    public ResponseEntity<String> delete(@ApiParam("id") @RequestParam Long id) {
        log.debug("Delete request for account. id={}", id);
        accountService.delete(id);
        return new ResponseEntity<>("Ok", OK);
    }
}
