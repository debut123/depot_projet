package fr.isep.francois;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {

    private Avion avion;
    private Vol vol;

    @BeforeEach
    void setUp() {
        // Préparation des objets avant chaque test
        avion = new Avion(12345, "Boeing 737", 180);  // Création d'un avion avec des valeurs d'exemple
        vol = new Vol();  // Création de l'objet vol
        avion.setCalendrier(new ArrayList<>());
        avion.calendrier.add(new Avion.PlageHoraire(10, 12));  // Réservation de 10:00 à 12:00
        avion.calendrier.add(new Avion.PlageHoraire(14, 16));

    }

    @Test
    void affecterVol_test() {
        // Appel de la méthode AffecterVol
        avion.AffecterVol(101);

        // Vérification que l'avion est bien affecté à un vol
        assertEquals(1, vol.listeEnsembleVol.size(), "L'avion devrait être affecté à 1 vol.");
        assertNotNull(vol.listeEnsembleVol.get(0).avion, "L'avion devrait être affecté au vol.");
        assertEquals(avion, vol.listeEnsembleVol.get(0).avion, "L'avion affecté au vol devrait être le même que celui utilisé.");
        assertEquals(101, vol.listeEnsembleVol.get(0).numerroVol, "Le numéro du vol devrait être 101.");
    }
    @Test
    void verifierDisponibilite_test() {
        // Test 1: Vérifier qu'un horaire qui chevauche une plage existante renvoie false
        assertFalse(avion.VerifierDisponibilite(11, 13), "L'avion devrait être occupé entre 11:00 et 13:00 car cela chevauche la réservation de 10:00 à 12:00.");

        // Test 2: Vérifier qu'un horaire qui ne chevauche aucune plage existante renvoie true
        assertTrue(avion.VerifierDisponibilite(12, 14), "L'avion devrait être disponible entre 12:00 et 14:00 car cela ne chevauche aucune réservation.");

        // Test 3: Vérifier qu'un horaire qui chevauche deux plages existantes renvoie false
        assertFalse(avion.VerifierDisponibilite(13, 15), "L'avion devrait être occupé entre 13:00 et 15:00 car cela chevauche la réservation de 14:00 à 16:00.");
    }
}




