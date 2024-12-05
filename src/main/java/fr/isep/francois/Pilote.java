package fr.isep.francois;

import java.util.ArrayList;
import java.util.List;

public class Pilote extends Employe {

String Licence;

int heuresDevole;

    public int getHeuresDevole() {
        return heuresDevole;
    }

    public void setHeuresDevole(int heuresDevole) {
        this.heuresDevole = heuresDevole;
    }

    public String getLicence() {
        return Licence;
    }

    public void setLicence(String licence) {
        Licence = licence;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Pilote> getListepilote() {
        return listepilote;
    }

    public void setListepilote(ArrayList<Pilote> listepilote) {
        this.listepilote = listepilote;
    }

    String role="Pilote";

ArrayList<Pilote>listepilote=new ArrayList<>();

public Pilote(List<String> contact, String identifiant, String nom, String adresse,
              int NumeroEmploye, String dateEmbauche,
              String licence, int heuresDeVol){

    super(contact,identifiant,nom,
           adresse,NumeroEmploye,dateEmbauche);

    this.Licence=Licence;
    this.heuresDevole=heuresDevole;



}






    public String ObtenirRole(){

        return role;

    }

    public String Obtenirinfo(){

    return contact.toString()+identifiant.toString()+nom.toString()+adresse.toString()+
            NumeroEmploye+DateEmboche.toString()+Licence.toString()+heuresDevole+role;

    }
    public void obtenirVol(int numerroVol){

    Vol vol =new Vol();

        for (Vol.EnsembleVol ensembleVol:vol.listeEnsembleVol){

            if (ensembleVol.getNumerroVol()==numerroVol){

                System.out.println("Le vol trouver est "+numerroVol+ensembleVol.getDestination()+ensembleVol.getOrigine()

                        +ensembleVol.getAvion()+ensembleVol.getListepassager()+ensembleVol.getListepersonnel()+

                        ensembleVol.getPilote());



            }
        }


    }
    public void AffecterVol(int numeroVol) {
        // Créer un nouveau vol
        Vol vol = new Vol();

        // Créer un EnsembleVol pour ce vol
        Vol.EnsembleVol ensembleVol = new Vol().new EnsembleVol(numeroVol, "Paris", "Lyon",
                20241205, 20241205, "Prévu", null, this, new ArrayList<>(), new ArrayList<>());

        // Affecter ce pilote au vol
        ensembleVol.pilote = this; // Le pilote actuel (this) est affecté à ce vol

        // Ajouter ce vol à la liste des vols dans la classe Vol
        // Note : J'ajoute l'ensembleVol dans la liste des vols planifiés
        vol.listeEnsembleVol.add(ensembleVol);

        // Afficher une confirmation
        System.out.println("Le pilote " + this.nom + " a été affecté au vol " + numeroVol);
    }

}
