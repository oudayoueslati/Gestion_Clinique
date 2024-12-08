package tn.esprit.ouday_examentwin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;
    private Date dateRDV;
    private String remarque;
    @ManyToOne
    Medecin medecin;
    @ManyToOne
    Patient patient;

}
