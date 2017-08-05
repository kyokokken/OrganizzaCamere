package com.kookoon.organizzacamere;

import java.util.ArrayList;

/**
 * Created by jaaja on 03/08/2017.
 */
public interface OrganizzazioneStrategy {

    void find(Tableau tableau, ArrayList<Camera> camere, ArrayList<Prenotazione> prenotazioni);
}
