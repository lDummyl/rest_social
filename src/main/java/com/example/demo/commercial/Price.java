package com.example.demo.commercial;


public class Price {

    private Purchasable item;

    public Currency purchaseCurrency;

    public boolean isIncludesVAT;

    public boolean isIncludesDelivery;

    public double value;

    public Price(Purchasable item, Currency purchaseCurrency, boolean isIncludesVAT, double value) {

        this.item = item;
        this.purchaseCurrency = purchaseCurrency;
        this.isIncludesVAT = isIncludesVAT;
        this.value = value;
    }
    public Price(Currency purchaseCurrency, boolean isIncludesVAT, double value) {

        this.item = item;
        this.purchaseCurrency = purchaseCurrency;
        this.isIncludesVAT = isIncludesVAT;
        this.value = value;
    }




    public double getValue(Currency cur, Boolean isIncludesVAT, Boolean isIncludesDelivery){

        double val = this.value;

        if (isIncludesVAT) {
            val = (this.isIncludesVAT) ? val : val * VAT.VALUE;
        }
        if (isIncludesDelivery) {
            val = (this.isIncludesDelivery) ? val : val * item.deilveryMultiplier;
        }
        val = val*(purchaseCurrency.multiplier/cur.multiplier);

        return val;
    }
}
