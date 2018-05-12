package kea.aarsprojekt.vagtplan.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vagtansvarlig extends Medarbejder{

    ArrayList<Medarbejder> medarbejderListe;
    ArrayList<Vagtbehov> vagtbehovsliste;
    ArrayList<Vagtplan> Vagtplansliste;

    public Vagtansvarlig(String username, String password, String name, String initialer, String telefonnummer, int visIVagtplan, boolean medarbejderStatus, String uselog, ArrayList<Medarbejder> medarbejderListe, ArrayList<Vagtbehov> vagtbehovsliste, ArrayList<Vagtplan> vagtplansliste) {
        super(username, password, name, initialer, telefonnummer, visIVagtplan, medarbejderStatus, uselog);
        this.medarbejderListe = medarbejderListe;
        this.vagtbehovsliste = vagtbehovsliste;
        Vagtplansliste = vagtplansliste;
    }

    public void opretMedarbejder(){// TODO: 12-05-2018
        }

    public void toggleMedarbejderStatus(){// TODO: 12-05-2018
        }

    public void seMedarbejderListe(){// TODO: 12-05-2018
        }

    public void toggleSigSelvIndSomMedarbejder(){// TODO: 12-05-2018
        }

    public void opretVagtbehov(){// TODO: 12-05-2018
        }

    public void seVagtbehovsliste(){// TODO: 12-05-2018
        }

    public void redigerVagtbehov(){// TODO: 12-05-2018
        }

    public void sletVagtbehov(){// TODO: 12-05-2018
        }

    public void opretVagtplan(){// TODO: 12-05-2018
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
