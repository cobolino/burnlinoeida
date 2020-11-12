package me.fastal.burnlino.cli;

import me.fastal.burnlino.domain.port.ForCalculatingPrices;

import java.io.PrintStream;

public class CliApp {

    private final ForCalculatingPrices hex;
    private PrintStream stream = System.out;
    private String[] arguments;
    private int argumentPosition = 0;

    public CliApp (ForCalculatingPrices hex) {
        this.hex = hex;
    }

    public void run (String... args) {
        this.arguments = args;
        parse ();
    }

    private void say (String str) {
        stream.println (str);
    }

    public void setOut (PrintStream out) {
        this.stream = out;
    }

    private void parse () {

        String message = "";

        while (hasMore ()) {
            if (argumentPosition == 0) {
                String functionName = arguments[argumentPosition];

                if (functionName.equals ("echoValue")) {
                    int price = Integer.parseInt (arguments[++argumentPosition]);
                    message = String.format ("El precio es %.2f dólares", (float) hex.echoValue (price));
                } else if (functionName.equals ("getTaxRateForState")) {
                    String state = arguments[++argumentPosition];
                    message = String.format ("La tasa de impuesto es %.2f por ciento.", hex.getTaxRateForState (state));
                } else if (functionName.equals ("calculatePriceWithTaxRate")) {
                    int price = Integer.parseInt (arguments[++argumentPosition]);
                    String state = arguments[++argumentPosition];
                    message =
                            String.format ("El precio con la tasa de impuesto es %.2f dólares",
                                    hex.calculatePriceWithTaxRate (price, state));
                }
            }
            argumentPosition++;
        }
        say (message);
    }

    private boolean hasMore () {
        return arguments.length > argumentPosition;
    }


}
