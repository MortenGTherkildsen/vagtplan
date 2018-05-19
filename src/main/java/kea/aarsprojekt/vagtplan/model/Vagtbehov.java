package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Vagtbehov {

    private LocalDateTime oprettelsesTid;
    private String oprettetAf;
    private LocalDateTime fra;
    private LocalDateTime til;
    private int antalPersoner;
    private String titel;
    private String kommentar;

    public Vagtbehov(LocalDateTime oprettelsesTid, String oprettetAf, LocalDateTime fra, LocalDateTime til, int antalPersoner, String titel, String kommentar) {
        this.oprettelsesTid = oprettelsesTid;
        this.oprettetAf = oprettetAf;
        this.fra = fra;
        this.til = til;
        this.antalPersoner = antalPersoner;
        this.titel = titel;
        this.kommentar = kommentar;
    }

    public LocalDate getDate(LocalDateTime localDateTime){
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    public LocalTime getTime(LocalDateTime localDateTime){
        LocalTime localTime = localDateTime.toLocalTime();
        return localTime;
    }

    public long getVagtbehovsLaengdeIMinutter(){
        return ChronoUnit.MINUTES.between(fra,til);
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

    public int getAntalPersoner() {
        return antalPersoner;
    }

    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
