package com.p2p.commons.core.dto;

/**
 * @author mbmartinez
 */
public class CardInfo {

    private String name;
    private String expansion;
    private String displayName;
    private String cost;
    private String supertype;
    private String subtype;
    private String rarity;

    @Override
    public String toString() {
        return "CardInfo [name=" + name + ", expansion=" + expansion
                + ", displayName=" + displayName + ", cost=" + cost
                + ", supertype=" + supertype + ", subtype=" + subtype
                + ", rarity=" + rarity + "]";
    }

    public String getExpansion() {
        return expansion;
    }
    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getSupertype() {
        return supertype;
    }
    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }
    public String getSubtype() {
        return subtype;
    }
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
