package fr.isep.francois;

import java.util.List;

public class PersonnelCabine extends Employe {

String qualification;
String role="personnels cabine";

    public PersonnelCabine(List<String> contact, String identifiant, String nom,
                           String adresse,int NumeroEmploye,String dateEmbauche,String qualification) {
        super(contact,identifiant,nom,
                adresse,NumeroEmploye,dateEmbauche);
        this.qualification = qualification;
    }

    public void AffecterVol(){




    }


    public void ObtenirVol(){



    }

    public String ObtenirRole(){

        return role;

    }
    public String Obtenirinfo(){

        return contact.toString()+identifiant.toString()+nom.toString()+adresse.toString()+
                NumeroEmploye+DateEmboche.toString()+qualification.toString()+role;

    }

}
