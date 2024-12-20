package fr.isep.francois;

import java.util.ArrayList;

public class Aeroport {

String nom;

    public Aeroport(String nom, String ville, String description, ArrayList<Aeroport> listeaeroport) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.listeaeroport = listeaeroport;
    }
// test
    String ville;

String description;

ArrayList<Aeroport> listeaeroport=new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Aeroport> getListeaeroport() {
        return listeaeroport;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setListeaeroport(ArrayList<Aeroport> listeaeroport) {
        this.listeaeroport = listeaeroport;
    }

    public void AffecterVol(int numeroVol) {
        // Créer un nouveau vol
        Vol vol = new Vol();

        // Créer un EnsembleVol pour ce vol
        Vol.EnsembleVol ensembleVol = new Vol().new EnsembleVol(numeroVol, "Paris", "Lyon",
                20241205, 20241205, "Prévu", null, null, new ArrayList<>(), new ArrayList<>());

        // Affecter cet aéroport au vol (l'aéroport actuel (this) est affecté au vol)
        // Il pourrait y avoir un champ spécifique pour l'aéroport dans EnsembleVol si nécessaire
        // Par exemple, ensembleVol.aeroportDepart = this; ou ensembleVol.aeroportArrivee = this;

        // Ajouter ce vol à la liste des vols dans la classe Vol
        vol.listeEnsembleVol.add(ensembleVol);

        // Afficher une confirmation
        System.out.println("L'aéroport " + this.nom + " a été affecté au vol " + numeroVol);
    }

}
