package me.fastal.burnlino.adapter;

import me.fastal.burnlino.port.ForGettingTaxRates;

import java.util.HashMap;

public class InMemoryTaxRateStore implements ForGettingTaxRates {

    private final HashMap<String, Double> store;

    public InMemoryTaxRateStore () {
        this.store = new HashMap<> ();
        this.store.put ("FL", 6.85);
    }

    @Override
    public double taxRateForState (String state) {
        return this.store.get (state);
    }

}
