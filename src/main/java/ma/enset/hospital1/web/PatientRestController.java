package ma.enset.hospital1.web;

import ma.enset.hospital1.entities.Patient;
import ma.enset.hospital1.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> PatientList(){

        return patientRepository.findAll();
    }
}
