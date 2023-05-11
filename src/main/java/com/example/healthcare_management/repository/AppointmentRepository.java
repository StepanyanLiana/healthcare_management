package com.example.healthcare_management.repository;

import com.example.healthcare_management.entity.Appointment;
import com.example.healthcare_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
