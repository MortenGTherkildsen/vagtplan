package kea.aarsprojekt.vagtplan.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vagtansvarlig extends Medarbejder{

    private ArrayList<Medarbejder> medarbejderListe;
    private ArrayList<Vagtbehov> vagtbehovsListe;
    private ArrayList<Vagtplan> vagtplansListe;

    @Autowired
    VagtplanController vagtplanController;


    public Vagtansvarlig(ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsListe, ArrayList<Vagtplan> vagtplansListe) {
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsListe = vagtbehovsListe;
        this.vagtplansListe = vagtplansListe;
    }

    public Vagtansvarlig(String username, String password, String role, String name, String initialer, String telefonnummer, String visIVagtplan, int medarbejderStatus, String uselog, String minVagtansvarlige, ArrayList<Forbehold> forbeholdsliste, ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsListe, ArrayList<Vagtplan> vagtplansListe) {
        super(username, password, role, name, initialer, telefonnummer, visIVagtplan, medarbejderStatus, uselog, minVagtansvarlige, forbeholdsliste);
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsListe = vagtbehovsListe;
        this.vagtplansListe = vagtplansListe;
    }

    public Vagtansvarlig(String username, String password, String name, String initialer, String telefonnummer, String visIVagtplan, int medarbejderStatus, String uselog, String minVagtansvarlige, ArrayList<Forbehold> forbeholdsliste, ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsListe, ArrayList<Vagtplan> vagtplansListe) {
        super(username, password, name, initialer, telefonnummer, visIVagtplan, medarbejderStatus, uselog, minVagtansvarlige, forbeholdsliste);
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsListe = vagtbehovsListe;
        this.vagtplansListe = vagtplansListe;
    }

    public Vagtansvarlig(String username, String password, String minVagtansvarlige, ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsListe, ArrayList<Vagtplan> vagtplansListe) {
        super(username, password, minVagtansvarlige);
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsListe = vagtbehovsListe;
        this.vagtplansListe = vagtplansListe;
    }

    public Vagtansvarlig(String username, ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsListe, ArrayList<Vagtplan> vagtplansListe) {
        super(username);
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsListe = vagtbehovsListe;
        this.vagtplansListe = vagtplansListe;
    }

    @Autowired

    public Medarbejder opretMedarbejder(String username){// TODO: 12-05-2018

        Medarbejder medarbejder2 = new Medarbejder(username);
        medarbejderListe.add(medarbejder2);

        return medarbejder2;
        }

    public void setMedarbejderStatus(Medarbejder medarbejder, int medarbejderStatus){

        medarbejder.setMedarbejderStatus(medarbejderStatus);
        }


    public Medarbejder getMedarbejder(String username){
            Medarbejder medarbejder_holder = null;
            for (Medarbejder medarbejder:medarbejderListe) {
                if(medarbejder.getUsername().equalsIgnoreCase(username))
                    medarbejder_holder = getMedarbejder(username);
            }
            return medarbejder_holder;
        }

    @Autowired
    public ArrayList<Medarbejder> seMedarbejderListe(){// TODO: 12-05-2018
        return medarbejderListe;
        }

    public void toggleSigSelvIndSomMedarbejder(){// TODO: 12-05-2018

        }

    public void opretVagtbehov(){// TODO: 12-05-2018
        }

    public ArrayList<Vagtbehov> getVagtbehovsListe(){
            return vagtbehovsListe;
        }



    public void redigerVagtbehov(){// TODO: 12-05-2018
        }

    public void sletVagtbehov(){// TODO: 12-05-2018
        }

    public void opretVagtplan(LocalDateTime fra, LocalDateTime til, ArrayList<Vagtbehov> vagtbehovsliste, ArrayList<Medarbejder> medarbejdere){

        vagtplanController.opretVagtplan(fra, til, vagtbehovsliste, medarbejdere);
        }

    public void seVagtplansliste(){// TODO: 12-05-2018
        }

    public void redigerVagtplan(){// TODO: 12-05-2018
        }

    public ArrayList<Forbehold> seForbeholdsListe(Medarbejder medarbejder){// TODO: 12-05-2018
        ArrayList<Forbehold> forbeholdsliste = medarbejder.getForbeholdsliste();

        return forbeholdsliste;
    }

    public void kommenterForbehold(){// TODO: 12-05-2018
        }

    public void toggleAccepteretAfVagtansvarlig(){// TODO: 12-05-2018
    }



}
