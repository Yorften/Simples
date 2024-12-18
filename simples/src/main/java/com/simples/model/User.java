package com.simples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Represents a User entity in the application.
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data // Generates getters, setters, toString, equals, and hashCode methods.
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User first name shoudln't be empty")
    private String firstName;

    @NotBlank(message = "User last name shoudln't be empty")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "User email shoudln't be empty")
    @Column(unique = true)
    private String email;
}
