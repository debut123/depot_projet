package fr.isep.francois;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class PersonnelCabineTest {

    private PersonnelCabine personnelCabine;

    @BeforeEach
    void setUp() {
        // Préparation des données pour créer un personnel cabine
        List<String> contact = new ArrayList<>();
        contact.add("contact@example.com");
        String identifiant = "P123";
        String nom = "John Doe";
        String adresse = "123 rue Example, Paris";
        int numeroEmploye = 1500;
        String dateEmbauche = "2020-01-01";
        String qualification = "Chef de cabine";

        // Création d'un personnel cabine de test
        personnelCabine = new PersonnelCabine(contact, identifiant, nom, adresse, numeroEmploye, dateEmbauche, qualification);
    }

    @Test
    void testQualification() {
        // Vérification de la qualification du personnel de cabine
        assertEquals("Chef de cabine", personnelCabine.getQualification());
    }

    @Test
    void testRole() {
        // Vérification du rôle du personnel de cabine
        assertEquals("personnels cabine", personnelCabine.getRole());
    }

    @Test
    void testObtenirRole() {
        // Vérification de la méthode ObtenirRole
        assertEquals("personnels cabine", personnelCabine.ObtenirRole());
    }

    @Test
    void testObtenirInfo() {
        // Vérification de la méthode Obtenirinfo
        String expectedInfo = "[contact@example.com]P123John Doe123 rue Example, Paris1500nullChef de cabinepersonnels cabine";
        assertEquals(expectedInfo, personnelCabine.Obtenirinfo());
    }

    @Test
    void testSetters() {
        // Vérification des setters
        personnelCabine.setQualification("Assistant de cabine");
        personnelCabine.setRole("personnel cabine senior");

        assertEquals("Assistant de cabine", personnelCabine.getQualification());
        assertEquals("personnel cabine senior", personnelCabine.getRole());
    }

    @Test
    void testAffecterVol() {
        // Création d'un objet Vol avec une liste d'EnsembleVol vide initialement
        Vol vol = new Vol();

        // Création du personnel cabine
        PersonnelCabine personnelCabine = new PersonnelCabine(List.of("contact@example.com"), "P123", "John Doe", "123 rue Example, Paris", 120, "2020-01-01", "QualificationA");

        // Affectation du personnel cabine au vol avec le numéro de vol 123
        personnelCabine.AffecterVol(123);  // Appel de la méthode AffecterVol

        // Vérification que le personnel a bien été ajouté à la liste des personnels du vol spécifique
        boolean personnelAjoute = false;
        for (Vol.EnsembleVol ensembleVol : vol.listeEnsembleVol) {
            if (ensembleVol.getNumerroVol() == 123) {
                // On vérifie si le personnelCabine a été ajouté à la liste Listepersonnel de l'EnsembleVol
                personnelAjoute = ensembleVol.Listepersonnel.contains(personnelCabine);
                break;
            }
        }

        // Assertion pour vérifier que le personnel est bien affecté au vol
        assertTrue(personnelAjoute);
    }

    @Test
    void testObtenirVol() {
        // Mocking Vol and EnsembleVol for the test
        Vol vol = new Vol();
        Vol.EnsembleVol ensembleVol = new Vol().new EnsembleVol(123, "Paris", "Lyon", 20241205, 20241205, "Prévu", null, null, new ArrayList<>(), new ArrayList<>());

        vol.listeEnsembleVol.add(ensembleVol);

        // Vérifier que la méthode affiche bien les informations du vol
        personnelCabine.obtenirVol(123);
        // On devrait voir l'affichage de ce vol si la méthode fonctionne correctement
    }
}
