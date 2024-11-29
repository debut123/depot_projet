package fr.isep.francois;

import java.util.List;

public abstract class Employe extends Personne{

    int NumeroEmploye;
    String DateEmboche;

    public Employe(List<String> contact, String identifiant, String nom,
                   String adresse) {
        super(contact, identifiant, nom, adresse);
        this.NumeroEmploye=NumeroEmploye;
        this.DateEmboche=DateEmboche;
    }

    abstract String ObtenirRole();


}
