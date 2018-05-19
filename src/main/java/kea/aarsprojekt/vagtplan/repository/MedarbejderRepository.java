package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.Forbehold;
import kea.aarsprojekt.vagtplan.model.Medarbejder;
import kea.aarsprojekt.vagtplan.model.Vagt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MedarbejderRepository implements IMedarbejderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    SqlRowSet sqlRowSet;

    @Override
    public ArrayList<Forbehold> seForbeholdsListe(){

        ArrayList<Forbehold> forbeholdsliste = new ArrayList<>();

        //Populér forbeholdsliste med sql-kald
        String sql = "SELECT * from vagtplantestdb.forbehold";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()){
            forbeholdsliste.add(new Forbehold(
                    sqlRowSet.getString("fra_string"),
                    sqlRowSet.getString("til_string"),
                    sqlRowSet.getBoolean("accepteretAfVagtansvarlig"),
                    sqlRowSet.getString("kommentar")

            ));
        }
        return forbeholdsliste;
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
