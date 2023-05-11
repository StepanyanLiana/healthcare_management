package com.example.healthcare_management.controller;

import com.example.healthcare_management.entity.Doctor;
import com.example.healthcare_management.entity.Patient;
import com.example.healthcare_management.repository.DoctorRepository;
import com.example.healthcare_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public String patientPage(ModelMap modelMap) {
        List<Patient> all = patientRepository.findAll();
        modelMap.addAttribute("patients", all);
        return "patients";
    }

    @GetMapping("/add")
    public String addPatientPage(){
        return "addPatient";
    }

    @PostMapping ("/add")
    public String addPatient(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/remove")
    public String removePatient(@RequestParam("id") int id){
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }

}
