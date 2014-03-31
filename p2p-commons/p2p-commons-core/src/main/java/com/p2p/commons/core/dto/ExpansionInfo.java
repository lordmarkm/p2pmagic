package com.p2p.commons.core.dto;

/**
 * @author mbmartinez
 */
public class ExpansionInfo {

    private Long id;
    private String name;
    private String description;
    private String code;
    private Integer series;

    @Override
    public String toString() {
        return "ExpansionInfo [id=" + id + ", name=" + name + ", description="
                + description + ", code=" + code + ", series=" + series + "]";
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Integer getSeries() {
        return series;
    }
    public void setSeries(Integer series) {
        this.series = series;
    }

}
