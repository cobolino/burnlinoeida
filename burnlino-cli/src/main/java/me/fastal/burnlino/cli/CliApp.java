package me.fastal.burnlino.cli;

import me.fastal.burnlino.domain.port.ForCalculatingPrices;

import java.io.PrintStream;

public class CliApp {

    private static PrintStream stream = System.out;
    private ForCalculatingPrices hex;
    private String[] args;
    private int donde = 0;

    public CliApp (ForCalculatingPrices hex) {
        this.hex = hex;
    }

    public void iniciar (String... args) {
        this.args = args;
        parsear ();
    }

    private void decir (String str) {
        stream.println (str);
    }

    public void setOut (PrintStream out) {
        stream = out;
    }

    private void parsear () {
        String reporte = "";

        while (hayMas ()) {
            if (donde == 0) {
                String functionName = args[donde];

                if (functionName.equals ("echoValue")) {
                    int precio = Integer.parseInt (args[++donde]);
                    reporte = String.format ("El precio es %.2f dólares", (float) hex.echoValue (precio));
                } else if (functionName.equals ("getTaxRateForState")) {
                    String state = args[++donde];
                    reporte = String.format ("La tasa de impuesto es %.2f por ciento.", hex.getTaxRateForState (state));
                } else if (functionName.equals ("calculatePriceWithTaxRate")) {
                    int precio = Integer.parseInt (args[++donde]);
                    String state = args[++donde];
                    reporte =
                            String.format ("El precio con la tasa de impuesto es %.2f dólares",
                                    hex.calculatePriceWithTaxRate (precio, state));
                }
            }

            donde++;
        }

        decir (reporte);
    }

    private boolean hayMas () {
        if (args.length <= donde || donde >= args.length)
            return false;

        return true;
    }


}
