package uebung3;

import uebung3.DB.DBFunctions;

import java.sql.*;

public class Main implements secrets {

    public static void main(String[] args) throws SQLException {

        DBFunctions.startTime();
        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        DBFunctions.stopTime();

        DBFunctions.startTime();
        DBFunctions.insertKundePS("Scholz", "Lukas", 10315, "Berlin", "Deutschland", "Hauptstrasse 10");
        DBFunctions.stopTime();

        DBFunctions.outputKunde();

        DBFunctions.startTime();
        DBFunctions.updateTable("Kunde", "Name", "Meier", "Vorname", "Lukas");
        DBFunctions.stopTime();

        DBFunctions.outputKunde();

        DBFunctions.startTime();
        DBFunctions.updateTablePS("Kunde", "Name", "Scholz", "Vorname", "Lukas");
        DBFunctions.stopTime();

        DBFunctions.outputKunde();

        DBFunctions.startTime();
        DBFunctions.selectKunde("Scholz");
        DBFunctions.stopTime();

        DBFunctions.startTime();
        DBFunctions.selectKundePS("Scholz");
        DBFunctions.stopTime();

        DBFunctions.startTime();
        DBFunctions.deleteKundePS("Mustermann");
        DBFunctions.stopTime();

        DBFunctions.outputKunde();

        DBFunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");

        DBFunctions.startTime();
        DBFunctions.deleteKundePS("Scholz");
        DBFunctions.stopTime();

        DBFunctions.outputKunde();
        DBFunctions.emptyTable("Kunde");
        DBFunctions.outputKunde();

    }




}
