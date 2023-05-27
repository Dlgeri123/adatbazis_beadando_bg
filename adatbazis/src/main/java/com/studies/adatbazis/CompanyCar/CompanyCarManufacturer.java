package com.studies.adatbazis.CompanyCar;

public class CompanyCarManufacturer {
    private String manufacturer;
    private String model;
    private String color;
    private Integer year;

    public CompanyCarManufacturer(String manufacturer, String model, String color, Integer year) {
        if (manufacturer == "" || manufacturer == null)
            throw new IllegalStateException("Add a car manufacturer");
        if (model == "" || model == null)
            throw new IllegalStateException("Add a car model");
        if (color == "" || color == null)
            throw new IllegalStateException("Add a car color");
        if (year <= 0)
            throw new IllegalStateException("Add a car year");

        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer == "" || manufacturer == null)
            throw new IllegalStateException("Add a car manufacturer");

        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == "" || model == null)
            throw new IllegalStateException("Add a car model");

        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == "" || color == null)
            throw new IllegalStateException("Add a car color");

        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year <= 0)
            throw new IllegalStateException("Add a car year");

        this.year = year;
    }
}
