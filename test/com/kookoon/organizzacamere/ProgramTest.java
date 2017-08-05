package com.kookoon.organizzacamere;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by jaaja on 03/08/2017.
 */
public class ProgramTest {

    ArrayList<Camera> camere;
    ArrayList<Prenotazione> prenotazioni;

    @Before
    public void setUp() throws Exception {
        camere = new Program().getDefaultCameraList();
        prenotazioni = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void simpleOrganization() {
        Tableau tableau = new Tableau();
        OrganizzazioneStrategy strategy = new MyStrategy();
        Prenotazione p1 = new Prenotazione("a", "25/04/2016", "26/04/2016", 2, false);
        Prenotazione p2 = new Prenotazione("b", "25/04/2016", "26/04/2016", 2, true);
        Prenotazione p3 = new Prenotazione("c", "25/04/2016", "26/04/2016", 3, true);
        prenotazioni.add(p1);
        prenotazioni.add(p2);
        prenotazioni.add(p3);
        strategy.find(tableau, camere, prenotazioni);
        ArrayList<Prenotazione> prenotazioniTableau = tableau.get(p1.getCheckIn());
        assertEquals("43", prenotazioniTableau.get(0).getCamera().getNumeroCamera());
        assertEquals("44", prenotazioniTableau.get(1).getCamera().getNumeroCamera());
        assertEquals("46", prenotazioniTableau.get(2).getCamera().getNumeroCamera());
    }

    @Test
    public void calendarTest() {
        Calendar c1 = new GregorianCalendar();
        c1.set(2016, 0, 1);
        Calendar c2 = new GregorianCalendar();
        c2.set(2016, 0, 1);
        assertTrue(c1.equals(c2));

    }
}