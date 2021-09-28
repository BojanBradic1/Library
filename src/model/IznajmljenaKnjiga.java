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
public class IznajmljenaKnjiga {

    private Clan clan;
    private Knjiga knjiga;

    public IznajmljenaKnjiga() {
    }

    public IznajmljenaKnjiga(Clan clan, Knjiga knjiga) {
        this.clan = clan;
        this.knjiga = knjiga;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
}
