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

    abstract String Obtenirinfo();

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<String> getContact() {
        return contact;
    }
}
