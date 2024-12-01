package fr.isep.francois;

import java.util.List;

public class Pilote extends Employe {

String Licence;

int heuresDevole;

String role="Pilote";

public Pilote(List<String> contact, String identifiant, String nom, String adresse,
              int NumeroEmploye, String dateEmbauche,
              String licence, int heuresDeVol){

    super(contact,identifiant,nom,
           adresse,NumeroEmploye,dateEmbauche);

    this.Licence=Licence;
    this.heuresDevole=heuresDevole;



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
            NumeroEmploye+DateEmboche.toString()+Licence.toString()+heuresDevole+role;

    }
}
