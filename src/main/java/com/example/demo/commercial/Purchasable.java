package com.example.demo.commercial;

import com.example.demo.commercial.Currency;
import sun.util.resources.ext.CurrencyNames_en_NZ;

import javax.persistence.Column;


public abstract class Purchasable {

    protected Double deilveryMultiplier = 1.0;

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
