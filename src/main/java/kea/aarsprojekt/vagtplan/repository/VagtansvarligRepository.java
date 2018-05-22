package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VagtansvarligRepository extends MedarbejderRepository implements IVagtansvarligRepository, IMedarbejderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    SqlRowSet sqlRowSet, sqlRowSet2;

    @Override
    public void readAll(){

    }

    //*******************************************
    //MEDARBEJDERE
    //*******************************************
    @Override
    public ArrayList<Medarbejder> visMedarbejderListe(){
        ArrayList<Medarbejder> medarbejderliste = new ArrayList<>();

        String sql = "SELECT * FROM vagtplantestdb.medarbejdere";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()) {
                ArrayList<Forbehold> forbeholdsliste = new ArrayList<>();
//                String sql_forbehold = "SELECT * FROM vagtplantestdb.forbehold";
//                sqlRowSet2 = jdbcTemplate.queryForRowSet(sql_forbehold);

            medarbejderliste.add(new Medarbejder(sqlRowSet.getString("username"),
                    sqlRowSet.getString("password"),
                    sqlRowSet.getString("role"),
                    sqlRowSet.getString("navn"),
                    sqlRowSet.getString("initialer"),
                    sqlRowSet.getString("telefonnummer"),
                    sqlRowSet.getString("visivagtplan"),
                    sqlRowSet.getInt("medarbejderstatus"),
                    sqlRowSet.getString("uselog"),
                    sqlRowSet.getString("vagtansvarligsemail"), forbeholdsliste)
                );
        }

        return medarbejderliste;
    }

    @Override
    public void opretMedarbejder(String user){

        String sql= "INSERT INTO medarbejdere(username) VALUES ("+ user + "); SELECT LAST_INSERT_ID();";

        jdbcTemplate.execute(sql);
    }

    @Override
    public void opretMedarbejder(Medarbejder medarbejder){

        String sql= "INSERT INTO medarbejdere(username) VALUES ("+ medarbejder.getUsername() + "); SELECT LAST_INSERT_ID();";

        jdbcTemplate.execute(sql);
    }

    @Override
    public Medarbejder getMedarbejder(String username){
        ArrayList<Medarbejder> medarbejderList = new ArrayList<>();
        ArrayList<Forbehold> forbeholdList = new ArrayList<>();
        String sql = "SELECT * FROM vagtplantestdb.medarbejdere WHERE username='"+username+"'";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            return  new Medarbejder(sqlRowSet.getString("username"),
                    sqlRowSet.getString("password"),
                    sqlRowSet.getString("role"),
                    sqlRowSet.getString("navn"),
                    sqlRowSet.getString("initialer"),
                    sqlRowSet.getString("telefonnummer"),
                    sqlRowSet.getString("visivagtplan"),
                    sqlRowSet.getInt("medarbejderstatus"),
                    sqlRowSet.getString("uselog"),
                    sqlRowSet.getString("vagtansvarligsemail"),
                    forbeholdList);
        }
        return null;
    }

    @Override
    public void opdaterMedarbejder(Medarbejder medarbejder){

        jdbcTemplate.update("UPDATE vagtplantestdb.medarbejdere SET "
                +"navn ='" + medarbejder.getName() + "' , "
                +"initialer='" + medarbejder.getInitialer() +"' , "
                +"telefonnummer ='" +medarbejder.getTelefonnummer()+"' , "
                +"visivagtplan ='" +medarbejder.getVisIVagtplan() + "' , "
                +"uselog ='" + medarbejder.getUselog()
                +"' WHERE username = '" + medarbejder.getUsername()+"'");

    }

    //*******************************************
    //VAGTBEHOV
    //*******************************************
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

    //*******************************************
    //VAGTPLAN
    //*******************************************
    @Override
    public ArrayList<Vagtplan> visVagtplansListe(){
        ArrayList<Vagtplan> vagtplansListe = new ArrayList<>();
        ArrayList<Vagt> vagtliste = new ArrayList<>();

        String sql = "SELECT * FROM vagtplantestdb.vagtplaner";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);


        while (sqlRowSet.next()){
            vagtplansListe.add(new Vagtplan(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("titel"),
                    sqlRowSet.getDate("fra"),
                    sqlRowSet.getDate("til"),
                    sqlRowSet.getString("kommentar"),
                    vagtliste
            ));
        }
        return vagtplansListe;
    }

    @Override
    public ArrayList<Vagtplan> opretVagtplan(Vagtplan vagtplan){

        ArrayList<Vagtplan> vagtplansListe = visVagtplansListe();
        vagtplansListe.add(vagtplan);
        return vagtplansListe;
    }

    @Override
    public Vagtplan visVagtplan(int id){

        //Populér hele den store vagtplan for alle medarbejdere med sql-statements.

        Vagtplan vagtplan = new Vagtplan(id);
        return vagtplan;
    }

    @Override
    public ArrayList<Vagt> visVagtplan(Medarbejder medarbejder){

        ArrayList<Vagt> vagtListe = new ArrayList<>();

        //Populér den enkelte medarbejders egen vagtliste med sql-statement.

        return vagtListe;
    }

    //*******************************************
    //FORBEHOLD
    //Medarbejderens liste over forbehold bliver populeret ovenfor under MEDARBEJDER
    //*******************************************

    @Override
    public void opretForbehold(Forbehold forbehold){

    }

    @Override
    public void redigerForbehold(Forbehold forbehold){

    }
}
