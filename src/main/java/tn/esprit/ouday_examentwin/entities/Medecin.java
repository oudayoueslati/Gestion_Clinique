package tn.esprit.ouday_examentwin.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Medecin  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private int telephone;
    private int prixConsultation;
    @ManyToMany(mappedBy = "medecins")
    Set<Clinique>cliniques;
    @OneToMany(mappedBy = "medecin")
    Set<RendezVous> rendezVous;
}
