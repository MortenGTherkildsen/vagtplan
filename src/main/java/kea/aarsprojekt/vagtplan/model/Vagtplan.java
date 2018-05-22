package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Vagtplan {

    private int id;
    private String titel;
    private Date fra;
    private Date til;
    private String kommentar;

    private ArrayList<Vagt> vagts;

    public Vagtplan(int id, String titel, Date fra, Date til, String kommentar, ArrayList<Vagt> vagts) {
        this.id = id;
        this.titel = titel;
        this.fra = fra;
        this.til = til;
        this.kommentar = kommentar;
        this.vagts = vagts;
    }

    public Vagtplan(int id){
        this.id = id;
        this.titel = "";
        this.fra = null;
        this.til = null;
        this.kommentar = "";
        this.vagts = new ArrayList<Vagt>();
    }
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Date getFra() {
        return fra;
    }

    public void setFra(Date fra) {
        this.fra = fra;
    }

    public Date getTil() {
        return til;
    }

    public void setTil(Date til) {
        this.til = til;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public ArrayList<Vagt> getVagts() {
        return vagts;
    }

    public void setVagts(ArrayList<Vagt> vagts) {
        this.vagts = vagts;
    }
}
