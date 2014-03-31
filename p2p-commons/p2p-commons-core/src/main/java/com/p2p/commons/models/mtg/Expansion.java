package com.p2p.commons.models.mtg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.baldy.commons.models.BaseBaldyEntity;

@Entity
@Table(name="expansion")
public class Expansion extends BaseBaldyEntity {

    @Column(nullable = false)
    private String code;

    @Column(unique = true, nullable = false)
    private int series;

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