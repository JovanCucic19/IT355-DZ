/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.route.data;

/**
 *
 * @author Jovan
 */
public class Artikl {

    private String titl;
    private String opis;
    private double cena;

    public Artikl() {
    }

    public Artikl(String titl, String opis, double cena) {
        this.titl = titl;
        this.opis = opis;
        this.cena = cena;
    }

    public String getTitl() {
        return titl;
    }

    public void setTitl(String titl) {
        this.titl = titl;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

}
