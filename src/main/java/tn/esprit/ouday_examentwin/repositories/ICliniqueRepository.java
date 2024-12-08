package tn.esprit.ouday_examentwin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ouday_examentwin.entities.Clinique;

public interface ICliniqueRepository extends JpaRepository<Clinique, Long> {
}
