package me.fastal.burnlino.web;

import me.fastal.burnlino.adapter.InMemoryTaxRateStore;
import me.fastal.burnlino.domain.PriceMaker;
import me.fastal.burnlino.domain.port.ForCalculatingPrices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BurnlinoWebApplication {

    public static void main (String[] args) {
        SpringApplication.run (BurnlinoWebApplication.class, args);
    }

    @Bean
    public ForCalculatingPrices forCalculatingPrices() {
        return new PriceMaker (new InMemoryTaxRateStore());
    }

}
