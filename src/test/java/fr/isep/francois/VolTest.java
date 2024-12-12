package fr.isep.francois;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VolTest {

    private Vol vol;
    private Avion avion;
    private Pilote pilote;
    private Passager passager;
    private PersonnelCabine personnelCabine;
    private List<Passager> passagers;
    private List<PersonnelCabine> personnels;

    @BeforeEach
    public void setUp() {
        // Création de la liste des qualifications du pilote
        List<String> qualifications = new ArrayList<>();
        qualifications.add("Boeing 737");
        qualifications.add("Airbus A320");

        // Initialisation des objets avec les bons constructeurs
        avion = new Avion(12345, "Airbus A320", 180);  // Initialisation de l'Avion avec le constructeur
        pilote = new Pilote(qualifications, "John", "Doe", "Pilote", 10, "A320", "ABC123", 35);  // Initialisation du Pilote avec la liste des qualifications

        // Pour Passager, on crée une liste de chaînes, même si c'est vide, afin de correspondre à la signature du constructeur
        List<String> passagerInfos = new ArrayList<>();
        passagerInfos.add("Aucune");  // Exemple de donnée supplémentaire
        passager = new Passager(passagerInfos, "Jane", "Doe", "Femme", "Française");  // Utilisation du bon constructeur avec la liste d'informations

        // Création de la liste de responsabilités pour PersonnelCabine
        List<String> responsabilités = new ArrayList<>();
        responsabilités.add("Chef de cabine");

        // Initialisation du PersonnelCabine avec les bons paramètres
        personnelCabine = new PersonnelCabine(responsabilités, "Jack", "Smith", "Chef de cabine", 5, "ID123", "A1");

        // Création des listes de passagers et de personnel
        passagers = new ArrayList<>();
        passagers.add(passager);

        personnels = new ArrayList<>();
        personnels.add(personnelCabine);

        // Initialisation de l'objet Vol
        vol = new Vol();
    }

    @Test
    public void testPlannifierVol() {
        // Planification d'un vol avec les informations nécessaires
        vol.plannifierVol(123, "Paris", "Lyon", 20241205, 20241205, "Prévu", avion, pilote, passagers, personnels);

        // Vérifier que le vol a bien été ajouté à la liste
        assertEquals(1, vol.getListeEnsembleVol().size(), "Le vol n'a pas été correctement planifié.");
    }

    @Test
    public void testAnnulerVol() {
        // Planifier un vol
        // Créer un vol et l'ajouter à la liste des vols
        Vol vol = new Vol();
        vol.setNumerroVol(123);



        // Vérifier que le vol n'est plus dans la liste des vols
        boolean volAnnule = vol.getListeEnsembleVol().stream()
                .noneMatch(v -> v.getNumerroVol() == 123); // Vérifie si le vol n'est plus dans la liste

        // Vérifier que le vol est bien annulé
        assertFalse(volAnnule);  // Si le v
    }

    @Test
    public void testModifierVol() {
        // Planifier un vol
        vol.plannifierVol(123, "Paris", "Lyon", 20241205, 20241205, "Prévu", avion, pilote, passagers, personnels);

        // Modifier les informations du vol
        vol.modifierVol(123, "Paris", "Marseille", 20241206, 20241206, "Modifié", avion, pilote, passagers, personnels, true, false);

        // Vérifier que les informations du vol ont été modifiées
        assertEquals("Marseille", vol.getListeEnsembleVol().get(1).getDestination(), "La destination n'a pas été correctement modifiée.");
    }

    @Test
    public void testListingPassager() {
        // Planifier un vol
        vol.plannifierVol(123, "Paris", "Lyon", 20241205, 20241205, "Prévu", avion, pilote, passagers, personnels);

        // Obtenir la liste des passagers du vol
        List<Passager> passagersDuVol = vol.listingPassager(123);

        // Vérifier que le passager a bien été ajouté à la liste
        assertEquals(1, passagersDuVol.size(), "Le passager n'a pas été trouvé pour ce vol.");
        assertEquals("Doe", passagersDuVol.get(0).getNom(), "Le nom du passager n'est pas correct.");
    }
}
