package ma.enset.hospital1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RendezVous {

    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;

    // un Rendez_vous concerne un patient
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;

    // un Rendez_vous concerne egalement un medcin
    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
