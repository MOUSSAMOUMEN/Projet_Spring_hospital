package ma.enset.hospital1.repositories;

import ma.enset.hospital1.entities.Medecin;
import ma.enset.hospital1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    Medecin findByNom(String Nom);
}
