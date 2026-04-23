// file path: backend/src/main/java/com/example/backend/controller/SchoolController.java hence the package declaration is com.example.backend.controller
package com.example.backend.controller;

// The SchoolController class is a REST controller that handles HTTP requests related to the School entity. It uses the SchoolService to perform CRUD operations and is annotated with @RestController and @RequestMapping to define the base URL for the endpoints.
import com.example.backend.model.School;
import com.example.backend.service.SchoolService;
import org.springframework.web.bind.annotation.*;

// The @RestController annotation is a convenience annotation that combines @Controller and @ResponseBody, indicating that this class will handle HTTP requests and return responses in a RESTful manner. The @RequestMapping annotation at the class level defines the base URL for all endpoints in this controller, which is "/api/schools" in this case.
import java.util.List;

// The SchoolController class provides endpoints for creating, reading, updating, and deleting School entities. Each method is mapped to a specific HTTP method (POST, GET, PUT, DELETE) and URL pattern to handle the corresponding CRUD operation.
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    // The SchoolService is injected into the SchoolController through constructor injection. This allows the controller to use the service to perform business logic and interact with the database through the service layer.
    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public School createSchool(@RequestBody School school) {
        return service.saveSchool(school);
    }

    // READ ALL
    @GetMapping
    public List<School> getAllSchools() {
        return service.getAllSchools();
    }

    // READ ONE
    @GetMapping("/{id}")
    public School getSchool(@PathVariable Long id) {
        return service.getSchoolById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        return service.updateSchool(id, school);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        service.deleteSchool(id);
    }
}