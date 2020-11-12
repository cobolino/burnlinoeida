package me.fastal.burnlino.web.ui;

import me.fastal.burnlino.domain.port.ForCalculatingPrices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public final class WebApp {

    private final ForCalculatingPrices hex;

    public WebApp (ForCalculatingPrices hex) {
        this.hex = hex;
    }

    @GetMapping ("/echo/{value}")
    public String echoValue (@PathVariable int value, Model model) {
        model.addAttribute ("value", hex.echoValue (value));
        return "echo";
    }

    @GetMapping ("/tax_rate/{state}")
    public String taxRate (@PathVariable String state, Model model) {
        model.addAttribute ("state", state);
        model.addAttribute ("value", hex.getTaxRateForState (state));
        return "tax-rate";
    }

    @GetMapping ("/price_with_tax_rate/{price}/{state}")
    public String price (@PathVariable int price, @PathVariable String state, Model model) {
        model.addAttribute ("state", state);
        model.addAttribute ("value", hex.calculatePriceWithTaxRate (price, state));
        return "price";
    }

}
