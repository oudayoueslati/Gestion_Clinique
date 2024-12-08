package tn.esprit.ouday_examentwin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ouday_examentwin.entities.Patient;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
}
