package fr.isep.francois;

public class Reservation{

    int numeroreservation;
    String dateReservation;
    String status;

    public Reservation(int numeroreservation, String dateReservation, String status) {
        this.numeroreservation = numeroreservation;
        this.dateReservation = dateReservation;
        this.status = status;
    }
}
