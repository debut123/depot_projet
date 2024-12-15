package fr.isep.francois;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    int numeroreservation;
    String dateReservation;
    String status;
    List<Integer> listereservation = new ArrayList<>();
    List<Reservationdetail> listedetail = new ArrayList<>();

    public class Reservationdetail {

        public int numeroreservation;
        public String dateReservation;
        public String status;

        public Reservationdetail(int numeroreservation, String dateReservation, String status) {
            this.numeroreservation = numeroreservation;
            this.dateReservation = dateReservation;
            this.status = status;
        }
    }

    public Reservation(int numeroreservation, String dateReservation, String status) {
        this.numeroreservation = numeroreservation;
        this.dateReservation = dateReservation;
        this.status = status;
    }

    public Reservation() {}

    public void confirmerreservation(int numeroreservation, String dateReservation, String status) {
        Reservationdetail reservationdetail = new Reservationdetail(numeroreservation, dateReservation, status);
        listereservation.add(numeroreservation);
        listedetail.add(reservationdetail);
    }

    public void annullerreservation(int numeroreservation) {
        // Supprimer le numéro de réservation de la liste listereservation
        listereservation.remove(Integer.valueOf(numeroreservation));  // Utilisation de Integer.valueOf pour supprimer l'élément

        // Supprimer les détails de la réservation
        listedetail.removeIf(reservation -> reservation.numeroreservation == numeroreservation);
    }

    public void modifierReservation(int numeroreservation, String dateReservation,
                                    String status, int numeroreservation1, String dateReservation1,
                                    String status1) {

        annullerreservation(numeroreservation);
        confirmerreservation(numeroreservation1, dateReservation1, status1);
    }

    // Méthodes pour écrire les réservations dans un fichier CSV
    public void ecrireCSV() throws IOException {
        try (FileWriter fileWriter = new FileWriter("reservations.csv")) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader("NumeroReservation", "DateReservation", "Status")
                    .build();
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);

            // Enregistrer chaque réservation
            for (Reservationdetail detail : listedetail) {
                csvPrinter.printRecord(detail.numeroreservation, detail.dateReservation, detail.status);
            }
        }
    }

    // Getters et Setters
    public int getNumeroreservation() {
        return numeroreservation;
    }

    public void setNumeroreservation(int numeroreservation) {
        this.numeroreservation = numeroreservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getListereservation() {
        return listereservation;
    }

    public void setListereservation(List<Integer> listereservation) {
        this.listereservation = listereservation;
    }

    public List<Reservationdetail> getListedetail() {
        return listedetail;
    }

    public void setListedetail(List<Reservationdetail> listedetail) {
        this.listedetail = listedetail;
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        reservation.confirmerreservation(1, "2024-12-15", "confirmée");
        reservation.confirmerreservation(2, "2024-12-16", "en attente");

        try {
            reservation.ecrireCSV();  // Écrire dans le fichier CSV
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
