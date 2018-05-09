package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Vagtbehov {

    LocalDateTime oprettelsesTid;
    String oprettetAf;
    LocalDateTime fra;
    LocalDateTime til;
    int antalPersoner;
    String titel;
    String kommentar;

    public Date getFra(){
        @// TODO: 07-05-2018
    }

    public Date getTil(){
        @// TODO: 07-05-2018
    }

    public LocalDateTime getFra() {
        return fra;
    }

    public void setFra(LocalDateTime fra) {
        this.fra = fra;
    }

    public LocalDateTime getTil() {
        return til;
    }

    public void setTil(LocalDateTime til) {
        this.til = til;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }

    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
