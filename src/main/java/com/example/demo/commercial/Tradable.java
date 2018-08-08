package com.example.demo.commercial;


public abstract class Tradable {

    private com.example.demo.commercial.Currency Currency;

    private Price price;

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
