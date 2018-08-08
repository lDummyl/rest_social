package com.example.demo.commercial;


public class Price {

    private Tradable item;

    public Currency purchaseCurrency;

    public boolean isIncludesVAT;

    public boolean isIncludesDelivery;

    public double value;

    public void setItem(Tradable item) {
        this.item = item;
    }

    public Price(Tradable item, Currency purchaseCurrency, boolean isIncludesVAT, double value) {

        this.item = item;
        this.purchaseCurrency = purchaseCurrency;
        this.isIncludesVAT = isIncludesVAT;
        this.value = value;
    }
    public Price(double value, Currency purchaseCurrency, boolean isIncludesVAT) {

        this.purchaseCurrency = purchaseCurrency;
        this.isIncludesVAT = isIncludesVAT;
        this.value = value;
    }

    public double getValue(Currency cur, Boolean isIncludesVAT, Boolean isIncludesDelivery){

        double val = this.value;

        if (isIncludesVAT) {
            val = (this.isIncludesVAT) ? val : val * (1+ VAT.VALUE);
        } else{
            val = (!this.isIncludesVAT) ? val : val / (1+ VAT.VALUE);
        }

//        if (isIncludesDelivery) {
//            val = (this.isIncludesDelivery) ? val : val * item.deilveryMultiplier;
//        }else {
//            val = (!this.isIncludesDelivery) ? val : val / item.deilveryMultiplier;
//        }

        val = val*(purchaseCurrency.multiplier/cur.multiplier);

        return (double) Math.round(val * 100) / 100;// .##
    }
}
