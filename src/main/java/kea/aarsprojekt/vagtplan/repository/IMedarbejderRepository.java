package kea.aarsprojekt.vagtplan.repository;

import kea.aarsprojekt.vagtplan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IMedarbejderRepository {

    ArrayList<Forbehold> seMineForbehold(Medarbejder medarbejder);
    void redigerForbehold(Forbehold forbehold);
    void opretForbehold(Forbehold forbehold);
    ArrayList<Vagt> visVagtplan(Medarbejder medarbejder);

}
