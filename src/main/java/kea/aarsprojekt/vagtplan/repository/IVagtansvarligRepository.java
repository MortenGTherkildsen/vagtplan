package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.Forbehold;
import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagtbehov;
import kea.aarsprojekt.vagtplan.model.Vagtplan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IVagtansvarligRepository extends IMedarbejderRepository{


    void readAll();
    ArrayList<Medarbejder> visMedarbejderListe();
    void opretMedarbejder(String username);
    void opretMedarbejder(Medarbejder medarbejder);
    void opdaterMedarbejder(Medarbejder medarbejder);
     ArrayList<Vagtbehov> visVagtbehovsListe();
    void opretVagtbehov(Vagtbehov vagtbehov);
    void redigerVagtbehov(Vagtbehov vagtbehov);
    // void seVagtbehov(Vagtbehov vagtbehov); Morten: Mener den er overflødig pga "inline-edit" funktionalitet
    ArrayList<Vagtplan> visVagtplansListe();
    Vagtplan visVagtplan();
    ArrayList<Vagtplan> opretVagtplan(Vagtplan vagtplan);

}
