// file path: backend/src/main/java/com/example/backend/model/School.java hence the package declaration is com.example.backend.model
package com.example.backend.model;

// jakarta.persistence is the package for JPA annotations, and lombok is used for generating boilerplate code like getters, setters, constructors, etc.
import jakarta.persistence.*;
import lombok.*;

// The @Entity annotation specifies that the class is an entity and is mapped to a database table.
// The @Data annotation is a convenient shortcut that bundles the features of @ToString, @EqualsAndHashCode, @Getter, @Setter, and @RequiredArgsConstructor together.
// The @NoArgsConstructor and @AllArgsConstructor annotations generate a no-argument constructor and an all-arguments constructor, respectively.
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

// The School class represents a school entity with various attributes such as name, address, phone number, email, and website. It uses JPA annotations to define the primary key and generation strategy for the ID field.
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation specifies that the ID should be generated automatically by the database using an identity column.
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
}