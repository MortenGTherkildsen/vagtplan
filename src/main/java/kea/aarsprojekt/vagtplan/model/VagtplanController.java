package kea.aarsprojekt.vagtplan.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM");
//        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd");

public class VagtplanController {

    public Vagtplan opretVagtplan(LocalDateTime fra, LocalDateTime til, ArrayList<Vagtbehov> vbhListe, ArrayList<Medarbejder> medarbejdere) {

        ArrayList<Vagtbehov> vagtbehovsliste = vbhListe;

        String titel = fra.getDayOfMonth() + "/" + fra.getMonth() + "-" + til.getDayOfMonth() + "/" + til.getMonth();
        String oprettetAf = "[username på vagtansvarlig]";
        ArrayList<Vagt> vagtliste = new ArrayList<>();

        int antalDageIVagtplan = (int)ChronoUnit.DAYS.between(fra, til);

        //Lav vagtplan én dag ad gangen for dagen: dagsIterator
        LocalDate dagsIterator = fra.toLocalDate();

        int antalVagtbehov;
        do {
            //Lav en liste over dagens vagtbehov
            ArrayList<Vagtbehov> dagensVagtbehov = getVagtbehovsListe(vbhListe, dagsIterator);
            int antalvagtbehov = dagensVagtbehov.size();

            //Lav en liste over, hvilke medarbejdere ikke har nogen forbehold mod at arbejde dén dag
            ArrayList<Medarbejder> ledigeMedarbejdere = new ArrayList<>();
            for (Medarbejder medarbejder:medarbejdere) {
                if(!medarbejder.harForbehold(dagsIterator)){
                    ledigeMedarbejdere.add(medarbejder);
                }
            }

            //Løb alle dagens vagtbehov igennem, ét vagtbehov ad gangen
            //Og opret for hvert vagtbehov én vagt.
            for (Vagtbehov vagtbehov:dagensVagtbehov){


               }

            dagsIterator.plusDays(1);
        } while (dagsIterator.isEqual(til.toLocalDate()));

        Vagtplan vagtplan = new Vagtplan(titel, oprettetAf, fra, til, false,vagtliste);

        return vagtplan;
    }

    public long getTidTimer(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.HOURS.between(t1, t2);
    }

    public long getTidDays(LocalDateTime t1, LocalDateTime t2){
        return ChronoUnit.DAYS.between(t1, t2);
    }


    public ArrayList<Vagtbehov> getVagtbehovsListe(ArrayList<Vagtbehov> vagtbehovsListe, LocalDate localDate){

        ArrayList<Vagtbehov> vagtbehovDato = new ArrayList<>();

        for (Vagtbehov vagtbehov : vagtbehovsListe) {
            if(vagtbehov.getFra().toLocalDate().equals(localDate)){
                //og lav en liste over dagens vagtbehov.
                vagtbehovDato.add(vagtbehov);
            }
        }
        return vagtbehovDato;
    }


}
