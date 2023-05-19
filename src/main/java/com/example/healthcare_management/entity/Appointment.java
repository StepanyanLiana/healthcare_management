package com.example.healthcare_management.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "appointment")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
    
    @ManyToOne
    private User user;

}
