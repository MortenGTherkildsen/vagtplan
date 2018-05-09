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

    ArrayList<Vagt>;

    public void accepterVagtplan(){
        this.endeligVagtplan = true;
    }
}
