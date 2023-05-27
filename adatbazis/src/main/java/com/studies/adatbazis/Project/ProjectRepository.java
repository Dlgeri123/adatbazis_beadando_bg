package com.studies.adatbazis.Project;

import com.studies.adatbazis.CompanyCar.CompanyCar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {
    Project findById(Integer id);

    Project findByName(String name);

    List<Project> findByBudget(Integer budget);

    List<Project> findByEmployeeId(List<Integer> employeeId);

//    @Query(value = "{ 'employeeId' : {$all : [?0] }}")
    List<Project> findByEmployeeId(Integer employeeId);
}