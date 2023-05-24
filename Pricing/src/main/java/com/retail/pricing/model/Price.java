package com.retail.pricing.model;

public class Price {

    Integer tcin;
    String category;
    Detail detail;

    public Price(Integer tcin, String category, Detail detail)
    {
        this.tcin = tcin;
        this.category = category;
        this.detail = detail;
    }

    public Integer getTcin() {
        return tcin;
    }

    public void setTcin(Integer tcin) {
        this.tcin = tcin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
