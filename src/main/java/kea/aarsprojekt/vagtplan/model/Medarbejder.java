package kea.aarsprojekt.vagtplan.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medarbejder {

    String username;
    String password;
    String name;
    String initialer;
    String telefonnummer;
    int visIVagtplan; //Hvilket skal vises i vagtplan (username, name, initialer m.fl.)
    boolean medarbejderStatus; // (Aktiv medarbejder/Fyret)
    String uselog;

    ArrayList<Forbehold>;
    ArrayList<Vagt>;


    public void opretForbehold(LocalDateTime fra, LocalDateTime til, String){
        @// TODO: 07-05-2018
    }

    public void redigerForbehold(Forbehold){
        @// TODO: 07-05-2018
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitialer(String initialer) {
        this.initialer = initialer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setVisIVagtplan(int visIVagtplan) {
        this.visIVagtplan = visIVagtplan;
    }
}
