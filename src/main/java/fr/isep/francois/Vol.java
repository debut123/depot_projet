package fr.isep.francois;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vol {

    Map<Vol,Avion> listevolavion=new HashMap<>();


    List<Vol> listevol= new ArrayList<>();
    String[] listedestination = new String[] {"Paris", "Marseille", "Lyon"};


int numerroVol;

String origine;

String destination;

String DateHeureDepart;
String DateHeureArrivee;
String Etat;

    public Vol(int numerroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.numerroVol = numerroVol;
        this.origine = origine;
        this.destination = destination;
        DateHeureDepart = dateHeureDepart;
        DateHeureArrivee = dateHeureArrivee;
        Etat = etat;
    }


public void plannifierVol(int numerroVol, String origine,String destination,
                          String DateHeureDepart, String DateHeureArrivee, Pilote pilote){


///Vol vol=new Vol(1,"fg","gh","12","13","bien");
///Avion avion=new Avion(12,"2",100);

///listevol.add(vol);
///listevolavion.put(vol,avion);


}



}
