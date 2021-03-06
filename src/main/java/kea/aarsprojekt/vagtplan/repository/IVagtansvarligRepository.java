package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.Forbehold;
import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagtbehov;
import kea.aarsprojekt.vagtplan.model.Vagtplan;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface IVagtansvarligRepository {

    ArrayList<Medarbejder> visMedarbejderListe();
    void opretMedarbejder(Medarbejder medarbejder) throws SQLException;
    ArrayList<Forbehold> seForbeholdsListe(String username);
    ArrayList<Forbehold> seForbeholdsListe();
    void opretForbehold(Forbehold forbehold, String username);
    void redigerForbehold(Forbehold forbehold);
    void slet(String username);
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
