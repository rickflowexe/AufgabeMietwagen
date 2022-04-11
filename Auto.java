package com.company;

public class Auto {
    /**
     * Klasse Auto wird verwendet um Auto Objekte zu erzeugen
     */
    int id, ps;
    String hersteller;
    double preis;

    /**
     *
     * @param id Ist die Ordnungszahl
     * @param hersteller Ist der Hersteller
     * @param ps Anzahl der PS
     * @param preis Preis des Autos
     */

    //    Konstruktur
    public Auto(int id, String hersteller, int ps, double preis) {
        this.id = id;
        this.hersteller = hersteller;
        this.ps = ps;
        this.preis = preis;
    }

    public Auto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
