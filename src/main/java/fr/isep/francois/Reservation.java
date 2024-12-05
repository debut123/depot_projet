package fr.isep.francois;

import java.util.ArrayList;
import java.util.List;

public class Reservation{

    int numeroreservation;
    String dateReservation;
    String status;
    List<Integer> listereservation=new ArrayList<>();

    List<Reservationdetail> listedetail=new ArrayList<>();

public class Reservationdetail{

    int numeroreservation;
    String dateReservation;
    String status;

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
    public Reservation(){}

    public void confirmerreservation(int numeroreservation,String dateReservation, String status){
        Reservationdetail reservationdetail=new Reservationdetail(numeroreservation,dateReservation,status);
        listereservation.add(numeroreservation);
        listedetail.add(reservationdetail);

    }
    public void annullerreservation(int numeroreservation){

        listereservation.remove(numeroreservation);
        listedetail.removeIf(reservation -> reservation.numeroreservation == numeroreservation);


    }
    public void modifierReservation(int numeroreservation,String dateReservation,
                                    String status,int numeroreservation1,String dateReservation1,
                                    String status1){

        annullerreservation(numeroreservation);
        confirmerreservation(numeroreservation1,dateReservation1,status1);



    }

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
}
