package ma.enset.hospital1.repositories;

import ma.enset.hospital1.entities.Patient;
import ma.enset.hospital1.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {

}
