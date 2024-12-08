package tn.esprit.ouday_examentwin.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClinique;
    private String nomClinique;
    private String adresse;
    private int telephone;
    @ManyToMany
    Set<Medecin>medecins;
}
