package fr.isep.francois;


import java.util.ArrayList;
import java.util.List;

public class Avion {

    int immatriculation;
    String modèle;
    int capacité;

    public int getImmatriculation() {
        return immatriculation;
    }

    public String getModèle() {
        return modèle;
    }

    public int getCapacité() {
        return capacité;
    }

    public List<PlageHoraire> getCalendrier() {
        return calendrier;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setModèle(String modèle) {
        this.modèle = modèle;
    }

    public void setCalendrier(List<PlageHoraire> calendrier) {
        this.calendrier = calendrier;
    }

    public void setListeaviondisponible(List<Avion> listeaviondisponible) {
        this.listeaviondisponible = listeaviondisponible;
    }

    public List<Avion> getListeaviondisponible() {
        return listeaviondisponible;
    }

    List<PlageHoraire> calendrier;
    List<Avion> listeaviondisponible=new ArrayList<>();

    public Avion(int immatriculation, String modèle, int capacité) {
        this.immatriculation = immatriculation;
        this.modèle = modèle;
        this.capacité = capacité;
    }
    public Avion(){}

    public int getCapacite() {
        return capacité;
    }

    // Classe interne pour représenter une plage horaire
    public static class PlageHoraire {
        int horaireDebut;  // Heure de début en format 24h (ex : 10 pour 10:00)
        int horaireFin;    // Heure de fin en format 24h (ex : 12 pour 12:00)

        public PlageHoraire(int horaireDebut, int horaireFin) {
            this.horaireDebut = horaireDebut;
            this.horaireFin = horaireFin;
        }
    }

    // Méthode pour vérifier la disponibilité de l'avion
    public boolean VerifierDisponibilite(int horaireDebut, int horaireFin) {
        // Vérification si l'avion est déjà réservé dans cette plage horaire
        for (PlageHoraire plage : calendrier) {
            // Si les horaires se chevauchent, l'avion n'est pas disponible
            if ((horaireDebut < plage.horaireFin) && (horaireFin > plage.horaireDebut)) {
                return false;  // L'avion est réservé pendant cette période
            }
        }
        // Si aucun chevauchement, l'avion est disponible
        return true;
    }



    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public void AffecterVol(int numeroVol) {
        // Créer un nouveau vol
        Vol vol = new Vol();

        // Créer un EnsembleVol pour ce vol
        Vol.EnsembleVol ensembleVol = new Vol().new EnsembleVol(numeroVol, "Paris", "Lyon",
                20241205, 20241205, "Prévu", this, null, new ArrayList<>(), new ArrayList<>());

        // Affecter cet avion au vol
        ensembleVol.avion = this;  // L'avion actuel (this) est affecté à ce vol

        // Ajouter ce vol à la liste des vols dans la classe Vol
        vol.listeEnsembleVol.add(ensembleVol);

        // Afficher une confirmation
        System.out.println("L'avion avec l'immatriculation " + this.immatriculation + " a été affecté au vol " + numeroVol);
    }

}
