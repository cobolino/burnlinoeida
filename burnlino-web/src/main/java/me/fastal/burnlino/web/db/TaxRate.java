package me.fastal.burnlino.web.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaxRate {

    @Id
    private String id;
    private String state;
    private float taxRate;

    public TaxRate () {
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public TaxRate (String state, float taxRate) {
        this.state = state;
        this.taxRate = taxRate;
    }

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    public float getTaxRate () {
        return taxRate;
    }

    public void setTaxRate (float taxRate) {
        this.taxRate = taxRate;
    }
}
