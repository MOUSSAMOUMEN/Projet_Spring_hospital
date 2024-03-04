package ma.enset.hospital1.service;

import ma.enset.hospital1.entities.Consultation;
import ma.enset.hospital1.entities.Medecin;
import ma.enset.hospital1.entities.Patient;
import ma.enset.hospital1.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedcin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
