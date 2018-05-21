package kea.aarsprojekt.vagtplan.controller;

import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagtbehov;
import kea.aarsprojekt.vagtplan.model.Vagtplan;
import kea.aarsprojekt.vagtplan.repository.IMedarbejderRepository;
import kea.aarsprojekt.vagtplan.repository.IVagtansvarligRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VagtansvarligController extends MedarbejderController {


@Autowired
    private IVagtansvarligRepository vagtansvarligRepository;

//    @GetMapping("/vagtansvarlig")
//    public String index(Model model){
//        model.addAttribute("vagtplanliste", vagtansvarligRepository.visVagtplansListe());
//        model.addAttribute("medarbejderliste", vagtansvarligRepository.visMedarbejderListe());
//        model.addAttribute("vagtbehovsliste", vagtansvarligRepository.visVagtbehovsListe());
//        return "vagtansvarlig";
//    }

    @GetMapping("/semedarbejderliste")
    public String medarbejderliste(Model model){
        model.addAttribute("medarbejderliste", vagtansvarligRepository.visMedarbejderListe());
        return "semedarbejderliste";
    }

    @PostMapping("/semedarbejderliste")
    public String medarbejderliste(@RequestParam("username") String user, Medarbejder medarbejder){
        vagtansvarligRepository.opretMedarbejder(user);
        return "redirect:/semedarbejderliste";
    }

    @GetMapping("/semedarbejder")
    public String semedarbejder(@RequestParam("username") String username, Model model){
        model.addAttribute("medarbejder", vagtansvarligRepository.getMedarbejder(username));

        return "semedarbejder";
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
    public String vagtplan(Model model){
        model.addAttribute("vagtplan", vagtansvarligRepository.visVagtplan());
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


    @GetMapping("medarbejder")
    public  String MedarbejderMenu(Model model) {

        return "medarbejder";

    }
    @GetMapping("opretforbehold")
    public String Forbeholdmenu (Model model){
        // model.addAttribute("forbehold",medarbejderRepository.seMineForbehold());
        return "opretforbehold";
    }
    @PostMapping("opretforbehold")
    public String Forbeholdmenu1 (Model model){
        return "opretforbehold";
    }
    @GetMapping("opretvagtbehov")
    public String Vagtbehov (Model model) {
        return "opretvagtbehov";
    }
    @PostMapping ("opretvagtbehov")
    public String Vagtbehovlist (Model model){
        return "redirect:/sevagtbehovsliste";
    }
}
