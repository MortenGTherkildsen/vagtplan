package kea.aarsprojekt.vagtplan.controller;

import kea.aarsprojekt.vagtplan.model.Forbehold;
import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagtbehov;
import kea.aarsprojekt.vagtplan.model.Vagtplan;
import kea.aarsprojekt.vagtplan.repository.IVagtansvarligRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class VagtansvarligController {


@Autowired
    private IVagtansvarligRepository vagtansvarligRepository;

    @GetMapping("/semedarbejderliste")
    public String medarbejderliste(Model model){
        model.addAttribute("medarbejderliste", vagtansvarligRepository.visMedarbejderListe());

        return "semedarbejderliste";
    }



    @GetMapping("/sevagtbehovsliste")
    public String vagtbehovsliste(Model model){
        model.addAttribute("vagtbehovsliste", vagtansvarligRepository.visVagtbehovsListe());
        return "sevagtbehovsliste";
    }
    @PostMapping("/sevagtbehovsliste")
    public String vagtbehovsliste(@ModelAttribute Vagtbehov vagtbehov){
        vagtansvarligRepository.opretVagtbehov(vagtbehov);
        return "sevagtbehovsliste";
    }

    @GetMapping("/vagtplansliste")
    public String vagtplansliste(Model model){
        model.addAttribute("vagtplansliste", vagtansvarligRepository.visVagtplansListe());
        return "vagtplansliste";
    }

    @GetMapping("/vagtplan")
    public String vagtplan(@RequestParam("id") int idv, Model model){
        model.addAttribute("/vagtplan="+idv, vagtansvarligRepository.visVagtplan(idv));
        return "vagtplan";
    }

    @PostMapping("/opretvagtplan")
    public String opretvagtplan(@ModelAttribute Vagtplan vagtplan){
        vagtansvarligRepository.opretVagtplan(vagtplan);
        return "vagtplan";
    }

    @GetMapping("vagtansvarlig")
    public String vagtansvarlig(Model model){
        return "vagtansvarlig";
    }

    @PostMapping("vagtansvarlig")
    public String vagtansvarligClick(Model model){
        return "redirect:/vagtansvarlig";
   }


    @GetMapping("/medarbejder")
    public  String medarbejder(@RequestParam("username") String username, Model model) {
        model.addAttribute("medarbejder", vagtansvarligRepository.getMedarbejder(username));
        model.addAttribute("forbeholdsliste", vagtansvarligRepository.seForbeholdsListe(username));

        return "medarbejder";
    }

    @GetMapping("/medarbejdermenu")
    public  String MedarbejderMenu(Model model) {

        return "medarbejdermenu";
    }

    @GetMapping("/forbeholdsliste")
    public String Forbeholdmenu (Model model){
         model.addAttribute("forbeholdsliste", vagtansvarligRepository.seForbeholdsListe());
        return "forbeholdsliste";
    }

//    @GetMapping("forbeholdsliste")
//    public String seForbeholdsliste (@RequestParam("username") String username, Model model){
//        model.addAttribute("/forbeholdsliste_for_"+ username, vagtansvarligRepository.seForbeholdsListe(username));
//
//        return "forbeholdsliste";
//
//    }

    @GetMapping("/opretforbehold")
    public String opretforbehold(Model model){
        Forbehold forbehold = new Forbehold();
        model.addAttribute("forbehold", forbehold);
        return "opretforbehold";
    }

    @PostMapping("/opretforbehold")
    public String opretforbeholdformedarbejder (@ModelAttribute("forbehold") Forbehold forbehold,
                                  @RequestParam("username") String username, Model model){

        Medarbejder medarbejder = vagtansvarligRepository.getMedarbejder(username);
        vagtansvarligRepository.opretForbehold(forbehold, medarbejder.getUsername());
       return "redirect:/medarbejder?=" + medarbejder.getUsername();
    }

    @GetMapping("opretvagtbehov")
    public String Vagtbehov (Model model) {
        return "opretvagtbehov";
    }

    @PostMapping ("opretvagtbehov")
    public String Vagtbehovlist (Model model){

        return "redirect:/sevagtbehovsliste";
    }

    @GetMapping("/opretmedarbejder")
    public String opret() {
        return "opretmedarbejder";
    }

    @PostMapping("/opretmedarbejder")
    public String getopret(@ModelAttribute Medarbejder medarbejder) {
        vagtansvarligRepository.opretMedarbejder(medarbejder);
        return "redirect:/semedarbejderliste";
    }

    @PostMapping("/opdatermedarbejder")
    public String opdater(@ModelAttribute Medarbejder medarbejder) {
        vagtansvarligRepository.opdaterMedarbejder(medarbejder);
        return "redirect:/semedarbejderliste";
    }

    @GetMapping("/opdatermedarbejder")
    public String opdater(@RequestParam("username") String username, Model model) {
        model.addAttribute("medarbejder", vagtansvarligRepository.getMedarbejder(username));
        return "opdatermedarbejder";
    }
}
