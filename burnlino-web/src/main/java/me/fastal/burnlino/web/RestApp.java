package me.fastal.burnlino.web;

import me.fastal.burnlino.domain.port.ForCalculatingPrices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RestApp {

    private ForCalculatingPrices hex;

    public RestApp (ForCalculatingPrices hex) {
        this.hex = hex;
    }

    @GetMapping ("/echo/{value}")
    public String echoValue (@PathVariable int value) {
        return String.format ("El precio es %.2f dólares", (float) hex.echoValue (value));
    }

    @GetMapping ("/tax_rate/{state}")
    public String taxRate (@PathVariable String state) {
        return String.format ("La tasa de impuesto en %s es %.2f por ciento",
                state,
                (float) hex.getTaxRateForState (state));
    }

    @GetMapping ("/price_with_tax_rate/{price}/{state}")
    public String price (@PathVariable int price, @PathVariable String state) {
        return String.format ("El precio con la tasa de impuesto en %s es %.2f dólares",
                state,
                (float) hex.calculatePriceWithTaxRate (price, state));
    }

}
