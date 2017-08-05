package com.kookoon.organizzacamere;

import java.awt.datatransfer.DataFlavor;

/**
 * Created by jaaja on 03/08/2017.
 */
public class Camera {
    private final int priority;
    private final int personeMax;
    private final String numeroCamera;

    public Camera(String numeroCamera, int persone, int priority) {
        assert persone >= 1 && persone <= 4;
        this.numeroCamera = numeroCamera;
        this.personeMax = persone;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getNumeroCamera() {
        return numeroCamera;
    }

    public int getPersoneMax() {
        return personeMax;
    }
}
