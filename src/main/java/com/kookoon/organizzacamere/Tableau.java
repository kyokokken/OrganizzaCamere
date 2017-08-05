package com.kookoon.organizzacamere;

import java.util.*;

/**
 * Created by jaaja on 03/08/2017.
 */
public class Tableau {
    private HashMap<Calendar, ArrayList<Prenotazione>> tableau;

    public Tableau() {
        tableau = new HashMap<>();
    }

    public boolean put(Prenotazione p, Camera c) {
        p.setCamera(c);
        ArrayList<Prenotazione> prenotazioni = tableau.get(p.getCheckIn());
        if (prenotazioni == null) {
            prenotazioni = new ArrayList<>();
        }
        prenotazioni.add(p);
        tableau.put(p.getCheckIn(), prenotazioni);
        return true;
    }

    public ArrayList<Prenotazione> get(Calendar checkIn) {
        return tableau.get(checkIn);
    }
}
