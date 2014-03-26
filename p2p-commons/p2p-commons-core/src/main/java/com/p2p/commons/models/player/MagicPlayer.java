package com.p2p.commons.models.player;

import javax.persistence.ManyToOne;

import com.baldy.commons.security.models.Account;

/**
 * @author mbmartinez
 */
public class MagicPlayer {

    @ManyToOne(optional = false)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
