package kea.aarsprojekt.vagtplan.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medarbejder {

    private String username;
    private String password;
    private String role;
    private String name;
    private String initialer;
    private String telefonnummer;
    private String visivagtplan; //Hvilket navn skal vises i vagtplan (navn, kælenavn, initialer eller hvad)
    private int medarbejderStatus; // (Opsagt/Aktiv medarbejder/ .. måske arbejdende/ikke-arbejdende vagtansvarlig osv.)
    private String uselog;
    private String minVagtansvarlige;

    private ArrayList<Forbehold> forbeholdsliste;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMinVagtansvarlige() {
        return minVagtansvarlige;
    }

    public void setMinVagtansvarlige(String minVagtansvarlige) {
        this.minVagtansvarlige = minVagtansvarlige;
    }

    public void setForbeholdsliste(ArrayList<Forbehold> forbeholdsliste) {
        this.forbeholdsliste = forbeholdsliste;
    }

    public Medarbejder(){

    }

    public Medarbejder(String username, String password, String role, String name, String initialer, String telefonnummer, String visIVagtplan, int medarbejderStatus, String uselog, String minVagtansvarlige, ArrayList<Forbehold> forbeholdsliste) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visivagtplan = visIVagtplan;
        this.medarbejderStatus = medarbejderStatus;
        this.uselog = uselog;
        this.minVagtansvarlige = minVagtansvarlige;
        this.forbeholdsliste = forbeholdsliste;
    }

    public Medarbejder(String username, String password, String name, String initialer, String telefonnummer, String visIVagtplan,
                       int medarbejderStatus, String uselog, String minVagtansvarlige, ArrayList<Forbehold> forbeholdsliste) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visivagtplan = visIVagtplan;
        this.medarbejderStatus = medarbejderStatus;
        this.uselog = uselog;
        this.minVagtansvarlige = minVagtansvarlige;
    }

    public Medarbejder(String username, String password, String minVagtansvarlige){
        this.username = username;
        this.password = password;
        this.name = name;
        this.initialer = initialer;
        this.telefonnummer = telefonnummer;
        this.visivagtplan = "";
        this.medarbejderStatus = 1;

        this.minVagtansvarlige = minVagtansvarlige;
    }

    public Medarbejder(String username){
        this.username = username;
        this.password = "1324";
        this.name = "";
        this.initialer = "";
        this.telefonnummer = "";
        this.visivagtplan = "";
        this.medarbejderStatus = 1;

        this.minVagtansvarlige = minVagtansvarlige;
    }


    public void visVagter(){
        // TODO: 18-05-2018
    }

    public boolean harForbehold(LocalDate localDate){
        boolean harforbehold = false;

        for (Forbehold forbehold:forbeholdsliste) {
            if(forbehold.getDato().equals(localDate)){
                harforbehold = true;
            }
        }
        return harforbehold;
    }

    public void opretForbehold(int id, LocalDate dato, String kommentar){
        Forbehold forbehold = new Forbehold(id, dato, kommentar);
        forbeholdsliste.add(forbehold);
    }

    public void redigerForbehold(Forbehold forbehold){
        // TODO: 07-05-2018
    }

    public ArrayList<Forbehold> getForbeholdsliste() {
        return forbeholdsliste;
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

    public String getVisIVagtplan() {
        return visivagtplan;
    }

    public void setVisIVagtplan(String visIVagtplan) {
        this.visivagtplan = visIVagtplan;
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

//    @Override
//    public String toString(){
//        String tekstIVagtplan = username;
//
//        switch (visIVagtplan){
//            case 0: tekstIVagtplan = username;
//            break;
//            case 1: tekstIVagtplan = name;
//            break;
//            case 2: tekstIVagtplan = initialer;
//            break;
//
//        }
//        return tekstIVagtplan;
//    }
}
