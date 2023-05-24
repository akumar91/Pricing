package com.retail.pricing.model;

public class Detail {

    Double price;
    String currencyCode;
    String item;

    public Detail(double price, String currencyCode, String item) {
        this.price = price;
        this.currencyCode = currencyCode;
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
