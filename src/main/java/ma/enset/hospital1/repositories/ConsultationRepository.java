package ma.enset.hospital1.repositories;

import ma.enset.hospital1.entities.Consultation;
import ma.enset.hospital1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
