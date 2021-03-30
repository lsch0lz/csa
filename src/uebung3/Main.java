package uebung3;

import uebung3.DTO.*;

import java.sql.*;
import java.util.ArrayList;

import static uebung3.DB.DBFunctions.*;

public class Main implements secrets {
    // DTOs gespeichert in ArrayLists
    static ArrayList<Kunde> kunden = null;
    static ArrayList<Bestellung> bestellungen = null;
    static ArrayList<Beinhaltet> beinhaltet = null;
    static ArrayList<Artikel> artikel = null;

    /**
     * Methode laedt alle Instanzen aus der DB uns speichert sie lokal in die DTOs zwischen.
     *
     * @throws SQLException
     */
    public static void getDBContent() throws SQLException {
        kunden = new ArrayList<>();
        bestellungen = new ArrayList<>();
        beinhaltet = new ArrayList<>();
        artikel = new ArrayList<>();

        getKunden(kunden);
        getBestellungen(bestellungen);
        getBeinhaltet(beinhaltet);
        getArtikel(artikel);
    }

    public static void outputAllDTO() {
        System.out.println("");
        System.out.println("Kunden aus DB:");
        for (int i = 0; i < kunden.size(); i++) {
            System.out.println((kunden.get(i).toString()));
        }

        System.out.println("");
        System.out.println("Bestellungen aus DB:");
        for (int i = 0; i < bestellungen.size(); i++) {
            System.out.println((bestellungen.get(i).toString()));
        }

        System.out.println("");
        System.out.println("Beinhaltet aus DB:");
        for (int i = 0; i < beinhaltet.size(); i++) {
            System.out.println((beinhaltet.get(i).toString()));
        }

        System.out.println("");
        System.out.println("Artikel aus DB:");
        for (int i = 0; i < artikel.size(); i++) {
            System.out.println((artikel.get(i).toString()));
        }
    }

    public static void emptyDB() throws SQLException {
        emptyTable("Kunde");
        emptyTable("Bestellung");
        emptyTable("Beinhaltet");
        emptyTable("Artikel");
    }

    public static void main(String[] args) throws Exception {
        print("Leere DB!");
        emptyDB();

        print("Erstelle lokale Entitaeten!");
        Artikel a1 = new Artikel("Springseil 1m", 19.95);
        Artikel a2 = new Artikel("Springseil 1.5m", 22.95);
        Artikel a3 = new Artikel("Springseil 2m", 24.95);
        Artikel a4 = new Artikel("Springseil 2.5m", 28.95);

        Kunde k1 = new Kunde("Mustermann", "Max", 12345, "Berlin", "DE", "Musterstr. 12");
        Kunde k2 = new Kunde("Musterfrau", "Anna", 54321, "Berlin", "DE", "Musterstr. 21");

        Bestellung b1 = new Bestellung(1);
        Bestellung b2 = new Bestellung(2);

        Beinhaltet c1 = new Beinhaltet(2, 1);
        Beinhaltet c2 = new Beinhaltet(4, 2);

        print("Schreibe lokale Entitaeten in DB!");
        startTime();
        insertArtikel(a1);
        insertArtikel(a2);
        stopTime();

        startTime();
        insertArtikelPS(a3);
        insertArtikelPS(a4);
        stopTime();

        insertKunde(k1);
        insertKundePS(k2);

        insertBestellung(b1);
        insertBestellungPS(b2);

        insertBeinhaltet(c1);
        insertBeinhaltetPS(c2);

        print("Lade alle Entitaeten aus DB!");
        getDBContent();
        outputAllDTO();

        print("Veraendere lokale Entitaeten!");
        k1 = kunden.get(0);
        k1.setName("Frau");

        a1 = artikel.get(0);
        a1.setPreis(15.95);

        print("Schreibe Veraenderungen in DB!");
        updateEntity(k1);
        updateEntity(a1);

        print("Lade alle Entitaeten aus DB!");
        getDBContent();
        outputAllDTO();



        /**
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        */



        /**
        DBFunctions.startTime();
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.stopTime();

        DBFunctions.startTime();
        DBFunctions.insertKundePS("Scholz", "Lukas", 10315, "Berlin", "Deutschland", "Hauptstrasse 10");
        DBFunctions.stopTime();

        outputKunde();

        DBFunctions.startTime();
        DBFunctions.updateTable("Kunde", "Name", "Meier", "Vorname", "Lukas");
        DBFunctions.stopTime();

        outputKunde();

        DBFunctions.startTime();
        DBFunctions.updateTablePS("Kunde", "Name", "Scholz", "Vorname", "Lukas");
        DBFunctions.stopTime();

        outputKunde();

        DBFunctions.startTime();
        DBFunctions.selectKunde("Scholz");
        DBFunctions.stopTime();

        DBFunctions.startTime();
        DBFunctions.selectKundePS("Scholz");
        DBFunctions.stopTime();

        DBFunctions.startTime();
        DBFunctions.deleteKundePS("Mustermann");
        DBFunctions.stopTime();

        outputKunde();

        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");

        DBFunctions.startTime();
        DBFunctions.deleteKundePS("Scholz");
        DBFunctions.stopTime();

        outputKunde();
        DBFunctions.emptyTable("Kunde");
        outputKunde();
        */
    }




}
