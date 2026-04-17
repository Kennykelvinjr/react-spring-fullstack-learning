// file path: backend/src/main/java/com/example/backend/service/SchoolService.java hence the package declaration is com.example.backend.service
package com.example.backend.service;

// The SchoolService class is a service layer component that provides methods for performing CRUD operations on the School entity. It uses the SchoolRepository to interact with the database and is annotated with @Service to indicate that it's a service component in the Spring framework.
import com.example.backend.model.School;
import com.example.backend.repository.SchoolRepository;
import org.springframework.stereotype.Service;

// The SchoolService class provides methods to create, read, update, and delete School entities. It uses the SchoolRepository to perform these operations, and it handles any necessary business logic or error handling related to these operations.
import java.util.List;
import java.util.Optional;

// The @Service annotation indicates that this class is a service component in the Spring framework, which is a specialization of the @Component annotation. It is used to indicate that this class contains business logic and can be automatically detected through classpath scanning.
@Service
public class SchoolService {

    // The SchoolRepository is injected into the SchoolService through constructor injection. This allows the service to use the repository to perform database operations on the School entity.
    private final SchoolRepository repository;

    // Constructor for SchoolService that takes a SchoolRepository as a parameter. This is where the repository is injected into the service, allowing it to perform database operations.
    public SchoolService(SchoolRepository repository) {
        this.repository = repository;
    }

    // Create
    public School saveSchool(School school) {
        return repository.save(school);
    }

    // Read all
    public List<School> getAllSchools() {
        return repository.findAll();
    }

    // Read one
    public Optional<School> getSchoolById(Long id) {
        return repository.findById(id);
    }

    // Update
    public School updateSchool(Long id, School schoolDetails) {
        School school = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));

        school.setName(schoolDetails.getName());
        school.setAddress(schoolDetails.getAddress());
        school.setPhoneNumber(schoolDetails.getPhoneNumber());
        school.setEmail(schoolDetails.getEmail());
        school.setWebsite(schoolDetails.getWebsite());

        return repository.save(school);
    }

    // Delete
    public void deleteSchool(Long id) {
        repository.deleteById(id);
    }
}
