package com.example.healthcare_management.controller;

import com.example.healthcare_management.entity.Appointment;
import com.example.healthcare_management.entity.Doctor;
import com.example.healthcare_management.entity.Patient;
import com.example.healthcare_management.repository.AppointmentRepository;
import com.example.healthcare_management.repository.DoctorRepository;
import com.example.healthcare_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public String appointmentPage(ModelMap modelMap) {
        List<Appointment> all = appointmentRepository.findAll();
        modelMap.addAttribute("appointments", all);
        return "appointments";
    }

    @GetMapping("/add")
    public String addAppointmentPage(ModelMap modelMap){
        List<Doctor> all = doctorRepository.findAll();
        modelMap.addAttribute("doctors", all);
        List<Patient> allPatient = patientRepository.findAll();
        modelMap.addAttribute("patients", allPatient);
        return "addAppointment";
    }

    @PostMapping ("/add")
    public String addAppointment(@ModelAttribute Appointment appointment){
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/remove")
    public String removePatient(@RequestParam("id") int id){
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }

}
