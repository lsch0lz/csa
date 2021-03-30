package uebung3;

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
        dbfunctions.updateTable("Kunde", "Name", "Meier", "Vorname", "Lukas");
        dbfunctions.outputKunde();
        dbfunctions.updateTablePS("Kunde", "Name", "Scholz", "Vorname", "Lukas");
        dbfunctions.outputKunde();

        long startTimeStatementSelect = System.nanoTime();
        dbfunctions.selectKunde("Scholz");
        long stopTimeStatementSelect = System.nanoTime();
        long timeStatementSelect = stopTimeStatementSelect - startTimeStatementSelect;
        System.out.println("Zeit SELECT Statement: " + timeStatementSelect);

        long startTimePSSelect = System.nanoTime();
        dbfunctions.selectKundePS("Scholz");
        long stopTimePSSelect = System.nanoTime();
        long timePSSelect = stopTimePSSelect - startTimePSSelect;
        System.out.println("Zeit SELECT PreparedStatement: " + timePSSelect);

        long startTimeStatementDelete = System.nanoTime();
        dbfunctions.deleteKundePS("Mustermann");
        long stopTimeStatementDelete = System.nanoTime();
        long timeStatementDelete = stopTimeStatementDelete - startTimeStatementDelete;
        System.out.println("Zeit DELETE Statement: " + timeStatementDelete);

        dbfunctions.outputKunde();
        dbfunctions.insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");

        long startTimePreparedStatementDelete = System.nanoTime();
        dbfunctions.deleteKundePS("Scholz");
        long stopTimePreparedStatementDelete = System.nanoTime();
        long timePreparedStatementDelete = stopTimePreparedStatementDelete -startTimePreparedStatementDelete;
        System.out.println("Zeit DELETE PreparedStatement: " + timePreparedStatementDelete);

        dbfunctions.outputKunde();
        dbfunctions.emptyTable("Kunde");
        dbfunctions.outputKunde();

    }




}
