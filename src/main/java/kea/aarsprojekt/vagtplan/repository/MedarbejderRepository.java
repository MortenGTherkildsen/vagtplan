package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.Forbehold;
import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MedarbejderRepository implements IMedarbejderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<Forbehold> seMineForbehold(Medarbejder medarbejder){

        ArrayList<Forbehold> forbeholdsListe = new ArrayList<>();

        //Populér forbeholdsliste med sql-kald

        return forbeholdsListe;
    }

    @Override
    public void opretForbehold(Forbehold forbehold){

    }
    @Override
    public void redigerForbehold(Forbehold forbehold){

    }

    @Override
    public ArrayList<Vagt> visVagtplan(Medarbejder medarbejder){

        ArrayList<Vagt> vagtListe = new ArrayList<>();

        //Populér den enkelte medarbejders egen vagtliste med sql-statement.

        return vagtListe;
    }


}
