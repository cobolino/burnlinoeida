package me.fastal.burnlino.cli;

import me.fastal.burnlino.adapter.InMemoryTaxRateStore;
import me.fastal.burnlino.domain.PriceMaker;

public class Main {

    public static void main (String[] args) {
        PriceMaker hex = new PriceMaker(new InMemoryTaxRateStore ());

        CliApp ui = new CliApp(hex);
        ui.run (args);
    }

}
