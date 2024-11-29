package fr.isep.francois;

import java.util.ArrayList;
import java.util.List;

public class Personne {

int identifiant;

String nom;

String adresse;

List<String> contact= new ArrayList<>();

    public Personne(List<String> contact, int identifiant, String nom, String adresse) {
        this.contact = contact;
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
    }

    public void obtenirInfos(){

    System.out.println("Le nom est: "+nom+" Son adrresse: "+ adresse+
            " Ses contacts sont: " +contact+ "son identifiant: "+identifiant);


}

}
