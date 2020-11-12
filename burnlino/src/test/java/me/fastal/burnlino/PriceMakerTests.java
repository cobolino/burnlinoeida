package me.fastal.burnlino;

import me.fastal.burnlino.adapter.FileTaxRateStore;
import me.fastal.burnlino.adapter.InMemoryTaxRateStore;
import me.fastal.burnlino.domain.PriceMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMakerTests {

    @Test
    void shouldEchoValue () {
        PriceMaker app = new PriceMaker ();
        assertEquals (100, app.echoValue (100));
    }

    @Test
    void shouldGive6PercentForFlorida () {
        PriceMaker app = new PriceMaker (new InMemoryTaxRateStore ());

        double tax = app.getTaxRateForState ("FL");
        assertEquals (6.85, tax);
    }

    @Test
    void shouldAddTaxToValue() {
        PriceMaker app = new PriceMaker (new InMemoryTaxRateStore ());

        double price = app.calculatePriceWithTaxRate(100, "FL");
        assertEquals (106.85, price);
    }

    @Test
    void shouldPullTaxRateFromFile() {
        PriceMaker app = new PriceMaker (new FileTaxRateStore ());

        double price = app.calculatePriceWithTaxRate(100, "FL");
        assertEquals (106.85, price);
    }

}
