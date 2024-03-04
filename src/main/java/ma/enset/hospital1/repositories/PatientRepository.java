package ma.enset.hospital1.repositories;

import ma.enset.hospital1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByNom(String Nom);
}
