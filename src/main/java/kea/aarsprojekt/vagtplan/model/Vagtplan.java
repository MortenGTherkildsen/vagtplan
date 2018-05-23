package kea.aarsprojekt.vagtplan.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Vagtplan {

    private int id;
    private String titel;
    private LocalDate fra;
    private LocalDate til;
    private String kommentar;

    private ArrayList<Vagt> vagts;

    public Vagtplan(int id, String titel, LocalDate fra, LocalDate til, String kommentar, ArrayList<Vagt> vagts) {
        this.id = id;
        this.titel = titel;
        this.fra = fra;
        this.til = til;
        this.kommentar = kommentar;
        this.vagts = vagts;
    }

//    public Vagtplan(int id){
//        this.id = id;
//        this.titel = "";
//        this.fra = null;
//        this.til = null;
//        this.kommentar = "";
//        this.vagts = new ArrayList<Vagt>();
//    }
//
    public Vagtplan(){

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

    public LocalDate getFra() {
        return fra;
    }

    public void setFra(LocalDate fra) {
        this.fra = fra;
    }

    public LocalDate getTil() {
        return til;
    }

    public int getDuration(LocalDate til, LocalDate fra){

        int duration = 5;

        return duration;
    }

    public void setTil(LocalDate til) {
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
