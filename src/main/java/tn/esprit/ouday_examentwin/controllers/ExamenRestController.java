package tn.esprit.ouday_examentwin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ouday_examentwin.entities.*;
import tn.esprit.ouday_examentwin.services.IexamenService;

import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class ExamenRestController {
    private final IexamenService examenService;

    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique){
        return examenService.addClinique(clinique);
    }
    @PostMapping("/addMedecinAndAssignToClinique/{idClinique}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long idClinique) {
        return examenService.addMedecinAndAssignToClinique(medecin, idClinique);
    }
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return examenService.addPatient(patient);
    }
    @PostMapping("/addRDVandAssignMedAndPatient/{idMedecin}/{idPatient}")
    public RendezVous addRDVandAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable Long idMedecin,@PathVariable Long idPatient){
        return examenService.addRDVandAssignMedAndPatient(rdv, idMedecin, idPatient);
    }
    @GetMapping("getRendezVousByCliniqueAndSpecialite/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @PathVariable Specialite specialite){
        return examenService.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }
    @GetMapping("getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin){
        return examenService.getNbrRendezVousMedecin(idMedecin);
    }
    @GetMapping("/getRevenuMedecin/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable Long idMedecin,@PathVariable Date startDate,@PathVariable Date endDate){
        return examenService.getRevenuMedecin(idMedecin, startDate, endDate);
    }
}
