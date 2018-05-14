package kea.aarsprojekt.vagtplan.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medarbejder {

    private String username;
    private String password;
    private String name;
    private String initialer;
    private String telefonnummer;
    private int visIVagtplan; //Hvilket navn skal vises i vagtplan (username, name, initialer m.fl.)
    private boolean medarbejderStatus; // (Aktiv medarbejder/Fyret)(Måske er int bedre. Stadig 0/1 for aktiv/fyret, men 2 for f.eks. konsulent m.fl.?)
    private String uselog;
    private String minVagtansvarlige;



    public Medarbejder(String username, String password, String name, String initialer, String telefonnummer, int visIVagtplan, boolean medarbejderStatus, String uselog, String minVagtansvarlige) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visIVagtplan = visIVagtplan;
        this.medarbejderStatus = medarbejderStatus;
        this.uselog = uselog;
        this.minVagtansvarlige = minVagtansvarlige;
    }

    public void visVagter(){
        // TODO: 12-05-2018
    }

    public void opretForbehold(LocalDateTime fra, LocalDateTime til, String kommentar){
        // TODO: 07-05-2018
    }

    public void redigerForbehold(Forbehold forbehold){
        // TODO: 07-05-2018
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitialer() {
        return initialer;
    }

    public void setInitialer(String initialer) {
        this.initialer = initialer;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public int getVisIVagtplan() {
        return visIVagtplan;
    }

    public void setVisIVagtplan(int visIVagtplan) {
        this.visIVagtplan = visIVagtplan;
    }

    public boolean isMedarbejderStatus() {
        return medarbejderStatus;
    }

    public void setMedarbejderStatus(boolean medarbejderStatus) {
        this.medarbejderStatus = medarbejderStatus;
    }

    public String getUselog() {
        return uselog;
    }

    public void setUselog(String uselog) {
        this.uselog = uselog;
    }
}
