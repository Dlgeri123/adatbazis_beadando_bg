package com.studies.adatbazis.Employee;

import lombok.Data;

@Data
public class Address {
    private String country;
    private String city;
    private Integer postcode;

    public Address(String country, String city, Integer postcode) {
        if (country == null || country == "")
            throw new IllegalStateException("Add an Address country");
        if (city == null || city == "")
            throw new IllegalStateException("Add an Address city");
        if (postcode == null || postcode <= 0)
            throw new IllegalStateException("Add an Address postcode");
        this.country = country.replaceAll(" ", "").substring(0, 1).toUpperCase() + country.replaceAll(" ", "").substring(1).toLowerCase();
        this.city = city.replaceAll(" ", "").substring(0, 1).toUpperCase() + city.replaceAll(" ", "").substring(1).toLowerCase();
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country == "")
            throw new IllegalStateException("Add an Address country");

        this.country = country.replaceAll(" ", "").substring(0, 1).toUpperCase() + country.replaceAll(" ", "").substring(1).toLowerCase();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city == "")
            throw new IllegalStateException("Add an Address city");

        this.city = city.replaceAll(" ", "").substring(0, 1).toUpperCase() + city.replaceAll(" ", "").substring(1).toLowerCase();
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        if (postcode == null || postcode <= 0)
            throw new IllegalStateException("Add an Address postcode");

        this.postcode = postcode;
    }
}
