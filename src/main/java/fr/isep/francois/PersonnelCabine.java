package fr.isep.francois;

import java.util.ArrayList;
import java.util.List;

public class PersonnelCabine extends Employe {

String qualification;
String role="personnels cabine";

ArrayList<PersonnelCabine> listepersonnel=new ArrayList<>();

    public String getQualification() {
        return qualification;
    }

    public String getRole() {
        return role;
    }

    public ArrayList<PersonnelCabine> getListepersonnel() {
        return listepersonnel;
    }

    public PersonnelCabine(List<String> contact, String identifiant, String nom,
                           String adresse, int NumeroEmploye, String dateEmbauche, String qualification) {
        super(contact,identifiant,nom,
                adresse,NumeroEmploye,dateEmbauche);
        this.qualification = qualification;
    }

    public void AffecterVol(){




    }


    public void ObtenirVol(){



    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setListepersonnel(ArrayList<PersonnelCabine> listepersonnel) {
        this.listepersonnel = listepersonnel;
    }

    public String ObtenirRole(){

        return role;

    }
    public String Obtenirinfo(){

        return contact.toString()+identifiant+nom+adresse+
                NumeroEmploye+DateEmboche+qualification+role;

    }
    public void obtenirVol(int numerroVol) {

        Vol vol = new Vol();

        for (Vol.EnsembleVol ensembleVol : vol.listeEnsembleVol) {

            if (ensembleVol.getNumerroVol() == numerroVol) {

                System.out.println("Le vol trouver est " + numerroVol + ensembleVol.getDestination() + ensembleVol.getOrigine()

                        + ensembleVol.getAvion() + ensembleVol.getListepassager() + ensembleVol.getListepersonnel() +

                        ensembleVol.getPilote());


            }
        }


    }
    public void AffecterVol(int numeroVol) {
        // Créer un nouvel objet Vol
        Vol vol = new Vol();

        // Vérifier si le vol existe déjà dans la liste des vols
        Vol.EnsembleVol ensembleVolTrouve = null;
        for (Vol.EnsembleVol ensembleVol : vol.listeEnsembleVol) {
            if (ensembleVol.getNumerroVol() == numeroVol) {
                ensembleVolTrouve = ensembleVol;
                break;
            }
        }

        // Si le vol existe déjà, ajouter le personnel cabine à la liste des personnels
        if (ensembleVolTrouve != null) {
            ensembleVolTrouve.Listepersonnel.add(this);
        } else {
            // Sinon, créer un nouvel ensemble de vol pour ce vol et y ajouter le personnel cabine
            Vol.EnsembleVol nouveauEnsembleVol = new Vol().new EnsembleVol(numeroVol, "Paris", "Lyon",
                    20241205, 20241205, "Prévu",
                    null, null, new ArrayList<>(),
                    new ArrayList<>());
            nouveauEnsembleVol.Listepersonnel.add(this);
            // Ajouter ce nouvel ensemble de vol à la liste des vols du vol
            vol.listeEnsembleVol.add(nouveauEnsembleVol);
        }

        // Afficher une confirmation
        System.out.println("Le personnel de cabine " + this.nom + " a été affecté au vol " + numeroVol);
    }


}
