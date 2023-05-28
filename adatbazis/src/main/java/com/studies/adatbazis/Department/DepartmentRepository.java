package com.studies.adatbazis.Department;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    Department findById(Integer id);

    Department findByName(String name);

    List<Department> findByLocations(List<String> locations);

    @Query("{ 'locations' : { $regex: ?0 } }")
    List<Department> findByLocation(String location);

    List<Department> findByEmployeeId(List<Integer> employeeIds);

    List<Department> findByEmployeeId(Integer employeeId);

    List<Department> findByProjectId(List<Integer> projectId);

    List<Department> findByProjectId(Integer projectId);
}
