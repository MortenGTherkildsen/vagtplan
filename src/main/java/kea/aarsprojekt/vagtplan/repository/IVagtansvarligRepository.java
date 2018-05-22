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
    //void opdaterMedarbejder(String username, String navn, String initialer, String telefonnummer, String visivagtplan, int medarbejderstatus, String uselog);
    ArrayList<Vagtbehov> visVagtbehovsListe();
    void opretVagtbehov(Vagtbehov vagtbehov);
    void redigerVagtbehov(Vagtbehov vagtbehov);
    ArrayList<Vagtplan> visVagtplansListe();
    Vagtplan visVagtplan(int id);
    ArrayList<Vagtplan> opretVagtplan(Vagtplan vagtplan);
    Medarbejder getMedarbejder(String username);
    void opdaterMedarbejder(Medarbejder medarbejder);

}
