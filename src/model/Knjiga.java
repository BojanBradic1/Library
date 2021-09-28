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
public class Knjiga {

    private Long id;
    private String naslov;
    private Pisac pisac;
    private Kategorija kategorija;
    private String izdavac;

    public Knjiga() {
    }

    public Knjiga(Long id, String naslov, Pisac pisac, Kategorija kategorija, String izdavac) {
        this.id = id;
        this.naslov = naslov;
        this.pisac = pisac;
        this.kategorija = kategorija;
        this.izdavac = izdavac;
    }

    public Knjiga(String naslov, Pisac pisac, Kategorija kategorija, String izdavac) {
        this.naslov = naslov;
        this.pisac = pisac;
        this.kategorija = kategorija;
        this.izdavac = izdavac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        if (naslov == null) {
            System.out.println("Uneti naslov ne sme biti null");
        } else {
            this.naslov = naslov;
        }
    }

    public Pisac getPisac() {
        return pisac;
    }

    public void setPisac(Pisac pisac) {
        if (pisac == null) {
            System.out.println("Uneti pisac ne sme biti null");
        } else {
            this.pisac = pisac;
        }
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        if (kategorija == null) {
            System.out.println("Uneti zanr ne sme biti null");
        } else {
            this.kategorija = kategorija;
        }
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        if (izdavac == null) {
            System.out.println("Uneti izdavac ne sme biti null");
        } else {
            this.izdavac = izdavac;
        }
    }

    public String toString() {
        return "Knjiga: id-" + id + "Naslov-" + naslov + "Pisac-" + pisac + "Zanr-" + kategorija.getNaziv() + "Izdavac-" + izdavac;
    }

}
