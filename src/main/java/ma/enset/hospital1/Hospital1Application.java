package ma.enset.hospital1;

import lombok.Data;
import ma.enset.hospital1.entities.*;
import ma.enset.hospital1.repositories.ConsultationRepository;
import ma.enset.hospital1.repositories.MedecinRepository;
import ma.enset.hospital1.repositories.PatientRepository;
import ma.enset.hospital1.repositories.RendezVousRepository;
import ma.enset.hospital1.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Hospital1Application {
	public static void main(String[] args) {

		SpringApplication.run(Hospital1Application.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){

		return args -> {

			//ajouter des patients au table Patient

			Stream.of("MOHAMED","HASSAN","NAJAT","OUMAIMA","HAJAR")

					.forEach(name ->{

						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);

					});

			//ajouter des medecines au table Medecin
			Stream.of("Aymene","Hanane","Yasmine","Moussa","Ahmed")

					.forEach(name ->{
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedcin(medecin);

					});

			Patient patient=patientRepository.findByNom("MOHAMED");
			Medecin medecin=medecinRepository.findByNom("Yasmine");

			// cree un rendez_vous

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			//randomUUID() genere une chaine de caractere aleatoire
			rendezVous.setId(UUID.randomUUID().toString());
			RendezVous savedRDV=hospitalService.saveRDV(rendezVous);
			System.out.println(savedRDV.getId());

			// cree un new Consultation

			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
			Consultation consultation=new Consultation();

			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de  la consultation.....");
			hospitalService.saveConsultation(consultation);

		};
	}

}
