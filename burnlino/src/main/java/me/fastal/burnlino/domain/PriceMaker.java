package me.fastal.burnlino.domain;

import me.fastal.burnlino.domain.port.ForCalculatingPrices;
import me.fastal.burnlino.domain.port.ForGettingTaxRates;

public class PriceMaker implements ForCalculatingPrices {

    private ForGettingTaxRates forGettingTaxRates;

    public PriceMaker () {
    }

    public PriceMaker (ForGettingTaxRates forGettingTaxRates) {
        this.forGettingTaxRates = forGettingTaxRates;
    }

    @Override
    public int echoValue (int value) {
        return value;
    }

    @Override
    public double getTaxRateForState (String state) {
        return this.forGettingTaxRates.taxRateForState (state);
    }

    @Override
    public double calculatePriceWithTaxRate (int value, String state) {
        return value + (value * (getTaxRateForState (state) / 100));
    }
}
