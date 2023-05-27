package com.studies.adatbazis.CompanyPC;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CompanyPc {
    @Id
    private Integer id;
    private CompanyPcManufacturer companyPcManufacturer;
    private String cpu;
    private Integer ram;

    public CompanyPc(Integer id, CompanyPcManufacturer companyPcManufacturer, String cpu, Integer ram) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a CompanyPc id");
        if (companyPcManufacturer == null)
            throw new IllegalStateException("Add a CompanyPc companyPcManufacturer");
        if (cpu == "" || cpu == null)
            throw new IllegalStateException("Add a CompanyPc cpu");
        if (ram <= 0)
            throw new IllegalStateException("Add a CompanyPc ram");

        this.id = id;
        this.companyPcManufacturer = companyPcManufacturer;
        this.cpu = cpu;
        this.ram = ram;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add an CompanyPc id");

        this.id = id;
    }

    public CompanyPcManufacturer getCompanyPcManufacturer() {
        return companyPcManufacturer;
    }

    public void setCompanyPcManufacturer(CompanyPcManufacturer companyPcManufacturer) {
        if (companyPcManufacturer == null)
            throw new IllegalStateException("Add a CompanyPc companyPcManufacturer");

        this.companyPcManufacturer = companyPcManufacturer;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        if (cpu == "" || cpu == null)
            throw new IllegalStateException("Add a CompanyPc cpu");

        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        if (ram <= 0)
            throw new IllegalStateException("Add a CompanyPc ram");

        this.ram = ram;
    }
}
