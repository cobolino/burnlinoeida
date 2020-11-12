package me.fastal.burnlino.web.db;

import me.fastal.burnlino.domain.port.ForGettingTaxRates;
import org.springframework.stereotype.Component;

@Component
public class TaxRateGetter implements ForGettingTaxRates {

    private final TaxRateSqlDB taxRateSqlDB;

    public TaxRateGetter (TaxRateSqlDB taxRateSqlDB) {
        this.taxRateSqlDB = taxRateSqlDB;
    }

    @Override
    public double taxRateForState (String state) {
        TaxRate taxRate = taxRateSqlDB.findByState (state).orElseThrow ();
        return taxRate.getTaxRate ();
    }
}
