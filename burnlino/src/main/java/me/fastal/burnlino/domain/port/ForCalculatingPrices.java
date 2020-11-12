package me.fastal.burnlino.domain.port;

public interface ForCalculatingPrices {

    int echoValue (int value);

    double getTaxRateForState (String state);

    double calculatePriceWithTaxRate (int value, String state);

}
