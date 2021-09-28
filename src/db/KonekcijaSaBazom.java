/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clan;
import model.IznajmljenaKnjiga;
import model.Kategorija;
import model.Knjiga;
import model.Pisac;

/**
 *
 * @author boki
 */
public class KonekcijaSaBazom {

    private static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/biblioteka";

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;
    private Statement statement;

    public KonekcijaSaBazom() {
        try {
            //TODO: ostvari konekciju sa bazom
            Class.forName(JDBC_DRIVER_NAME);
            connection = DriverManager.getConnection(DATABASE_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Knjiga nadjiKnjiguPoId(Long id) {
        try {
            String query = "select knjiga.knjiga_id, knjiga.id_pisac, knjiga.naslov, knjiga.kategorija_id, knjiga.izdavac, pisac.ime, pisac.prezime "
                    + "from knjiga inner join pisac on knjiga.id_pisac = pisac.id_pisac "
                    + "where knjiga_id = " + id;

            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                Long idKnjige = rs.getLong("knjiga_id");

                Pisac pisac = kreirajObjekatPisac(rs, null);

                String naslov = rs.getString("naslov");
                Kategorija kategorija = nadjiKategorijuPoId(rs.getLong("kategorija_id"));
                String izdavac = rs.getString("izdavac");

                Knjiga knjiga = new Knjiga(idKnjige, naslov, pisac, kategorija, izdavac);
                return knjiga;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean dodajKnjigu(Knjiga knjiga) {
        boolean success = false;
        try {
            if (knjiga.getNaslov() == null
                    || knjiga.getNaslov().length() == 0
                    || knjiga.getKategorija() == null
                    || knjiga.getIzdavac() == null
                    || knjiga.getIzdavac().length() == 0) {
                return false;
            }

            String query = "insert into knjiga(id_pisac, naslov, kategorija_id, izdavac) values(?, ?, ?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setLong(1, knjiga.getPisac().getId());
            prepStatement.setString(2, knjiga.getNaslov());
            prepStatement.setLong(3, knjiga.getKategorija().getId());
            prepStatement.setString(4, knjiga.getIzdavac());
            prepStatement.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public List<Knjiga> vratiSveKnjige() {
        String query = "select * from knjiga";
        List<Knjiga> knjige = new ArrayList<Knjiga>();
        try {
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("knjiga_id");
                Long id_pisca = rs.getLong("id_pisac");
                Pisac pisac = nadjiPiscaPoId(id_pisca);

                String naslov = rs.getString("naslov");

                Kategorija kategorija = nadjiKategorijuPoId(rs.getLong("kategorija_id"));
                String izdavac = rs.getString("izdavac");

                Knjiga knjiga = new Knjiga(id, naslov, pisac, kategorija, izdavac);
                knjige.add(knjiga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return knjige;
    }

    public Clan nadjiClanaPoId(Long id) {
        try {
            String query = "select clan.clan_id, clan.ime, clan.prezime, clan.nadimak from clan where clan.clan_id = " + id;

            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String nadimak = rs.getString("nadimak");
                Clan clan = new Clan(id, ime, prezime, nadimak);
                return clan;
            }

        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean dodajClana(Clan clan) {
        boolean success = false;

        try {
            if (clan.getIme() == null
                    || clan.getIme().length() == 0
                    || clan.getPrezime() == null
                    || clan.getPrezime().length() == 0) {
                return false;
            }
            String query = "insert into clan(ime,prezime,nadimak) values(?,?,?)";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, clan.getIme());
            prepStatement.setString(2, clan.getPrezime());
            prepStatement.setString(3, clan.getNadimak());
            prepStatement.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }

        return success;
    }

    public Clan vratiClanaSaId(Long id) {
        Clan clan = new Clan();

        return clan;
    }

    public List<Clan> vratiSveClanove() {
        String query = "select * from clan";
        List<Clan> clanovi = new ArrayList<Clan>();
        try {
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("clan_id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String nadimak = rs.getString("nadimak");
                Clan clan = new Clan(id, ime, prezime, nadimak);
                clanovi.add(clan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clanovi;
    }

    public Kategorija nadjiKategorijuPoId(Long id) {
        try {
            String query = "select id, naziv from kategorija where id = " + id;
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {

                Long idKategorije = rs.getLong("id");

                String naziv = rs.getString("naziv");
                Kategorija kategorija = new Kategorija(id, naziv);
                return kategorija;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean dodajKategoriju(Kategorija kategorija) {
        boolean success = false;

        try {
            if (kategorija.getNaziv() == null
                    || kategorija.getNaziv().length() == 0) {
                return false;
            }
            String query = "insert into kategorija(naziv) values(?)";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, kategorija.getNaziv());
            prepStatement.executeUpdate();

            success = true;

        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public List<Kategorija> vratiSveKategorije() {
        String query = "select * from kategorija";
        List<Kategorija> kategorije = new ArrayList<Kategorija>();
        try {
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String naziv = rs.getString("naziv");

                Kategorija kategorija = new Kategorija(id, naziv);
                kategorije.add(kategorija);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kategorije;
    }

    public Pisac nadjiPiscaPoId(Long id) {
        try {
            String query = "select pisac.id_pisac,pisac.ime,pisac.prezime from pisac where pisac.id_pisac = " + id;
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {

                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");

                Pisac pisac = new Pisac(id, ime, prezime);
                return pisac;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Pisac> vratiSvePisce() {
        String query = "select * from pisac";
        List<Pisac> pisci = new ArrayList<Pisac>();
        try {
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("id_pisac");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");

                Pisac pisac = new Pisac(id, ime, prezime);
                pisci.add(pisac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pisci;
    }

    public boolean dodajPisca(Pisac pisac) {
        boolean success = false;

        try {
            if (pisac.getIme() == null
                    || pisac.getIme().length() == 0
                    || pisac.getPrezime() == null
                    || pisac.getPrezime().length() == 0) {
                return false;
            }
            String query = "insert into pisac(ime,prezime) values(?,?)";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, pisac.getIme());
            prepStatement.setString(2, pisac.getPrezime());
            prepStatement.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }

        return success;
    }

    private Pisac kreirajObjekatPisac(ResultSet rs, Long id) throws SQLException {
        if (id == null) {
            id = rs.getLong("id_pisac");
        }

        String ime = rs.getString("ime");
        String prezime = rs.getString("prezime");
        Pisac pisac = new Pisac(id, ime, prezime);
        return pisac;
    }

    public List<Knjiga> vratiKnjigeOdPisca(Pisac pisac) {
        List<Knjiga> knjige = new ArrayList<Knjiga>();
        try {
            String query = "SELECT * FROM knjiga WHERE id_pisac = " + pisac.getId();
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("knjiga_id");
                String naslov = rs.getString("naslov");

                Kategorija kategorija = nadjiKategorijuPoId(rs.getLong("kategorija_id"));
                String izdavac = rs.getString("izdavac");

                Knjiga knjiga = new Knjiga(id, naslov, pisac, kategorija, izdavac);
                knjige.add(knjiga);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }

        return knjige;
    }

    public boolean zaduziKnjigu(Clan clan, Knjiga knjiga) {
        boolean success = false;
        try {
            if (knjiga == null || clan == null) {
                return false;
            }

            String query = "insert into iznajmljene_knjige (id_knjige, id_clana) values(?, ?)";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setLong(1, knjiga.getId());
            prepStatement.setLong(2, clan.getId());
            prepStatement.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public List<IznajmljenaKnjiga> vratiListuIznajmljenihKnjiga() {
        String query = "select * from iznajmljene_knjige";
        List<IznajmljenaKnjiga> listaIznajmljenihKnjiga = new ArrayList<IznajmljenaKnjiga>();
        try {
            System.out.println(query);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Knjiga knjiga = nadjiKnjiguPoId(rs.getLong("id_knjige"));
                Clan clan = nadjiClanaPoId(rs.getLong("id_clana"));

                listaIznajmljenihKnjiga.add(new IznajmljenaKnjiga(clan, knjiga));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIznajmljenihKnjiga;
    }

    public boolean razduziKnjigu(IznajmljenaKnjiga knjiga) {
        boolean success = false;
        try {
            if (knjiga == null) {
                return false;
            }

            String query = "delete from iznajmljene_knjige where id_knjige = ? and id_clana = ?";
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setLong(1, knjiga.getKnjiga().getId());
            prepStatement.setLong(2, knjiga.getClan().getId());
            prepStatement.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(KonekcijaSaBazom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
