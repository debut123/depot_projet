package fr.isep.francois;

import java.util.List;

public class Passager extends Personne{

String Passeport;
String role="Passager";

    public Passager(List<String> contact, String identifiant, String nom, String adresse, String passeport) {
        super(contact, identifiant, nom, adresse);
        Passeport = passeport;
    }
public void reserverVol(int numeroreservation,String dateReservation,String status){

Reservation reservation=new Reservation(numeroreservation,dateReservation,status);
reservation.confirmerreservation(numeroreservation,dateReservation,status);
}
public void annullerreservation(int numeroreservation){

    Reservation reservation=new Reservation();

    reservation.annullerreservation(numeroreservation);
}
    public String Obtenirinfo(){

        return contact.toString()+identifiant.toString()+nom.toString()+adresse.toString()+
                role+Passeport;

    }

}
