package com.example.healthcare_management.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String specialty;
    @Column(name = "profile_pic")
    private String profilePic;
}
