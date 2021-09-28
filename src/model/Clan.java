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
public class Clan {

    private Long id;
    private String ime;
    private String prezime;
    private String nadimak;

    public Clan() {
    }

    public Clan(Long id, String ime, String prezime, String nadimak) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.nadimak = nadimak;
    }

    public Clan(String ime, String prezime, String nadimak) {
        this.ime = ime;
        this.prezime = prezime;
        this.nadimak = nadimak;
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

    public String getNadimak() {
        return nadimak;
    }

    public void setNadimak(String nadimak) {
        if (nadimak == null) {
            System.out.println("Uneti nadimak ne sme biti null");
        } else {
            this.nadimak = nadimak;
        }
    }

    public String toString() {
        return ime + " " + prezime;
    }
}
