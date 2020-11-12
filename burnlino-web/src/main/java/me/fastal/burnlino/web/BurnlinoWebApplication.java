package me.fastal.burnlino.web;

import me.fastal.burnlino.adapter.InMemoryTaxRateStore;
import me.fastal.burnlino.domain.PriceMaker;
import me.fastal.burnlino.domain.port.ForCalculatingPrices;
import me.fastal.burnlino.web.db.TaxRate;
import me.fastal.burnlino.web.db.TaxRateGetter;
import me.fastal.burnlino.web.db.TaxRateSqlDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BurnlinoWebApplication {

    public static void main (String[] args) {
        SpringApplication.run (BurnlinoWebApplication.class, args);
    }

    @Bean
    public ForCalculatingPrices forCalculatingPrices (TaxRateGetter taxRateGetter) {
        return new PriceMaker (taxRateGetter);
    }

}
