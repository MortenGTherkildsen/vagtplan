package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Forbehold {

    private LocalDateTime fra;
    private LocalDateTime til;

    private Boolean accepteretAfVagtansvarlig;
    private String kommentar;

    public Forbehold(String fra_string, String til_string, boolean accepteretAfVagtansvarlig, String kommentar){
        this.fra = LocalDateTime.parse(fra_string);
        this.til = LocalDateTime.parse(til_string);
        this.accepteretAfVagtansvarlig = accepteretAfVagtansvarlig;
        this.kommentar = kommentar;
    }
    public Forbehold(LocalDateTime fra, LocalDateTime til, String kommentar) {
        this.fra = fra;
        this.til = til;
        this.accepteretAfVagtansvarlig = false;
        this.kommentar = kommentar;
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

    public Boolean getAccepteretAfVagtansvarlig() {
        return accepteretAfVagtansvarlig;
    }

    public void setAccepteretAfVagtansvarlig(Boolean accepteretAfVagtansvarlig) {
        this.accepteretAfVagtansvarlig = accepteretAfVagtansvarlig;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
