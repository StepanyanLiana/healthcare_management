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
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateTime;

    @ManyToOne
    //@Column(name = "patient_id")
    private Patient patient;

    @ManyToOne
    //@Column(name = "doctor_id")
    private Doctor doctor;

}
