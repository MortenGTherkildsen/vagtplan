package kea.aarsprojekt.vagtplan.controller;

import kea.aarsprojekt.vagtplan.repository.IMedarbejderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedarbejderController {

@Autowired
    IMedarbejderRepository medarbejderRepository;

    @GetMapping("/seforbeholdsliste")
    public String seforbeholdsliste(Model model){
        model.addAttribute("forbeholdsliste", medarbejderRepository.seForbeholdsListe());
        return "seforbeholdsliste";
    }
}
