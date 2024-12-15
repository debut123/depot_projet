package fr.isep.francois;

import fr.isep.francois.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ReservationTest {

    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        // Initialisation de la classe Reservation avant chaque test
        reservation = new Reservation();
    }

    @Test
    public void testConfirmerReservation() {
        // Données de test
        int numeroReservation = 123;
        String dateReservation = "2024-12-12";
        String status = "Confirmée";

        // Confirmer la réservation
        reservation.confirmerreservation(numeroReservation, dateReservation, status);

        // Vérification
        List<Integer> listereservation = reservation.getListereservation();
        assertEquals(1, listereservation.size(), "La liste des réservations devrait contenir 1 réservation.");
        assertTrue(listereservation.contains(numeroReservation), "Le numéro de réservation devrait être ajouté à la liste.");

        // Vérification des détails de la réservation
        List<Reservation.Reservationdetail> listedetail = reservation.getListedetail();
        assertEquals(1, listedetail.size(), "La liste des détails devrait contenir 1 élément.");
        assertEquals(numeroReservation, listedetail.get(0).numeroreservation, "Le numéro de réservation dans les détails devrait être correct.");
        assertEquals(dateReservation, listedetail.get(0).dateReservation, "La date de réservation dans les détails devrait être correcte.");
        assertEquals(status, listedetail.get(0).status, "Le statut dans les détails devrait être correct.");
    }

    @Test
    public void testAnnulerReservation() {
        // Données de test
        int numeroReservation = 123;
        String dateReservation = "2024-12-12";
        String status = "Confirmée";

        // Confirmer la réservation
        reservation.confirmerreservation(numeroReservation, dateReservation, status);

        // Annuler la réservation
        reservation.annullerreservation(numeroReservation);

        // Vérification
        List<Integer> listereservation = reservation.getListereservation();
        assertEquals(0, listereservation.size(), "La liste des réservations devrait être vide après annulation.");

        List<Reservation.Reservationdetail> listedetail = reservation.getListedetail();
        assertEquals(0, listedetail.size(), "La liste des détails devrait être vide après annulation.");
    }

    @Test
    public void testModifierReservation() {
        // Données de test
        int numeroReservation = 123;
        String dateReservation = "2024-12-12";
        String status = "Confirmée";

        // Confirmer la première réservation
        reservation.confirmerreservation(numeroReservation, dateReservation, status);

        // Données pour la nouvelle réservation après modification
        int numeroReservation1 = 456;
        String dateReservation1 = "2024-12-13";
        String status1 = "Modifiée";

        // Modifier la réservation
        reservation.modifierReservation(numeroReservation, dateReservation, status, numeroReservation1, dateReservation1, status1);

        // Vérification
        List<Integer> listereservation = reservation.getListereservation();
        assertEquals(1, listereservation.size(), "La liste des réservations devrait contenir 1 réservation après modification.");
        assertTrue(listereservation.contains(numeroReservation1), "La nouvelle réservation devrait être ajoutée à la liste.");

        List<Reservation.Reservationdetail> listedetail = reservation.getListedetail();
        assertEquals(1, listedetail.size(), "La liste des détails devrait contenir 1 élément après modification.");
        assertEquals(numeroReservation1, listedetail.get(0).numeroreservation, "Le numéro de réservation dans les détails devrait être mis à jour.");
        assertEquals(dateReservation1, listedetail.get(0).dateReservation, "La date de réservation dans les détails devrait être mise à jour.");
        assertEquals(status1, listedetail.get(0).status, "Le statut dans les détails devrait être mis à jour.");
    }
}
