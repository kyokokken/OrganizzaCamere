package com.kookoon.organizzacamere;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;

/**
 * Created by jaaja on 03/08/2017.
 */
public class Program {

    Camera c41 = new Camera("41", 2, 4);
    Camera c42 = new Camera("42", 2, 8);
    Camera c43 = new Camera("43", 2, 2);
    Camera c44 = new Camera("44", 2, 3);
    Camera c45 = new Camera("45", 2, 7);
    Camera c46 = new Camera("46", 3, 1);
    Camera c47 = new Camera("47", 4, 6);
    Camera c48 = new Camera("48", 2, 9);
    Camera c49 = new Camera("49", 3, 5);

    public static void main(String args[]) {
        new Program().start();
    }

    private void start() {
        Tableau tableau = new Tableau();
        MyStrategy strategy = new MyStrategy();

        ArrayList<Camera> camere = getDefaultCameraList();
        ArrayList<Prenotazione> prenotazioni = getPrenotazioni();

        for (Prenotazione p : prenotazioni) {
            System.out.println(p + "\n");
        }

    }

    public ArrayList<Camera> getDefaultCameraList() {
        ArrayList<Camera> camere = new ArrayList<>();

        camere.add(c41);
        camere.add(c42);
        camere.add(c43);
        camere.add(c44);
        camere.add(c45);
        camere.add(c46);
        camere.add(c47);
        camere.add(c48);
        camere.add(c49);
        return camere;
    }

    public ArrayList<Prenotazione> getPrenotazioni() {
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        prenotazioni.add(new Prenotazione("Michela P.", "14/08/2017", "21/08/2017", 2, true, c41));
        prenotazioni.add(new Prenotazione("Simona D.", "14/08/2017", "17/08/2017", 2, true, c48));
        prenotazioni.add(new Prenotazione("Michele P.", "13/08/2017", "17/08/2017", 3, true, c49));
        prenotazioni.add(new Prenotazione("Cattaneo", "16/08/2017", "20/08/2017", 2, false));
        prenotazioni.add(new Prenotazione("Nadia P.", "16/08/2017", "18/08/2017", 2, true));
        return prenotazioni;
    }
}
