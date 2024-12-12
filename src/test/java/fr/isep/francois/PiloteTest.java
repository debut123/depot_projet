package fr.isep.francois;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class PiloteTest {

    private Pilote pilote;

    @BeforeEach
    void setUp() {
        // Préparer un pilote pour chaque test
        List<String> contact = new ArrayList<>();
        contact.add("contact@example.com");
        String identifiant = "P123";
        String nom = "John Doe";
        String adresse = "123 rue Example, Paris";
        int numeroEmploye = 1;
        String dateEmbauche = "2020-01-01";
        String licence = "A12345";
        int heuresDeVol = 1500;

        // Création du pilote
        pilote = new Pilote(contact, identifiant, nom, adresse, numeroEmploye, dateEmbauche, licence, heuresDeVol);
    }

    @Test
    void testObtenirInfo() {
        // Tester la méthode obtenirInfo pour vérifier si elle renvoie bien la chaîne attendue
        String expectedInfo = "[contact@example.com]P123John Doe123 rue Example, Paris1nullA123451500Pilote";
        assertEquals(expectedInfo, pilote.Obtenirinfo());
    }

    @Test
    void testAffecterVol() {
        // Test de la méthode AffecterVol
        Vol vol = new Vol();
        int numeroVol = 123;

        // Appel de la méthode AffecterVol
        pilote.AffecterVol(numeroVol);

        // Vérification de l'affectation (vous pouvez ajouter un contrôle pour vérifier si le vol a bien été ajouté)
        boolean volAffecte = false;
        for (Vol.EnsembleVol ensembleVol : vol.listeEnsembleVol) {
            if (ensembleVol.getNumerroVol() == numeroVol && ensembleVol.getPilote() == pilote) {
                volAffecte = true;
                break;
            }
        }

        // Vérifier si le pilote a bien été affecté au vol
        assertTrue(volAffecte, "Le pilote n'a pas été correctement affecté au vol");
    }

}
