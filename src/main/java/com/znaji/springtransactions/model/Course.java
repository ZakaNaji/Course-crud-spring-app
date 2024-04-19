package com.znaji.springtransactions.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 10, max = 50, message = "Name should be between 10 and 50 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Duration is mandatory")
    @Size(min = 5, max = 20, message = "Duration should be between 5 and 20 characters")
    private String duration;

    @NotNull(message = "Fee is mandatory")
    @Min(value = 0, message = "Fee should be greater than 0")
    private double fee;

}
