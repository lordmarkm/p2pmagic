package com.p2p.proper.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baldy.commons.security.models.Account;

/**
 * @author mbmartinez
 */
@Entity
@Table(name = "player")
public class MagicPlayer {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
