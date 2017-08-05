package com.kookoon.organizzacamere;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jaaja on 03/08/2017.
 */
public class Prenotazione {
    private final String nome;
    private final Calendar checkIn;
    private final Calendar checkOut;
    private final int numPersone;
    private final boolean isBooking;
    private Camera camera;

    public Prenotazione(String nome, String checkIn, String checkOut, int numPersone, boolean isBooking, Camera camera) {
        this(nome, checkIn, checkOut, numPersone, isBooking);
        this.camera = camera;
    }

    public Prenotazione(String nome, String checkIn, String checkOut, int numPersone, boolean isBooking) {
        checkArguments(checkIn, checkOut);
        int[] checkInArr = parseDate(checkIn);
        int[] checkOutArr = parseDate(checkOut);
        this.checkIn = new GregorianCalendar();
        this.checkOut = new GregorianCalendar();
        this.checkIn.set(checkInArr[2], checkInArr[1]-1, checkInArr[0]);
        this.checkOut.set(checkOutArr[2], checkOutArr[1]-1, checkOutArr[0]);
        this.nome = nome;
        this.numPersone = numPersone;
        this.isBooking = isBooking;
    }

    private int[] parseDate(String date) {
        String[] split = date.split("/");
        int[] result = new int[3];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    private void checkArguments(String checkIn, String checkOut) {
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(checkIn);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(checkIn + " is not a correct date.");
        }
        matcher = pattern.matcher(checkOut);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(checkOut + " is not a correct date.");
        }
    }

    public Calendar getCheckIn() {
        return new GregorianCalendar(checkIn.get(Calendar.YEAR), checkIn.get(Calendar.MONTH), checkIn.get(Calendar.DAY_OF_MONTH));
    }

    public Calendar getCheckOut() {
        return new GregorianCalendar(checkOut.get(Calendar.YEAR), checkOut.get(Calendar.MONTH), checkOut.get(Calendar.DAY_OF_MONTH));
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public int getNumPersone() {
        return numPersone;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Nome: " + this.nome
                + "\nCheck-In: " + dateFormat.format(this.checkIn.getTime())
                + "\nCheck-Out: " + dateFormat.format(this.checkOut.getTime())
                + ((this.camera != null) ? "\nCamera: " + (this.camera.getNumeroCamera()) : "")
                + "\nNum Persone: " + this.numPersone
                + "\nBooking?: " + (this.isBooking ? "Y" : "F");
    }
}
