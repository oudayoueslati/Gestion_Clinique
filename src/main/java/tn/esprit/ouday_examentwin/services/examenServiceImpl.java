package tn.esprit.ouday_examentwin.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ouday_examentwin.entities.*;
import tn.esprit.ouday_examentwin.repositories.*;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class examenServiceImpl implements IexamenService {

    private final ICliniqueRepository cliniqueRepository;
    private final IMedecinRepository medecinRepository;
    private final IRendezVousRepository rendezVousRepository;
    private final IPatientRepository patientRepository;


    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long idClinique) {
        Clinique c = cliniqueRepository.findById(idClinique).orElse(null);
        List<Medecin> list = new ArrayList<>();
        list.add(medecin);
        if (c.getMedecins() == null) {
            c.setMedecins((Set<Medecin>) list);
        } else {
            c.getMedecins().add(medecin);
        }
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @JsonIgnore
    @Override
    public RendezVous addRDVandAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        Patient p = patientRepository.findById(idPatient).orElse(null);
        rdv.setMedecin(m);
        rdv.setPatient(p);
        return rendezVousRepository.save(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        Clinique c = cliniqueRepository.findById(idClinique).orElse(null);
        List<RendezVous> list = rendezVousRepository.findAll();
        List<RendezVous> resultat = new ArrayList<>();
        for (RendezVous r : list) {
            Medecin m = r.getMedecin();
            if (m.getCliniques() != null) {
                for (Clinique c1 : m.getCliniques()) {
                    if (c.equals(c1) && m.getSpecialite().equals(specialite)) {
                        resultat.add(r);
                    }
                }

            }
        }
        return resultat;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        int nb = 0;
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        List<RendezVous> list = rendezVousRepository.findAll();
        for (RendezVous r : list) {
            if (r.getMedecin().equals(m)) {
                nb++;
            }
        }
        return nb;
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        int nb = 0;
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        List<RendezVous> list = rendezVousRepository.findAll();
        for (RendezVous r : list) {
            if (r.getMedecin().equals(m) && r.getDateRDV().after(startDate) && r.getDateRDV().before(endDate)) {
                nb++;
            }
        }
            return m.getPrixConsultation() * nb;
        }


        @Scheduled(cron = "*/30 * * * * *")
        public void retreiveRendezVous () {
            List<RendezVous> list = rendezVousRepository.findAll();
            for (RendezVous r : list) {
                if (r.getDateRDV().after(new Date())) {
                    log.info("la liste des  RendezVous:" + r.getDateRDV() + ":Medecin" + r.getMedecin().getNomMedecin()
                            + "Patient" + r.getPatient().getNomPatient());
                }
            }
        }

    }



