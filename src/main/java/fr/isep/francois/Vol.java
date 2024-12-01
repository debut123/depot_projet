package fr.isep.francois;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vol {

    Map<Vol,Avion> listevolavion=new HashMap<>();

    List<EnsembleVol> listeEnsembleVol=new ArrayList<>();


    List<Vol> listevol= new ArrayList<>();
    String[] listedestination = new String[] {"Paris", "Marseille", "Lyon"};


int numerroVol;

String origine;

String destination;

String DateHeureDepart;
String DateHeureArrivee;
String Etat;

    public Vol(int numerroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.numerroVol = numerroVol;
        this.origine = origine;
        this.destination = destination;
        DateHeureDepart = dateHeureDepart;
        DateHeureArrivee = dateHeureArrivee;
        Etat = etat;
    }
    public class EnsembleVol{
        int numerroVol;

        String origine;

        String destination;

        int DateHeureDepart;
        int DateHeureArrivee;
        String Etat;
        Avion avion;
        Pilote pilote;
        List<Passager> Listepassager=new ArrayList<>();
        List<PersonnelCabine> Listepersonnel=new ArrayList<>();

        public EnsembleVol(int numerroVol, String origine, String destination,
                           int dateHeureDepart, int dateHeureArrivee, String etat,
                           Avion avion, Pilote pilote, List<Passager> listepassager,
                           List<PersonnelCabine> listepersonnel) {
            this.numerroVol = numerroVol;
            this.origine = origine;
            this.destination = destination;
            DateHeureDepart = dateHeureDepart;
            DateHeureArrivee = dateHeureArrivee;
            Etat = etat;
            this.avion = avion;
            this.pilote = pilote;
            Listepassager = listepassager;
            Listepersonnel = listepersonnel;
        }
    }


    public void plannifierVol(int numerroVol, String origine, String destination,
                              int dateHeureDepart, int dateHeureArrivee, String etat,
                              Avion avion, Pilote pilote, List<Passager> listepassager,
                              List<PersonnelCabine> listepersonnel){

        // Vérification de la capacité de l'avion
        if (listepassager.size() <= avion.getCapacite()) {
            // Si le nombre de passagers est inférieur ou égal à la capacité de l'avion
            avion.VerifierDisponibilite(dateHeureDepart, dateHeureArrivee);  // Vérifie la disponibilité de l'avion

            // Créer un objet EnsembleVol avec les informations données
            EnsembleVol ensembleVol = new EnsembleVol(numerroVol, origine, destination,
                    dateHeureDepart, dateHeureArrivee, etat,
                    avion, pilote, listepassager, listepersonnel);

            // Ajouter l'ensemble de vol à la liste
            listeEnsembleVol.add(ensembleVol);
        } else {
            // Si le nombre de passagers dépasse la capacité de l'avion
            System.out.println("Erreur : Le nombre de passagers dépasse la capacité de l'avion.");
        }


    }





}
