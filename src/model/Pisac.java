/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author boki
 */
public class Pisac {

    private Long id;
    private String ime;
    private String prezime;

    public Pisac() {
    }

    public Pisac(Long id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Pisac(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;

    }

    public void setIme(String ime) {
        if (ime == null) {
            System.out.println("Uneto ime ne sme biti null");
        } else {
            this.ime = ime;
        }
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        if (prezime == null) {
            System.out.println("Uneto prezime ne sme biti null");
        } else {
            this.prezime = prezime;
        }
    }

    public String toString() {
        return ime + " " + prezime;
    }

}
