package com.p2p.commons.models.mtg;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.baldy.commons.models.BaseBaldyEntity;
import com.google.common.collect.Lists;

@Entity
@Table(name="expansions")
public class Expansion extends BaseBaldyEntity {

    @Column(nullable = false)
    private String code;

    @Column(unique = true)
    private int series = 0;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="expansion")
    private List<Card> cards = Lists.newArrayList();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String abbreviation) {
        this.code = abbreviation;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

}