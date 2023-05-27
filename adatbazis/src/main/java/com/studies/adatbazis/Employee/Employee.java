package com.studies.adatbazis.Employee;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
//@CompoundIndex(def = "{'id': 1, 'companyCarId': 1, 'companyPcId': 1}", unique = true)
public class Employee {
    @Id
    private Integer id;
    private Name name;
    private Address address;
    private List<Integer> projectId;
    @Indexed (unique = true, sparse = true)
    private Integer companyCarId;
    @Indexed (unique = true)
    private Integer companyPcId;

    public Employee(Integer id, Name name, Address address, Integer companyPcId) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a employee id");
        if (name == null)
            throw new IllegalStateException("Add an employee name");
        if (address == null)
            throw new IllegalStateException("Add an employee address");
        if (companyPcId == null || companyPcId <= 0)
            throw new IllegalStateException("Add an employee companyPcId");

        this.id = id;
        this.name = name;
        this.address = address;
        this.companyPcId = companyPcId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a employee id");

        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        if (name == null)
            throw new IllegalStateException("Add an employee name");
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address == null)
            throw new IllegalStateException("Add an employee address");
        this.address = address;
    }

    public List<Integer> getProjectId() {
        return projectId;
    }

    public void setProjectId(List<Integer> projectId) {
        this.projectId = projectId;
    }

    public Integer getCompanyCarId() {
        return companyCarId;
    }

    public void setCompanyCarId(Integer companyCarId) {
        this.companyCarId = companyCarId;
    }

    public Integer getCompanyPcId() {
        return companyPcId;
    }

    public void setCompanyPcId(Integer companyPcId) {
        if (companyPcId == null || companyPcId <= 0)
            throw new IllegalStateException("Add an employee companyPcId");
        this.companyPcId = companyPcId;
    }
}
