package com.studies.adatbazis.CompanyPC;

import java.time.LocalDate;

public class CompanyPcManufacturer {
    private String manufacturer;
    private String model;
    private LocalDate date;

    public CompanyPcManufacturer(String manufacturer, String model, LocalDate date) {
        if (manufacturer == "" || manufacturer == null)
            throw new IllegalStateException("Add a CompanyPC manufacturer");
        if (model == "" || model == null)
            throw new IllegalStateException("Add a CompanyPc model");
        if (date == null || date.isBefore(LocalDate.of(1970, 1, 1)))
            throw new IllegalStateException("Add a CompanyPc date");

        this.manufacturer = manufacturer;
        this.model = model;
        this.date = date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == "" || manufacturer == null)
            throw new IllegalStateException("Add a CompanyPC manufacturer");

        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == "" || model == null)
            throw new IllegalStateException("Add a CompanyPc model");

        this.model = model;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null || date.isBefore(LocalDate.of(1970, 1, 1)))
            throw new IllegalStateException("Add a CompanyPc date");

        this.date = date;
    }
}
