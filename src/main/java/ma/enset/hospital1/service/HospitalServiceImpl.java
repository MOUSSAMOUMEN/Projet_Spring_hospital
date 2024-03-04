package ma.enset.hospital1.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital1.entities.Consultation;
import ma.enset.hospital1.entities.Medecin;
import ma.enset.hospital1.entities.Patient;
import ma.enset.hospital1.entities.RendezVous;
import ma.enset.hospital1.repositories.ConsultationRepository;
import ma.enset.hospital1.repositories.MedecinRepository;
import ma.enset.hospital1.repositories.PatientRepository;
import ma.enset.hospital1.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    //declaration des interfaces
    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    RendezVousRepository rendezVousRepository;
    ConsultationRepository consultationRepository;

    //generer un constructeur aux parametres

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedcin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
