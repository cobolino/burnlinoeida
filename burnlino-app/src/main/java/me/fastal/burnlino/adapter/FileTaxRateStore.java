package me.fastal.burnlino.adapter;

import me.fastal.burnlino.port.ForGettingTaxRates;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTaxRateStore implements ForGettingTaxRates {

    public static final String FIELD_DELIMITER = ",";
    private final Map<String, Double> store;

    public FileTaxRateStore () {
        this.store = loadTaxRatesFromFile ();
    }

    private Map<String, Double> loadTaxRatesFromFile () {

        String filePath = "src/main/resources/taxRates.txt";
        Path path = FileSystems.getDefault ().getPath (filePath);

        try (Stream<String> stream = Files.lines (path)) {
            return stream.collect (
                    Collectors.toMap (this::extractStateName, this::extractStateTaxRate));
        } catch (IOException ioe) {
            return new HashMap<> ();
        }

    }

    private String extractStateName (String line) {
        return line.split (FIELD_DELIMITER)[0];
    }

    private Double extractStateTaxRate (String line) {
        return Double.parseDouble (line.split (FIELD_DELIMITER)[1]);
    }

    @Override
    public double taxRateForState (String state) {
        return this.store.get (state);
    }
}
