package fr.isep.francois;

import java.util.List;

public class Pilote extends Employe {

String Licence;

int heuresDevole;

String role;

public Pilote(List<String> contact, String identifiant, String nom, String adresse,
              int numeroEmploye, String dateEmbauche,
              String licence, int heuresDeVol, String role){

    super(contact,identifiant,nom,
           adresse);
    this.Licence=Licence;
    this.heuresDevole=heuresDevole;
    this.role="Pilote";


}

public void AffecterVol(){




}


    public void ObtenirVol(){



    }


    public String ObtenirRole(){

        return role;

    }
}
