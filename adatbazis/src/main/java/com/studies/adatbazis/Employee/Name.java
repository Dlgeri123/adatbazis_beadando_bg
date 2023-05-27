package com.studies.adatbazis.Employee;

import lombok.Data;

@Data
public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        if (firstName == "" || firstName == null)
            throw new IllegalStateException("Add a first name");
        if (lastName == "" || lastName == null)
            throw new IllegalStateException("Add a last name");

        this.firstName = firstName.replaceAll(" ", "").substring(0, 1).toUpperCase() + firstName.replaceAll(" ", "").substring(1).toLowerCase();
        this.lastName = lastName.replaceAll(" ", "").substring(0, 1).toUpperCase() + lastName.replaceAll(" ", "").substring(1).toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == "" || firstName == null)
            throw new IllegalStateException("Add a first name");

        this.firstName = firstName.replaceAll(" ", "").substring(0, 1).toUpperCase() + firstName.replaceAll(" ", "").substring(1).toLowerCase();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == "" || lastName == null || lastName == " ")
            throw new IllegalStateException("Add a last name");

        this.lastName = lastName.replaceAll(" ", "").substring(0, 1).toUpperCase() + lastName.replaceAll(" ", "").substring(1).toLowerCase();
    }
}
