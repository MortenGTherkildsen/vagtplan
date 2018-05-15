package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class VagtansvarligRepository extends MedarbejderRepository implements IVagtansvarligRepository, IMedarbejderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    SqlRowSet sqlRowSet;

    @Override
    public void readAll(){

    }


    @Override
    public ArrayList<Medarbejder> visMedarbejderListe(){
        ArrayList<Medarbejder> medarbejderListe = new ArrayList<>();

        String sql = "SELECT * FROM vagtplantestdb.medarbejdere";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()) {

                medarbejderListe.add(new Medarbejder(sqlRowSet.getString("username"),
                    sqlRowSet.getString("password"),
                    sqlRowSet.getString("navn"),
                    sqlRowSet.getString("initialer"),
                    sqlRowSet.getString("telefonnummer"),
                    sqlRowSet.getInt("visivagtplan"),
                    sqlRowSet.getInt("medarbejderstatus"),
                    sqlRowSet.getString("uselog"),
                    sqlRowSet.getInt("ervagtansvarlig"),
                    sqlRowSet.getString("vagtansvarligsemail"))
            );
        }

        return medarbejderListe;
    }

    @Override
    public void opretMedarbejder(String user){

        String sql= "INSERT INTO medarbejdere(username) VALUES ("+ user + "); SELECT LAST_INSERT_ID();";

        jdbcTemplate.execute(sql);

    }

    public void opretMedarbejder(Medarbejder medarbejder){

        String sql= "INSERT INTO medarbejdere(username) VALUES ("+ medarbejder.getUsername() + "); SELECT LAST_INSERT_ID();";

        jdbcTemplate.execute(sql);

    }

    @Override
    public void opdaterMedarbejder(Medarbejder medarbejder){

    }

    @Override
    public ArrayList<Vagtbehov> visVagtbehovsListe(){
        ArrayList<Vagtbehov> vagtbehovsListe = new ArrayList<>();

        //Populér vagtbehovslisten med sql-kald

        return vagtbehovsListe;
    }

    @Override
    public void opretVagtbehov(Vagtbehov vagtbehov){

    }

    @Override
    public void redigerVagtbehov(Vagtbehov vagtbehov){

    }

    @Override
    public ArrayList<Vagtplan> visVagtplansListe(){
        ArrayList<Vagtplan> vagtplansListe = new ArrayList<>();

        return vagtplansListe;
    }

    @Override
    public void opretVagtplan(){

    }

    @Override
    public Vagtplan visVagtplan(){

        Vagtplan vagtplan = new Vagtplan();
        //Populér hele den store vagtplan for alle medarbejdere med sql-statements.

        return vagtplan;
    }

    @Override
    public ArrayList<Vagt> visVagtplan(Medarbejder medarbejder){

        ArrayList<Vagt> vagtListe = new ArrayList<>();

        //Populér den enkelte medarbejders egen vagtliste med sql-statement.

        return vagtListe;
    }

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
}
