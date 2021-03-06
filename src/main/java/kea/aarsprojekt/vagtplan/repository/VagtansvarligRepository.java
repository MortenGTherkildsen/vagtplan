package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class VagtansvarligRepository implements IVagtansvarligRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    SqlRowSet sqlRowSet;

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

    public void opretMedarbejder(Medarbejder medarbejder) throws SQLException{

        String sql = "INSERT INTO vagtplantestdb.medarbejdere " +
                "(username, password, role, navn, initialer, telefonnummer, " +
                "visivagtplan, medarbejderstatus, vagtansvarligsemail) VALUES (?,?,?,?,?,?,?,?,?)";

        Object[] args = {medarbejder.getUsername(), medarbejder.getPassword(), "medarbejder", medarbejder.getName(), medarbejder.getInitialer(), medarbejder. getTelefonnummer(), medarbejder.getVisIVagtplan(), medarbejder.getUselog(), medarbejder.getMinVagtansvarlige()};

        jdbcTemplate.update(sql, args);
    }

    @Override
    public Medarbejder getMedarbejder(String username){

        String sql = "SELECT * FROM vagtplantestdb.medarbejdere WHERE username='" + username + "'";

        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        ArrayList<Forbehold> forbeholdsliste = new ArrayList<>();

        while (sqlRowSet.next()) {
            return new Medarbejder(sqlRowSet.getString("username"),
                    sqlRowSet.getString("password"),
                    sqlRowSet.getString("role"),
                    sqlRowSet.getString("navn"),
                    sqlRowSet.getString("initialer"),
                    sqlRowSet.getString("telefonnummer"),
                    sqlRowSet.getString("visivagtplan"),
                    sqlRowSet.getInt("medarbejderstatus"),
                    sqlRowSet.getString("uselog"),
                    sqlRowSet.getString("vagtansvarligsemail"), forbeholdsliste);

        }
        return null;
    }

    public void opdaterMedarbejder(Medarbejder medarbejder){
        jdbcTemplate.update("UPDATE vagtplantestdb.medarbejdere SET " +
                "navn ='" + medarbejder.getName() + "' , "+
                "initialer='" + medarbejder.getInitialer() +"' , "+
                "telefonnummer ='" + medarbejder.getTelefonnummer() +"' , "+
                "visivagtplan ='" + medarbejder.getVisIVagtplan() + "' , "+
                "medarbejderstatus ='" + medarbejder.getMedarbejderStatus() + "' , "+
                "uselog ='" + medarbejder.getUselog()+
                "' WHERE username = '" + medarbejder.getUsername() + "'");
    }
    @Override
    public void slet(String username) {

        jdbcTemplate.update("DELETE FROM vagtplantestdb.medarbejdere WHERE medarbejdere.username='" + username + "'");
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
                    sqlRowSet.getDate("fra").toLocalDate(),
                    sqlRowSet.getDate("til").toLocalDate(),
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

        String sql = "SELECT * FROM vagtplantestdb.vagtplaner WHERE username='"+ id + "'";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        ArrayList<Vagt> vagtliste = new ArrayList<>();

        Vagtplan vagtplan = new Vagtplan();

        while (sqlRowSet.next()){vagtplan = new Vagtplan(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getString("titel"),
                    sqlRowSet.getDate("fra").toLocalDate(),
                    sqlRowSet.getDate("til").toLocalDate(),
                    sqlRowSet.getString("kommentar"),
                    vagtliste
            );

//        for(int i = 0; i ++; vagtplan.getDuration(vagtplan.getTil(), vagtplan.getFra())) {
//
//
//            String sql = "SELECT * FROM vagtplantestdb.vagter WHERE id=" + vagtplan.getId() + "'";
//            sqlRowSet = jdbcTemplate.queryForRowSet(sql);
//        }
        }

        return vagtplan;
    }

    @Override
    public Vagtplan visVagtplan(Medarbejder medarbejder, Vagtplan vagtplan){


        Vagtplan vagtplan1;

        //Populér den enkelte medarbejders egen vagtliste med sql-statement.

        return vagtplan;
    }

    //*******************************************
    //FORBEHOLD
    //Medarbejderens liste over forbehold bliver populeret ovenfor under MEDARBEJDER
    //*******************************************

    @Override
    public ArrayList<Forbehold> seForbeholdsListe(){
        ArrayList<Forbehold> forbeholdsliste = new ArrayList<>();
        //Populér forbeholdsliste med sql-kald
        String sql = "SELECT * from vagtplantestdb.forbehold";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()){
            forbeholdsliste.add(new Forbehold(
                    sqlRowSet.getInt("id"),
                    sqlRowSet.getDate("dato").toLocalDate(),
                    sqlRowSet.getString("kommentar")
            ));
        }
        return forbeholdsliste;
    }

    @Override
    public ArrayList<Forbehold> seForbeholdsListe(String username){
        ArrayList<Forbehold> forbeholdsliste = new ArrayList<>();
        //Populér forbeholdsliste med sql-kald
        String sql = "SELECT * FROM vagtplantestdb.forbehold WHERE fk_username_forbehold='"+ username + "'";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()){
            forbeholdsliste.add(new Forbehold(
                    sqlRowSet.getInt("forbeholdid"),
                    sqlRowSet.getDate("dato").toLocalDate(),
                    sqlRowSet.getString("kommentar")
            ));
        }
        return forbeholdsliste;
    }

    @Override
    public void opretForbehold(Forbehold forbehold, String userName){
        String sql = "INSERT INTO vagtplantestdb.forbehold (dato, kommentar, fk_username_forbehold) " +
                "VALUES ('" + forbehold.getDato() + "', '" + forbehold.getKommentar() + "', '" + userName + "')";

        jdbcTemplate.update(sql);
    }

    @Override
    public void redigerForbehold(Forbehold forbehold){
    }


}
