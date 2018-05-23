package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Forbehold {

    private int id;
    private LocalDate dato;
    private String kommentar;

    public Forbehold(int id, LocalDate dato, String kommentar) {
        this.id = id;
        this.dato = dato;
        this.kommentar = kommentar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
