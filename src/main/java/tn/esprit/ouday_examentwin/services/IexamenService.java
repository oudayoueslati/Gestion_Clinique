package tn.esprit.ouday_examentwin.services;

import tn.esprit.ouday_examentwin.entities.*;

import java.util.Date;
import java.util.List;

public interface IexamenService {
     Clinique addClinique(Clinique clinique);
     Medecin addMedecinAndAssignToClinique(Medecin medecin,Long idClinique);
     Patient addPatient(Patient patient);
     RendezVous addRDVandAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);
     List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
     int getNbrRendezVousMedecin(Long idMedecin);
     int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
