package com.example.demo.commercial;

public enum Currency { EUR(75.), RUB(1.0), USD(65.);
    // TODO: 30.07.2018 connect to external source

    double multiplier;

    Currency(double multiplier){
        this.multiplier = multiplier;
    }


}
