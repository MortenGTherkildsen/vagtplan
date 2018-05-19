package kea.aarsprojekt.vagtplan.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vagtansvarlig extends Medarbejder{

    private ArrayList<Medarbejder> medarbejderListe;
    private ArrayList<Vagtbehov> vagtbehovsListe;
    private ArrayList<Vagtplan> vagtplansListe;

    @Autowired
    VagtplanController vagtplanController;

    @Autowired
    public Vagtansvarlig(String username, String password, String name, String initialer, String telefonnummer, int visIVagtplan, int medarbejderStatus, String uselog, int ervagtansvarlig, ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsliste, ArrayList<Vagtplan> vagtplansliste) {
        super(username, password, name, initialer, telefonnummer, visIVagtplan, medarbejderStatus, uselog, ervagtansvarlig, username);
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsListe = vagtbehovsliste;
        this.vagtplansListe = vagtplansliste;
    }

    public Medarbejder opretMedarbejder(String username){// TODO: 12-05-2018

        Medarbejder medarbejder2 = new Medarbejder(username);
        medarbejderListe.add(medarbejder2);

        return medarbejder2;
        }

    public void setMedarbejderStatus(Medarbejder medarbejder, int medarbejderStatus){

        medarbejder.setMedarbejderStatus(medarbejderStatus);
        }


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

    public void seMedarbejderesForbehold(){// TODO: 12-05-2018
        }

    public void kommenterForbehold(){// TODO: 12-05-2018
        }

    public void toggleAccepteretAfVagtansvarlig(){// TODO: 12-05-2018
    }



}
