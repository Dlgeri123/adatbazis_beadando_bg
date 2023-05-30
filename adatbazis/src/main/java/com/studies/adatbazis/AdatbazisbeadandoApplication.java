package com.studies.adatbazis;

import com.mongodb.client.MongoCollection;
import com.studies.adatbazis.CompanyCar.CompanyCar;
import com.studies.adatbazis.CompanyCar.CompanyCarManufacturer;
import com.studies.adatbazis.CompanyCar.CompanyCarRepository;
import com.studies.adatbazis.CompanyPC.CompanyPc;
import com.studies.adatbazis.CompanyPC.CompanyPcManufacturer;
import com.studies.adatbazis.CompanyPC.CompanyPcRepository;
import com.studies.adatbazis.Department.Department;
import com.studies.adatbazis.Department.DepartmentRepository;
import com.studies.adatbazis.Employee.Address;
import com.studies.adatbazis.Employee.Employee;
import com.studies.adatbazis.Employee.EmployeeRepository;
import com.studies.adatbazis.Employee.Name;
import com.studies.adatbazis.Project.Project;
import com.studies.adatbazis.Project.ProjectRepository;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AdatbazisbeadandoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdatbazisbeadandoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CompanyCarRepository companyCarRepository,
										CompanyPcRepository companyPcRepository,
										DepartmentRepository departmentRepository,
										EmployeeRepository employeeRepository,
										ProjectRepository projectRepository,
										MongoTemplate mongoTemplate) {
		return args -> {
			initializeDatabaseData(
					companyCarRepository,
					companyPcRepository,
					departmentRepository,
					employeeRepository,
					projectRepository,
					mongoTemplate);

			//Write your code here

			// Get 1 employee where the id is 1
			Employee john = employeeRepository.findById(1);
			System.out.println("Object john data: " + john);

			// Get all employees where the last name is "Connor"
			List<Employee> employeeList = employeeRepository.findByLastName("Connor");
			for (Employee employee : employeeList) {
				System.out.println("Object employee data: " + employee);
			}

			// Initialize the object
			Employee arnold = new Employee(
					4,
					new Name("a rno Ld ", " schwa rzene GGER"),
					new Address("Germany", "Waldorf", 56789),
					4);
			arnold.setProjectId(List.of(1,2));
			// Recommended to use try-catch block to handle duplicate key exception
			try {
				employeeRepository.insert(arnold);
				System.out.println("Inserted Employee with ID: " + arnold.getId());
			} catch (DuplicateKeyException duplicateKeyException) {
				System.out.println("Employee duplicate key exception occurred: " + duplicateKeyException.getCause().getMessage());
			}

			// Updates the arnold object projectId property in the DB by adding the list of the query parameter projectId
			mongoTemplate.updateFirst(new Query(Criteria.where("id").is(arnold.getId())), Update.update("projectId", employeeRepository.findById(1).getProjectId()), Employee.class);

			// Increments the budget property by 1000 for all Project objects, where the budget is greater than 4000
			mongoTemplate.updateMulti(new Query(Criteria.where("budget").gt(4000)), new Update().inc("budget", 1000), Project.class);

			// Adds an Integer list of employeeIds, where the employeeId is not null
			mongoTemplate.updateMulti(new Query(Criteria.where("id").ne(null)), Update.update("employeeId", List.of(1,4)), Project.class);

			// Remove those Project objects, where the budget is greater than 10000
			mongoTemplate.findAndRemove(new Query(Criteria.where("budget").gt(10000)), Project.class);

			// Get the full collection of "employee" objects
			MongoCollection<Document> employeeDocument = mongoTemplate.getCollection("employee");
			for (Document document : employeeDocument.find()) {
				System.out.println("employeeDocument: " + document.toString());
			}

			// Get those project where the employeeId is 1 is present
			List<Project> projectList = projectRepository.findByEmployeeId(1);

			//Write your code here
		};
	}

	private static void initializeDatabaseData(
			CompanyCarRepository companyCarRepository,
			CompanyPcRepository companyPcRepository,
			DepartmentRepository departmentRepository,
			EmployeeRepository employeeRepository,
			ProjectRepository projectRepository,
			MongoTemplate mongoTemplate) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").ne(null));

		CompanyCar ford = new CompanyCar(
				1,
				new CompanyCarManufacturer("Ford", "Focus", "White", 2012),
				"AAA-123");
		CompanyCar opel = new CompanyCar(
				2,
				new CompanyCarManufacturer("Opel", "Astra", "Grey", 2016),
				"BBB-123");

		List<CompanyCar> companyCarList = List.of(ford, opel);

		try {
			companyCarRepository.insert(companyCarList);
			System.out.println("Inserted CompanyCar with ID: " + companyCarList.stream().map(CompanyCar::getId).toList());
		} catch (DuplicateKeyException duplicateKeyException) {
			System.out.println("CompanyCar exception occurred: " + duplicateKeyException.getCause().getMessage());
		}

		CompanyPc companyPc1 = new CompanyPc(
				1,
				new CompanyPcManufacturer("Lenovo", "T15", LocalDate.of(2015, 5, 12)),
				"i5",
				16);
		CompanyPc companyPc2 = new CompanyPc(
				2,
				new CompanyPcManufacturer("Lenovo", "T470", LocalDate.of(2017, 6, 4)),
				"i3",
				8);
		CompanyPc companyPc3 = new CompanyPc(
				3,
				new CompanyPcManufacturer("Lenovo", "T570", LocalDate.of(2019, 3, 15)),
				"i5",
				8);
		CompanyPc companyPc4 = new CompanyPc(
				4,
				new CompanyPcManufacturer("Lenovo", "T15", LocalDate.of(2015, 5, 12)),
				"i5",
				16);

		List<CompanyPc> companyPcList = List.of(companyPc1, companyPc2, companyPc3, companyPc4);

		try {
			companyPcRepository.insert(companyPcList);
			System.out.println("Inserted CompanyPC with ID: " + companyPcList.stream().map(CompanyPc::getId).toList());
		} catch (DuplicateKeyException duplicateKeyException) {
			System.out.println("CompanyPc exception occurred: " + duplicateKeyException.getCause().getMessage());
		}

		Employee john = new Employee(
				1,
				new Name("John", "Connor"),
				new Address("Hungary", "Eger", 3300),
				companyPc1.getId());
		john.setCompanyCarId(ford.getId());
		Employee sarah = new Employee(
				2,
				new Name("Sarah", "Connor"),
				new Address("Hungary", "Miskolc", 3500),
				companyPc2.getId());
		Employee arthur = new Employee(
				3,
				new Name("Arthur", "Connor"),
				new Address("Hungary", "Eger", 3300),
				companyPc3.getId());
		arthur.setCompanyCarId(opel.getId());

		List<Employee> employeeList = List.of(john, sarah, arthur);

		try {
			employeeRepository.insert(employeeList);
			System.out.println("Inserted Employee with ID: " + employeeList.stream().map(Employee::getId).toList());
		} catch (DuplicateKeyException duplicateKeyException) {
			System.out.println("Employee exception occurred: " + duplicateKeyException.getCause().getMessage());
		}

		Project spring = new Project(
				1,
				"Spring",
				13000,
				List.of(john.getId()));
		Project mongodb = new Project(
				2,
				"MongoDB",
				5000,
				List.of(john.getId()));

		List<Project> projectList = List.of(spring, mongodb);

		try {
			projectRepository.insert(projectList);
			System.out.println("Inserted Project with ID: " + projectList.stream().map(Project::getId).toList());
		} catch (DuplicateKeyException duplicateKeyException) {
			System.out.println("Project exception occurred: " + duplicateKeyException.getCause().getMessage());
		}

		List<Integer> projectIdList = List.of(spring.getId(), mongodb.getId());
		john.setProjectId(projectIdList);
		mongoTemplate.updateFirst(new Query(Criteria.where("id").is(john.getId())), Update.update("projectId", projectIdList), Employee.class);

		Department development = new Department(
				1,
				"Development",
				List.of("Budapest", "Waldorf"),
				List.of(john.getId()),
				List.of(spring.getId(), mongodb.getId()));
		Department support = new Department(
				2,
				"Support",
				List.of("Budapest", "Miskolc"),
				List.of(arthur.getId()));
		Department hr = new Department(
				3,
				"HR",
				List.of("Budapest", "Waldorf"),
				List.of(sarah.getId()));
		Department development2 = new Department(
				1,
				"Development",
				List.of("Bud a Pes t", "W ald oRf"),
				List.of(john.getId()));
		List<Department> departmentList = List.of(development, support, hr);

		try {
			departmentRepository.insert(departmentList);
			System.out.println("Inserted Department with ID: " + departmentList.stream().map(Department::getId).toList());
		} catch (DuplicateKeyException duplicateKeyException) {
			System.out.println("Department exception occurred: " + duplicateKeyException.getCause().getMessage());
		}
	}

}
