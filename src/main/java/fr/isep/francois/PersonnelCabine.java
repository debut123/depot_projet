package fr.isep.francois;

import java.util.List;

public class PersonnelCabine extends Employe {

String qualification;
String role="personnels cabine";

    public PersonnelCabine(List<String> contact, String identifiant, String nom,
                           String adresse, String qualification) {
        super(contact, identifiant, nom, adresse);
        this.qualification = qualification;
    }

    public void AffecterVol(){




    }


    public void ObtenirVol(){



    }

    public String ObtenirRole(){

        return role;

    }

}
