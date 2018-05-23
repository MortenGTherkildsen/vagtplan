package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.Forbehold;
import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagtbehov;
import kea.aarsprojekt.vagtplan.model.Vagtplan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IVagtansvarligRepository {

    ArrayList<Medarbejder> visMedarbejderListe();
    void opretMedarbejder(Medarbejder medarbejder);
//    void opretMedarbejder(String username, String navn, String initialer, String telefonnummer, String visivagtplan, int medarbejderstatus, String uselog);
    void opdaterMedarbejder(String username, String navn, String initialer, String telefonnummer, String visivagtplan, int medarbejderstatus, String uselog);

    ArrayList<Forbehold> seForbeholdsListe(String username);
    ArrayList<Forbehold> seForbeholdsListe();
    void opretForbehold(Forbehold forbehold, String username);
    void redigerForbehold(Forbehold forbehold);

    ArrayList<Vagtbehov> visVagtbehovsListe();

    void opretVagtbehov(Vagtbehov vagtbehov);
    void redigerVagtbehov(Vagtbehov vagtbehov);

    Vagtplan visVagtplan(Medarbejder medarbejder, Vagtplan vagtplan);

    Vagtplan visVagtplan(int id);
    ArrayList<Vagtplan> visVagtplansListe();
    ArrayList<Vagtplan> opretVagtplan(Vagtplan vagtplan);
    Medarbejder getMedarbejder(String username);
    void opdaterMedarbejder (Medarbejder medarbejder);


}
