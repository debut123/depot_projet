package fr.isep.francois;

import java.util.ArrayList;
import java.util.List;

public abstract class Personne {

String identifiant;

String nom;

String adresse;

List<String> contact= new ArrayList<>();

    public Personne(List<String> contact, String identifiant, String nom, String adresse) {
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
