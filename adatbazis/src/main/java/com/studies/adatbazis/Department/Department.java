package com.studies.adatbazis.Department;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
//@CompoundIndex(def = "{'id': 1, 'name': 1}", unique = true)
public class Department {
    @Id
    private Integer id;
    @Indexed(unique = true)
    private String name;
    private List<String> locations;
    private List<Integer> employeeId;
    private List<Integer> projectId;

    @Autowired
    public Department(Integer id, String name, List<String> locations, List<Integer> employeeId) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a Department id");
        if (name == null || name == "")
            throw new IllegalStateException("Add a Department name");
        if (locations.isEmpty())
            throw new IllegalStateException("Add a Department location");
        if (employeeId.isEmpty())
            throw new IllegalStateException("Add a Department employeeId");

        this.id = id;
        this.name = name;
        this.locations = locations.stream().map(location -> location.replaceAll(" ", "").substring(0, 1).toUpperCase() + location.replaceAll(" ", "").substring(1).toLowerCase()).toList();
        this.employeeId = employeeId;
    }

    @Autowired
    public Department(Integer id, String name, List<String> locations, List<Integer> employeeId, List<Integer> projectId) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a Department id");
        if (name == null || name == "")
            throw new IllegalStateException("Add a Department name");
        if (locations.isEmpty())
            throw new IllegalStateException("Add a Department location");
        if (employeeId.isEmpty())
            throw new IllegalStateException("Add a Department employeeId");
        if (projectId.isEmpty())
            throw new IllegalStateException("Add a Department employeeId");

        this.id = id;
        this.name = name;
        this.locations = locations.stream().map(location -> location.replaceAll(" ", "").substring(0, 1).toUpperCase() + location.replaceAll(" ", "").substring(1).toLowerCase()).toList();
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    public Department(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add an Department id");

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name == "")
            throw new IllegalStateException("Add a department name");

        this.name = name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        if (locations.isEmpty())
            throw new IllegalStateException("Add a department location");

        this.locations = locations.stream().map(location -> location.replaceAll(" ", "").substring(0, 1).toUpperCase() + location.replaceAll(" ", "").substring(1).toLowerCase()).toList();
    }

    public List<Integer> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<Integer> employeeId) {
        if (employeeId.isEmpty())
            throw new IllegalStateException("Add a department employeeId");

        this.employeeId = employeeId;
    }

    public List<Integer> getProjectId() {
        return projectId;
    }

    public void setProjectId(List<Integer> projectId) {
        if (projectId.isEmpty())
            throw new IllegalStateException("Add a department projectId");

        this.projectId = projectId;
    }
}
