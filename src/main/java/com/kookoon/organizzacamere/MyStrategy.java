package com.kookoon.organizzacamere;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by jaaja on 03/08/2017.
 */
public class MyStrategy implements OrganizzazioneStrategy {
    @Override
    public void find(Tableau tableau, ArrayList<Camera> camere, ArrayList<Prenotazione> prenotazioni) {
        ArrayList<Prenotazione> prenotazioniCopy = new ArrayList<>(prenotazioni);
        ArrayList<Camera> camereCopy = new ArrayList<>(camere);


        // Ordina le camere secondo personeMax crescente e poi per priorità crescente
        Collections.sort(camereCopy, new Comparator<Camera>() {
            @Override
            public int compare(Camera o1, Camera o2) {
                int personeDiff = o1.getPersoneMax() - o2.getPersoneMax();
                if (personeDiff != 0) {
                    return personeDiff;
                } else {
                    return o1.getPriority() - o2.getPriority();
                }
            }
        });

        // Ordina le prenotazioni dalla più recente
        Collections.sort(prenotazioniCopy, new Comparator<Prenotazione>() {
            @Override
            public int compare(Prenotazione o1, Prenotazione o2) {
                int yearDifference = o2.getCheckIn().get(Calendar.YEAR) - o1.getCheckIn().get(Calendar.YEAR);
                if (yearDifference != 0) return yearDifference;
                int monthDifference = o2.getCheckIn().get(Calendar.MONTH) - o1.getCheckIn().get(Calendar.MONTH);
                if (monthDifference != 0) return monthDifference;
                return o2.getCheckIn().get(Calendar.DAY_OF_MONTH) - o1.getCheckIn().get(Calendar.DAY_OF_MONTH);
            }
        });

        //Fino a che non finiscono le prenotazioni:
        while (prenotazioniCopy.size() > 0) {
            ArrayList<Camera> camereCopy2 = new ArrayList<>(camereCopy);

            // Prendi la prenotazione più recente
            Prenotazione p = prenotazioniCopy.remove(0);
            // Allocala nella stanza con priorità più alta disponibile
            boolean put = false;

            ArrayList<Prenotazione> prenotazioniGiorno = tableau.get(p.getCheckIn());
            if (prenotazioniGiorno != null) {
                for (Prenotazione p1 : prenotazioniGiorno) {
                    camereCopy2.remove(p1.getCamera());
                }
            }

            // If it already has a default camera
            if (p.getCamera() != null) {
                put = tableau.put(p, p.getCamera());
            } else {
                for (Camera c : camereCopy2) {
                    if (p.getNumPersone() > c.getPersoneMax()) continue;
                    put = tableau.put(p, c);
                    if (put) {
                        break;
                    }
                }
            }

            if (!put) {
                throw new RuntimeException("Can't allocate camera");
            }
        }
    }


}

