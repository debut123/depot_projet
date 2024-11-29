package fr.isep.francois;

import java.util.List;

public class Passager extends Personne{

String Passeport;

    public Passager(List<String> contact, String identifiant, String nom, String adresse, String passeport) {
        super(contact, identifiant, nom, adresse);
        Passeport = passeport;
    }


}
