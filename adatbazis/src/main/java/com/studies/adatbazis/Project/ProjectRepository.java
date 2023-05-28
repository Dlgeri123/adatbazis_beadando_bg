package com.studies.adatbazis.Project;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    Project findById(Integer id);

    Project findByName(String name);

    List<Project> findByBudget(Integer budget);

    List<Project> findByEmployeeId(List<Integer> employeeId);

    List<Project>  findByEmployeeId(Integer employeeId);
}