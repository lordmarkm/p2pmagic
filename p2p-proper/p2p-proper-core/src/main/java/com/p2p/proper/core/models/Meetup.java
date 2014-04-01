package com.p2p.proper.core.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.baldy.commons.models.BaseBaldyEntity;

/**
 * @author mbmartinez
 */
@Entity(name = "meetup")
public class Meetup extends BaseBaldyEntity {

    @Column(unique = true)
    private String name;

    @Column
    private String address;

    @OneToMany
    private MagicPlayer admin;

    @OneToMany
    private List<MagicPlayer> moderators;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MagicPlayer> getModerators() {
        return moderators;
    }

    public void setModerators(List<MagicPlayer> moderators) {
        this.moderators = moderators;
    }

    public MagicPlayer getAdmin() {
        return admin;
    }

    public void setAdmin(MagicPlayer admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
