package tn.esprit.ouday_examentwin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ouday_examentwin.entities.Medecin;

public interface IMedecinRepository extends JpaRepository<Medecin, Long> {
}
