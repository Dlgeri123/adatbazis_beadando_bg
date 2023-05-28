package com.studies.adatbazis.CompanyCar;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CompanyCar {
    @Id
    private Integer id;
    private CompanyCarManufacturer companyCarManufacturer;
    @Indexed (unique = true)
    private String licensePlate;

    public CompanyCar(Integer id, CompanyCarManufacturer companyCarManufacturer, String licensePlate) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a CompanyCar id");
        if (companyCarManufacturer == null)
            throw new IllegalStateException("Add an CompanyCar companyCarManufacturer");
        if (licensePlate == null || licensePlate == "")
            throw new IllegalStateException("Add an CompanyCar licensePlate");

        this.id = id;
        this.companyCarManufacturer = companyCarManufacturer;
        this.licensePlate = licensePlate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add an CompanyCar id");

        this.id = id;
    }

    public CompanyCarManufacturer getCompanyCarManufacturer() {
        return companyCarManufacturer;
    }

    public void setCompanyCarManufacturer(CompanyCarManufacturer companyCarManufacturer) {
        if (companyCarManufacturer == null)
            throw new IllegalStateException("Add an CompanyCar companyCarManufacturer");

        this.companyCarManufacturer = companyCarManufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate == "")
            throw new IllegalStateException("Add an CompanyCar licensePlate");

        this.licensePlate = licensePlate;
    }
}
