package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDateTime;

public class Vagt {

    private LocalDateTime fra;
    private LocalDateTime til;
    private String kommentar;
    private String bemandetAf;
    private String visIVagtplan;


    public double getVagtLaengde(){
    double vagtlaengde=0;
        // Udregn vagtlængde
        // TODO: 08-05-2018
    return vagtlaengde;
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

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getBemandetAf() {
        return bemandetAf;
    }

    public void setBemandetAf(String bemandetAf) {
        this.bemandetAf = bemandetAf;
    }

    public String getVisIVagtplan() {
        return visIVagtplan;
    }

    public void setVisIVagtplan(String visIVagtplan) {
        this.visIVagtplan = visIVagtplan;
    }
}
