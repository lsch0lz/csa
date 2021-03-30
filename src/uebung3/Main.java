package uebung3;

import uebung3.DB.dbfunctions;

import java.sql.*;

public class Main implements secrets {

    public static void main(String[] args) throws SQLException {

        dbfunctions.startTime();
        dbfunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        dbfunctions.stopTime();

        dbfunctions.startTime();
        dbfunctions.insertKundePS("Scholz", "Lukas", 10315, "Berlin", "Deutschland", "Hauptstrasse 10");
        dbfunctions.stopTime();

        dbfunctions.outputKunde();

        dbfunctions.startTime();
        dbfunctions.updateTable("Kunde", "Name", "Meier", "Vorname", "Lukas");
        dbfunctions.stopTime();

        dbfunctions.outputKunde();

        dbfunctions.startTime();
        dbfunctions.updateTablePS("Kunde", "Name", "Scholz", "Vorname", "Lukas");
        dbfunctions.stopTime();

        dbfunctions.outputKunde();

        dbfunctions.startTime();
        dbfunctions.selectKunde("Scholz");
        dbfunctions.stopTime();

        dbfunctions.startTime();
        dbfunctions.selectKundePS("Scholz");
        dbfunctions.stopTime();

        dbfunctions.startTime();
        dbfunctions.deleteKundePS("Mustermann");
        dbfunctions.stopTime();

        dbfunctions.outputKunde();

        dbfunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");

        dbfunctions.startTime();
        dbfunctions.deleteKundePS("Scholz");
        dbfunctions.stopTime();

        dbfunctions.outputKunde();
        dbfunctions.emptyTable("Kunde");
        dbfunctions.outputKunde();

    }




}
