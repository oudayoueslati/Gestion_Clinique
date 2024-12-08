package tn.esprit.ouday_examentwin.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String nomPatient;
    private int telephone;
    private Date dateNaissance;
    @OneToMany(mappedBy = "patient")
    Set<RendezVous> rendezVous;
}
