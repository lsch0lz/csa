package uebung3;

import uebung3.DB.DBFunctions;
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
        outputKunde(kunden);
    }

    public static void main(String[] args) throws Exception {
        getDBContent();


        for (int i = 0; i < kunden.size(); i++) {
            System.out.println((kunden.toString()));
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
