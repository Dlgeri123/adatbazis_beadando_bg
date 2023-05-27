package com.studies.adatbazis.Project;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Project {
    @Id
    private Integer id;
    @Indexed (unique = true)
    private String name;
    private Integer budget;
    private List<Integer> employeeId;

    public Project(Integer id, String name, Integer budget, List<Integer> employeeId) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a project id");
        if (name == null || name == "")
            throw new IllegalStateException("Add a project name");
        if (budget == null || budget < 1)
            throw new IllegalStateException("Add a project budget");
        if (employeeId.isEmpty())
            throw new IllegalStateException("Add a project employees");

        this.id = id;
        this.name = name;
        this.budget = budget;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0)
            throw new IllegalStateException("Add a project id");

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name == "")
            throw new IllegalStateException("Add a project name");

        this.name = name;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        if (budget == null || budget < 1)
            throw new IllegalStateException("Add a project budget");

        this.budget = budget;
    }

    public List<Integer> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<Integer> employeeId) {
        if (employeeId.isEmpty())
            throw new IllegalStateException("Add a project employees");

        this.employeeId = employeeId;
    }
}
