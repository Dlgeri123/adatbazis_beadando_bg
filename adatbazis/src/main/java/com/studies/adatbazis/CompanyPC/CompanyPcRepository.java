package com.studies.adatbazis.CompanyPC;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CompanyPcRepository extends MongoRepository<CompanyPc, String> {
    CompanyPc findById(Integer id);
    List<CompanyPc> findByCompanyPcManufacturer(CompanyPcManufacturer companyPcManufacturer);

    @Query("{ 'companyPcManufacturer.manufacturer' : { $regex: ?0 } }")
    List<CompanyPc> findByManufacturerName(String name);

    @Query("{ 'companyPcManufacturer.model' : { $regex: ?0 } }")
    List<CompanyPc> findByManufacturerModel(String model);

    @Query("{ 'companyPcManufacturer.date' : { $regex: ?0 } }")
    List<CompanyPc> findByManufacturerDate(LocalDate date);
    List<CompanyPc> findByCpu(String cpu);
    List<CompanyPc> findByRam(Integer ram);
}