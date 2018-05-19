package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Vagtplan {

    String titel;
    String oprettetAf;
    LocalDateTime fra;
    LocalDateTime til;
    boolean endeligVagtplan;

    ArrayList<Vagt> vagts;

    public void accepterVagtplan(){
        this.endeligVagtplan = true;
    }

    public Vagtplan(){
        this.endeligVagtplan = false;
        this.oprettetAf = ", d. " + LocalDateTime.now().toString();
    }

    public Vagtplan(String titel, String oprettetAf, LocalDateTime fra, LocalDateTime til, boolean endeligVagtplan, ArrayList<Vagt> vagts) {
        this.titel = titel;
        this.oprettetAf = oprettetAf;
        this.fra = fra;
        this.til = til;
        this.endeligVagtplan = endeligVagtplan;
        this.vagts = vagts;
    }

    public void addVagt(Vagt vagt){
        vagts.add(vagt);
    }



    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOprettetAf() {
        return oprettetAf;
    }

    public void setOprettetAf(String oprettetAf) {
        this.oprettetAf = oprettetAf;
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

    public boolean isEndeligVagtplan() {
        return endeligVagtplan;
    }

    public void setEndeligVagtplan(boolean endeligVagtplan) {
        this.endeligVagtplan = endeligVagtplan;
    }

    public ArrayList<Vagt> getVagts() {
        return vagts;
    }

    public void setVagts(ArrayList<Vagt> vagts) {
        this.vagts = vagts;
    }
}
