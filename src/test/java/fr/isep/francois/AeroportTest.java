package fr.isep.francois;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AeroportTest {


    @Test
    public void testAnnulerVol() {
        // Création d'un pilote avec les paramètres nécessaires
        List<String> contact = new ArrayList<>();
        contact.add("pilote@example.com");
        Pilote pilote = new Pilote(contact, "ID123", "John Doe", "123 Rue Example", 101, "2020-01-01", "LIC12345", 1000);

        // Création d'un avion
        Avion avion = new Avion();  // Vous devez définir la classe Avion

        // Création d'un aéroport
        Aeroport aeroport = new Aeroport("Aéroport Orly", "Paris", "Aéroport de Paris", new ArrayList<>());

        // Création et planification d'un vol
        aeroport.AffecterVol(123);  // Affectation d'un vol à l'aéroport

        // Création de l'objet Vol et annulation du vol via Vol
        Vol vol = new Vol();  // Créer un objet Vol (cela doit être effectué correctement selon votre conception)
        vol.annulerVol(123);  // Appeler la méthode annulerVol() de la classe Vol

        // Vérification que la liste des vols est vide après l'annulation
        // Supposons que la méthode annulerVol modifie la liste des vols de l'aéroport
        assertTrue(aeroport.getListeaeroport().isEmpty());  // La liste doit être vide après l'annulation
    }
}
