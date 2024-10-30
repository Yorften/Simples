package com.simples.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Classroom entity in the application.
 */
@Entity
@Table(name = "classrooms")
@Data // Generates getters, setters, toString, equals, and hashCode methods.
@AllArgsConstructor // Generates a constructor with all arguments.
@NoArgsConstructor
@Builder // Generates a builder pattern for creating instances.
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Class room name shoudln't be empty")
    private String className;

    @NotNull(message = "Class number name shoudln't be empty")
    @Positive(message = "Class number must be positive")
    private int classNumber;

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    private Program program;

    @OneToMany
    @JoinColumn(name = "classroom_id")
    private List<Student> students;
}
