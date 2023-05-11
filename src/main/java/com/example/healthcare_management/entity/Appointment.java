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

   // @Column(name = "patient_id")
    @ManyToOne
    private Patient patientId;

    //@Column(name = "doctor_id")
    @ManyToOne
    private Doctor doctorId;

}
