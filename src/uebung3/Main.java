package uebung3;

import uebung3.DTO.*;

import java.sql.*;
import java.util.ArrayList;

import static uebung3.DB.DBFunctions.*;

public class Main implements secrets {
    // DTOs gespeichert in ArrayLists
    static ArrayList<Kunde> kunden = new ArrayList<>();
    static ArrayList<Bestellung> bestellungen = new ArrayList<>();
    static ArrayList<Beinhaltet> beinhaltet = new ArrayList<>();
    static ArrayList<Artikel> artikel = new ArrayList<>();

    /**
     * Methode laedt alle Instanzen aus der DB uns speichert sie lokal in die DTOs zwischen.
     *
     * @throws SQLException
     */
    public static void getDBContent() throws SQLException {
        getKunden(kunden);
        getBestellungen(bestellungen);
        getBeinhaltet(beinhaltet);
        getArtikel(artikel);
    }

    public static void main(String[] args) throws Exception {
        getDBContent();

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
