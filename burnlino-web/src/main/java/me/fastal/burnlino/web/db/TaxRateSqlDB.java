package me.fastal.burnlino.web.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaxRateSqlDB extends CrudRepository<TaxRate, String> {

    Optional<TaxRate> findByState(String state);

}
