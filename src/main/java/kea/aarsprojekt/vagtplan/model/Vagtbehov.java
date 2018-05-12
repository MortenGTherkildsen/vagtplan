package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Vagtbehov {

    private LocalDateTime oprettelsesTid;
    private String oprettetAf;
    private LocalDateTime fra;
    private LocalDateTime til;
    private int antalPersoner;
    private String titel;
    private String kommentar;

    public Vagtbehov(LocalDateTime oprettelsesTid, String oprettetAf, LocalDateTime fra, LocalDateTime til, int antalPersoner, String titel, String kommentar) {
        this.oprettelsesTid = oprettelsesTid;
        this.oprettetAf = oprettetAf;
        this.fra = fra;
        this.til = til;
        this.antalPersoner = antalPersoner;
        this.titel = titel;
        this.kommentar = kommentar;
    }

    public Date getFraDato(){
        Date fraDato = null; // "Udrav" datoen fra "fra" og returnér kun datoen.
        // TODO: 07-05-2018

        return fraDato;
    }

    public Date getTilDato(){
        Date tilDato = null;
        // "Udrav" datoen fra "fra" og returnér kun datoen.
        // TODO: 07-05-2018

        return tilDato;
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
