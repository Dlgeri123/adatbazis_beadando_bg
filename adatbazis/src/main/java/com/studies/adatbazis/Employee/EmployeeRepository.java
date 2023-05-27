package com.studies.adatbazis.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findById(Integer id);
    List<Employee> findByName(Name name);

    @Query("{ 'name.firstName' : { $regex: ?0 } }")
    List<Employee> findByFirstName(String firstName);

    @Query("{ 'name.lastName' : { $regex: ?0 } }")
    List<Employee> findByLastName(String lastName);
    List<Employee> findByAddress(Address address);

    @Query("{ 'address.country' : { $regex: ?0 } }")
    List<Employee> findByCountry(String country);

    @Query("{ 'address.city' : { $regex: ?0 } }")
    List<Employee> findByCity(String city);

    @Query("{ 'address.postcode' : { $regex: ?0 } }")
    List<Employee> findByPostcode(String postcode);
    Employee findByCompanyCarId(Integer companyCarId);
    Employee findByCompanyPcId(Integer companyPcId);
    /**
     * Find the employee(s) by a specific project id list.
     * Only retrieves data if the list exactly matches a project id array in the DB.
     */
    List<Employee> findByProjectId(List<Integer> projectId);
    /**
    * Find the employee(s) by a specific project id.
     */
    List<Employee> findByProjectId(Integer projectId);
}
