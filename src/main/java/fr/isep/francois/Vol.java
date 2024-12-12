package fr.isep.francois;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vol {


    public Vol() {
    }

    Map<Vol,Avion> listevolavion=new HashMap<>();

    public static List<EnsembleVol> listeEnsembleVol=new ArrayList<>();


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
        public int getNumerroVol() {
            return numerroVol;
        }

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

        public String getOrigine() {
            return origine;
        }

        public String getDestination() {
            return destination;
        }

        public int getDateHeureDepart() {
            return DateHeureDepart;
        }

        public int getDateHeureArrivee() {
            return DateHeureArrivee;
        }

        public String getEtat() {
            return Etat;
        }

        public Avion getAvion() {
            return avion;
        }

        public Pilote getPilote() {
            return pilote;
        }

        public List<Passager> getListepassager() {
            return Listepassager;
        }

        public List<PersonnelCabine> getListepersonnel() {
            return Listepersonnel;
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

    public void annulerVol(int numeroVol) {
        // Utilisation de removeIf pour supprimer le vol correspondant
        listeEnsembleVol.removeIf(ensembleVol -> ensembleVol.getNumerroVol() == numeroVol);
    }



    public Map<Vol, Avion> getListevolavion() {
        return listevolavion;
    }

    public void setListevolavion(Map<Vol, Avion> listevolavion) {
        this.listevolavion = listevolavion;
    }

    public List<EnsembleVol> getListeEnsembleVol() {
        return listeEnsembleVol;
    }

    public void setListeEnsembleVol(List<EnsembleVol> listeEnsembleVol) {
        this.listeEnsembleVol = listeEnsembleVol;
    }

    public List<Vol> getListevol() {
        return listevol;
    }

    public void setListevol(List<Vol> listevol) {
        this.listevol = listevol;
    }

    public String[] getListedestination() {
        return listedestination;
    }

    public void setListedestination(String[] listedestination) {
        this.listedestination = listedestination;
    }

    public int getNumerroVol() {
        return numerroVol;
    }

    public void setNumerroVol(int numerroVol) {
        this.numerroVol = numerroVol;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateHeureDepart() {
        return DateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        DateHeureDepart = dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return DateHeureArrivee;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        DateHeureArrivee = dateHeureArrivee;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public void obtenirVol(int numerroVol){

        for (EnsembleVol ensembleVol:listeEnsembleVol){

            if (ensembleVol.getNumerroVol()==numerroVol){

                System.out.println("Le vol trouver est "+numerroVol+ensembleVol.getDestination()+ensembleVol.getOrigine()

                        +ensembleVol.getAvion()+ensembleVol.getListepassager()+ensembleVol.getListepersonnel()+

                        ensembleVol.getPilote());



            }
        }


    }
    public List<Passager> listingPassager(int numerroVol) {
        // Liste pour stocker les passagers du vol spécifique
        List<Passager> passagersVol = new ArrayList<>();

        // Parcours de tous les vols planifiés
        for (EnsembleVol ensembleVol : listeEnsembleVol) {
            // Si le numéro du vol correspond
            if (ensembleVol.getNumerroVol() == numerroVol) {
                // Ajouter les passagers du vol à la liste
                passagersVol.addAll(ensembleVol.getListepassager());
                break; // On peut sortir de la boucle car on a trouvé le vol
            }
        }

        // Retourner la liste des passagers trouvés pour le vol
        return passagersVol;
    }




    public void modifierVol(int numerroVol, String origine, String destination,
                            int dateHeureDepart, int dateHeureArrivee, String etat,
                            Avion avion, Pilote pilote, List<Passager> listepassager,
                            List<PersonnelCabine> listepersonnel, boolean planifier, boolean annuler) {

        if (planifier) {
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
                System.out.println("Vol " + numerroVol + " planifié avec succès.");
            } else {
                // Si le nombre de passagers dépasse la capacité de l'avion
                System.out.println("Erreur : Le nombre de passagers dépasse la capacité de l'avion.");
            }
        }

        else if (annuler) {
            // Annuler un vol
            boolean volTrouve = false;
            for (EnsembleVol ensembleVol : listeEnsembleVol) {
                if (ensembleVol.getNumerroVol() == numerroVol) {
                    // Si le vol est trouvé, on l'annule
                    listeEnsembleVol.remove(ensembleVol);
                    System.out.println("Le vol " + numerroVol + " a été annulé.");
                    volTrouve = true;
                    break;
                }
            }
            if (!volTrouve) {
                System.out.println("Erreur : Vol " + numerroVol + " non trouvé.");
            }
        }

        else {
            // Modification d'un vol existant
            boolean volTrouve = false;
            for (EnsembleVol ensembleVol : listeEnsembleVol) {
                if (ensembleVol.getNumerroVol() == numerroVol) {
                    // Si le vol est trouvé, on modifie ses informations
                    ensembleVol.origine = origine;
                    ensembleVol.destination = destination;
                    ensembleVol.DateHeureDepart = dateHeureDepart;
                    ensembleVol.DateHeureArrivee = dateHeureArrivee;
                    ensembleVol.Etat = etat;
                    ensembleVol.avion = avion;
                    ensembleVol.pilote = pilote;
                    ensembleVol.Listepassager = listepassager;
                    ensembleVol.Listepersonnel = listepersonnel;

                    System.out.println("Le vol " + numerroVol + " a été modifié avec succès.");
                    volTrouve = true;
                    break;
                }
            }
            if (!volTrouve) {

                System.out.println("Erreur : Vol " + numerroVol + " non trouvé pour modification.");
            }
        }
    }


}
