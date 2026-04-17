// file path: backend/src/main/java/com/example/backend/repository/SchoolRepository.java hence the package declaration is com.example.backend.repository
package com.example.backend.repository;

// The SchoolRepository interface extends JpaRepository, which provides CRUD operations for the School entity. The JpaRepository takes two parameters: the type of the entity (School) and the type of the entity's primary key (Long).
import com.example.backend.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

// The @Repository annotation is not strictly necessary when extending JpaRepository, as Spring Data JPA will automatically recognize it as a repository. However, it can be added for clarity and to enable exception translation.
public interface SchoolRepository extends JpaRepository<School, Long> {
    // You can define custom query methods here if needed, for example:
    // List<School> findByName(String name);
    // This interface will allow you to perform CRUD operations on the School entity without needing to write any implementation code, as Spring Data JPA will provide the implementation at runtime.
}