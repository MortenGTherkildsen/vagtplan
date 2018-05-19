package kea.aarsprojekt.vagtplan.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medarbejder {

    private String username;
    private String password;
    private String name;
    private String initialer;
    private String telefonnummer;
    private int visIVagtplan; //Hvilket navn skal vises i vagtplan (username, name, initialer m.fl.)
    private int medarbejderStatus; // (Aktiv medarbejder/Fyret)(Måske er int bedre. Stadig 0/1 for aktiv/fyret, men 2 for f.eks. konsulent m.fl.?)
    private String uselog;
    private int erVagtansvarlig;
    private String minVagtansvarlige;
    private Vagtplan vagtplan;

    private ArrayList<Forbehold> forbeholdsliste;


    public Medarbejder(){

    }
    public Medarbejder(String username, String password, String name, String initialer, String telefonnummer, int visIVagtplan, int medarbejderStatus, String uselog, int erVagtansvarlig, String minVagtansvarlige, ArrayList<Forbehold> forbeholdsliste) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visIVagtplan = visIVagtplan;
        this.medarbejderStatus = medarbejderStatus;
        this.uselog = uselog;
        this.erVagtansvarlig = erVagtansvarlig;
        this.minVagtansvarlige = minVagtansvarlige;
        this.forbeholdsliste = forbeholdsliste;
    }

    public Medarbejder(String username, String password, String name, String initialer, String telefonnummer, int visIVagtplan, int medarbejderStatus, String uselog, int erVagtansvarlig, String minVagtansvarlige) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visIVagtplan = visIVagtplan;
        this.medarbejderStatus = medarbejderStatus;
        this.uselog = uselog;
        this.erVagtansvarlig = erVagtansvarlig;
        this.minVagtansvarlige = minVagtansvarlige;
    }

    public Medarbejder(String username, String password, String minVagtansvarlige){
        this.username = username;
        this.password = password;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visIVagtplan = 1;
        this.medarbejderStatus = 1;

        this.minVagtansvarlige = minVagtansvarlige;
    }

    public Medarbejder(String username){
        this.username = username;
        this.password = "1324";
        this.name = "";
        this.initialer = "";
        this.telefonnummer = "";
        this.visIVagtplan = 1;
        this.medarbejderStatus = 1;

        this.minVagtansvarlige = minVagtansvarlige;
    }


    public void visVagter(){
        // TODO: 18-05-2018
    }

    public boolean harForbehold(LocalDate localDate){
        boolean harforbehold = false;

        for (Forbehold forbehold:forbeholdsliste) {
            if(forbehold.getFra().toLocalDate().equals(localDate)){
                harforbehold = true;
            }
        }
        return harforbehold;
    }

    public void opretForbehold(LocalDateTime fra, LocalDateTime til, String kommentar){
        Forbehold forbehold = new Forbehold(fra, til, kommentar);
        forbeholdsliste.add(forbehold);
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

    public int getMedarbejderStatus() {
        return medarbejderStatus;
    }

    public void setMedarbejderStatus(int medarbejderStatus) {
        this.medarbejderStatus = medarbejderStatus;
    }

    public String getUselog() {
        return uselog;
    }

    public void setUselog(String uselog) {
        this.uselog = uselog;
    }

    @Override
    public String toString(){
        String tekstIVagtplan = username;

        switch (visIVagtplan){
            case 0: tekstIVagtplan = username;
            break;
            case 1: tekstIVagtplan = name;
            break;
            case 2: tekstIVagtplan = initialer;
            break;

        }
        return tekstIVagtplan;
    }
}
