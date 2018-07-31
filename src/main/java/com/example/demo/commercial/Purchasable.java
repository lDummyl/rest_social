package com.example.demo.commercial;


public abstract class Purchasable {

    protected Double deilveryMultiplier = 1.1;

    private Currency purchaseCurrency;

    private Double basePrice;

    private Double purchasePrice;
    // VAT free purchase price without cost of delivery.

    public Double getPurchasePrice() {

        return purchasePrice;
    }
    public Double getBasePrice() {

        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }
}
