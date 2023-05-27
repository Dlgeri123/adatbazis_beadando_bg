package com.studies.adatbazis.CompanyCar;

import com.studies.adatbazis.Employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyCarRepository extends MongoRepository<CompanyCar, String> {
    CompanyCar findById(Integer id);
    List<CompanyCar> findByCompanyCarManufacturer(CompanyCarManufacturer companyCarManufacturer);

    @Query("{ 'companyCarManufacturer.manufacturer' : { $regex: ?0 } }")
    List<CompanyCar> findByManufacturerName(String name);

    @Query("{ 'companyCarManufacturer.model' : { $regex: ?0 } }")
    List<CompanyCar> findByManufacturerModel(String model);

    @Query("{ 'companyCarManufacturer.color' : { $regex: ?0 } }")
    List<CompanyCar> findByManufacturerColor(String color);

    @Query("{ 'companyCarManufacturer.year' : { $regex: ?0 } }")
    List<CompanyCar> findByManufacturerYear(Integer year);
    CompanyCar findByLicensePlate(String licensePlate);
}