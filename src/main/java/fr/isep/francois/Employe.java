package fr.isep.francois;

import java.util.List;

public abstract class Employe extends Personne{

    int NumeroEmploye;
    String DateEmboche;

    public Employe(List<String> contact, String identifiant, String nom,
                   String adresse,int NumeroEmploye,String dateEmboche) {
        super(contact, identifiant, nom, adresse);
        this.NumeroEmploye=NumeroEmploye;
        this.DateEmboche=DateEmboche;
    }

    abstract String ObtenirRole();
    abstract String Obtenirinfo();

    public int getNumeroEmploye() {
        return NumeroEmploye;
    }

    public String getDateEmboche() {
        return DateEmboche;
    }

    public void setNumeroEmploye(int numeroEmploye) {
        NumeroEmploye = numeroEmploye;
    }

    public void setDateEmboche(String dateEmboche) {
        DateEmboche = dateEmboche;
    }
}
