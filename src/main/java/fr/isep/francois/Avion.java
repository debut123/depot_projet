package fr.isep.francois;


import java.util.List;

public class Avion {

    int immatriculation;
    String modèle;
    int capacité;

    List<PlageHoraire> calendrier;

    public Avion(int immatriculation, String modèle, int capcité) {
        this.immatriculation = immatriculation;
        this.modèle = modèle;
        this.capacité = capcité;
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



}
