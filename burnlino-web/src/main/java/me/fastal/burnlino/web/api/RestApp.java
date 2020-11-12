package me.fastal.burnlino.web.api;

import me.fastal.burnlino.domain.port.ForCalculatingPrices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping ("/api")
public final class RestApp {

    private final ForCalculatingPrices hex;

    public RestApp (ForCalculatingPrices hex) {
        this.hex = hex;
    }

    @GetMapping (path = "/echo/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> echoValue (@PathVariable int value) {
        return Map.of ("value", (float) hex.echoValue (value));
    }

    @GetMapping (path = "/tax_rate/{state}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> taxRate (@PathVariable String state) {
        return Map.of ("state", state, "value", (float) hex.getTaxRateForState (state));
    }

    @GetMapping (path = "/price_with_tax_rate/{price}/{state}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> price (@PathVariable int price, @PathVariable String state) {
        return Map.of ("state", state, "value", (float) hex.calculatePriceWithTaxRate (price, state));
    }

}
