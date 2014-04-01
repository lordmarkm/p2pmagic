package com.p2p.proper.core.dto;

import java.util.List;

/**
 * @author mbmartinez
 */
public class MeetupInfo {

    private String name;
    private String description;
    private String address;
    private MagicPlayerInfo admin;
    private List<MagicPlayerInfo> moderators;

    @Override
    public String toString() {
        return "MeetupInfo [name=" + name + ", description=" + description
                + ", address=" + address + ", admin=" + admin + ", moderators="
                + moderators + "]";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public MagicPlayerInfo getAdmin() {
        return admin;
    }
    public void setAdmin(MagicPlayerInfo admin) {
        this.admin = admin;
    }
    public List<MagicPlayerInfo> getModerators() {
        return moderators;
    }
    public void setModerators(List<MagicPlayerInfo> moderators) {
        this.moderators = moderators;
    }
}
