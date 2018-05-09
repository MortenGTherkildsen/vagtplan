package kea.aarsprojekt.vagtplan.model;

import java.time.LocalDateTime;

public class Forbehold {

    LocalDateTime fra;
    LocalDateTime til;
    long maksAntalVagtTimerPrMaaned;
    long maksAntalTimerPrVagt;
    long minAntalTimerPrVagt;

    Boolean accepteretAfVagtansvarlig;
    String kommentar;



}
