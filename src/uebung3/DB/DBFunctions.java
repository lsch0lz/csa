package uebung3.DB;

import uebung3.DTO.*;
import uebung3.secrets;

import java.sql.*;
import java.util.ArrayList;

public class DBFunctions implements secrets {

    public static void print(String msg){
        System.out.println(msg);
    }

    public static long startTime() {
        long start = System.nanoTime();
        return start;
    }

    public static void stopTime(){
        long start = startTime();
        long stop = System.nanoTime();
        long time = stop - start;
        print("Zeit des Querys: " + time);
        print("");
    }

    public static Connection conn() throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //select
    public static void getKunden(ArrayList<Kunde> kunden) throws  SQLException {
        Connection conn = conn();
        String query = "SELECT * FROM Kunde";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()) {
            String name = result.getString("Name");
            String vorname = result.getString("Vorname");
            int plz = result.getInt("PLZ");
            String ort = result.getString("Ort");
            String land = result.getString("Land");
            int k_id = result.getInt("K-ID");
            String strassehnr = result.getString("StrasseHnr");

            kunden.add(new Kunde(k_id, name, vorname, plz, ort, land, strassehnr));
        }
        conn.close();
    }

    public static void getBestellungen(ArrayList<Bestellung> bestellungen) throws  SQLException {
        Connection conn = conn();
        String query = "SELECT * FROM Bestellung";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()) {
            long bID = result.getLong("B-ID");
            long kID = result.getLong("K-ID");

            bestellungen.add(new Bestellung(bID, kID));
        }
        conn.close();
    }

    public static void getBeinhaltet(ArrayList<Beinhaltet> beinhaltet) throws  SQLException {
        Connection conn = conn();
        String query = "SELECT * FROM Beinhaltet";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()) {
            long aID = result.getLong("A-ID");
            long bID = result.getLong("B-ID");

            beinhaltet.add(new Beinhaltet(aID, bID));
        }
        conn.close();
    }

    public static void getArtikel(ArrayList<Artikel> artikel) throws  SQLException {
        Connection conn = conn();
        String query = "SELECT * FROM Artikel";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()) {
            long aID = result.getLong("A-ID");
            String bezeichnung = result.getString("Bezeichnung");
            double preis = result.getDouble("Preis");

            artikel.add(new Artikel(aID, bezeichnung, preis));
        }
        conn.close();
    }

    //insert Statement
    public static void insertKunde(Kunde kunde) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Kunde (Name, Vorname, PLZ, Ort, Land, StrasseHnr) VALUES ('" + kunde.getName() + "', '" + kunde.getVorname() + "', '" + kunde.getPlz() +"', '" + kunde.getOrt() + "', '" + kunde.getLand() + "', '" + kunde.getStrasseHnr() + "');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insert);
        conn.close();
    }

    public static void insertBestellung(Bestellung bestellung) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Bestellung (B-ID, K-ID) VALUES ('" + bestellung.getbID() + "', '" + bestellung.getkID() + "');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insert);
        conn.close();
    }

    public static void insertBeinhaltet(Beinhaltet beinhaltet) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Beinhaltet (A-ID, B-ID) VALUES ('" + beinhaltet.getaID() + "', '" + beinhaltet.getbID() + "');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insert);
        conn.close();
    }

    public static void insertArtikel(Artikel artikel) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Artikel (A-ID, Bezeichnung, Preis) VALUES ('" + artikel.getaID() + "', '" + artikel.getBezeichnung() + "', '" + artikel.getPreis() +"');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insert);
        conn.close();
    }

    //insert PreparedStatement
    public static void insertKundePS(Kunde kunde) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Kunde (Name, Vorname, PLZ, Ort, Land, StrasseHnr) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(insert);

        statement.setString(1, kunde.getName());
        statement.setString(2, kunde.getVorname());
        statement.setInt(3, kunde.getPlz());
        statement.setString(4, kunde.getOrt());
        statement.setString(5, kunde.getLand());
        statement.setString(6, kunde.getStrasseHnr());

        statement.executeUpdate();
        conn.close();
    }

    public static void insertBestellungPS(Bestellung bestellung) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Bestellung (B-ID, K-ID) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(insert);

        statement.setLong(1, bestellung.getbID());
        statement.setLong(2, bestellung.getkID());

        statement.executeUpdate();
        conn.close();
    }

    public static void insertBeinhaltetPS(Beinhaltet beinhaltet) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Beinhaltet (A-ID, B-ID) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(insert);

        statement.setLong(1, beinhaltet.getaID());
        statement.setLong(2, beinhaltet.getbID());

        statement.executeUpdate();
        conn.close();
    }

    public static void insertArtikelPS(Artikel artikel) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Artikel (A-ID, Bezeichnung, Preis) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(insert);

        statement.setLong(1, artikel.getaID());
        statement.setString(2, artikel.getBezeichnung());
        statement.setDouble(3, artikel.getPreis());

        statement.executeUpdate();
        conn.close();
    }

    //delete Statement
    public static void emptyTable(String table) throws SQLException {
        Connection conn = conn();

        String delete = "DELETE FROM `" + table + "`;";
        Statement stmt = conn.createStatement();
        stmt.execute(delete);

        conn.close();
    }

    //update Statement
    public static void updateEntity(Object entity) throws Exception {
        if(entity.getClass().getName().equals("Kunde")) {

        } else if(entity.getClass().getName().equals("Bestellung")) {

        } else if(entity.getClass().getName().equals("Beinhaltet")) {

        } else if(entity.getClass().getName().equals("Artikel")) {

        } else {
            throw new Exception("Keine gültige Entität übergeben!");
        }
    }


    //update Statement
    public static void updateTable(String table, String changingColumn, String changingValue, String column, String value) throws SQLException {
        Connection conn = conn();

        String update = "UPDATE "  + table  + " SET " +  changingColumn + "= " + "'" + changingValue + "'" + " WHERE " + column + "= " + "'" + value + "'" + ";";
        Statement stmt = conn.createStatement();
        print("Verändere Tabelle '" + table + "'.");
        stmt.execute(update);
        print("Update Statement");
        conn.close();



    }

    //update PreparedStatement
    public static void updateTablePS(String table, String changingColumn, String changingValue, String column, String value) throws SQLException {

        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("UPDATE Kunde SET Name= ? WHERE Vorname= ?;");

        ps.setString(1, changingValue);
        ps.setString(2, value);

        print("Verändere Tabelle '" + table + "'.");

        ps.executeUpdate();
        ps.close();
        print("Update PreparedStatment");
        conn.close();
    }








    public static void selectKunde(String name) throws SQLException{
        Connection conn = conn();

        String select = "SELECT * FROM Kunde WHERE Name= '" + name + "';";
        Statement statement = conn.createStatement();

        print("Gebe Kunden: " + name + " aus");
        ResultSet result = statement.executeQuery(select);
        while(result.next()) {
            String nameKunde = result.getString("Name");
            String vorname = result.getString("Vorname");
            int plz = result.getInt("PLZ");
            String ort = result.getString("Ort");
            String land = result.getString("Land");
            int k_id = result.getInt("K-ID");
            String strassehnr = result.getString("StrasseHnr");

            print(nameKunde + " " + vorname + " " + plz + " " + ort + " " + land + " " + k_id + " " + strassehnr);
        }
        print("");
        print("Select Statement");
        conn.close();
    }

    public  static void selectKundePS(String name) throws SQLException{
        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Kunde WHERE Name= ?");
        ps.setString(1, name);
        print("Gebe Kunden: " + name + " aus");

        ResultSet result = ps.executeQuery();
        while(result.next()) {
            String nameKunde = result.getString("Name");
            String vorname = result.getString("Vorname");
            int plz = result.getInt("PLZ");
            String ort = result.getString("Ort");
            String land = result.getString("Land");
            int k_id = result.getInt("K-ID");
            String strassehnr = result.getString("StrasseHnr");

            print(nameKunde + " " + vorname + " " + plz + " " + ort + " " + land + " " + k_id + " " + strassehnr);
        }
        print("");
        print("Select PreparedStatement");
        ps.close();
        conn.close();
    }

    public static void deleteKunde(String name) throws SQLException{
        Connection conn = conn();

        String delete = "DELETE FROM KUNDE WHERE Name= " + "`" + name + "`;";
        Statement stmt = conn.createStatement();
        print("Lösche Kunde'" + name + "'.");
        stmt.execute(delete);
        print("Delete Statement");
        conn.close();
    }

    public static void deleteKundePS(String name) throws SQLException{
        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Kunde WHERE Name= ?");

        ps.setString(1, name);

        print("Lösche Kunde'" + name + "'.");

        ps.executeUpdate();
        print("Delete PreparedStatement");
        ps.close();
        conn.close();

    }

    //update Statement
    public static void updateTable(String table, String changingColumn, String changingValue, String column, String value) throws SQLException {
        Connection conn = conn();

        String update = "UPDATE "  + table  + " SET " +  changingColumn + "= " + "'" + changingValue + "'" + " WHERE " + column + "= " + "'" + value + "'" + ";";
        Statement stmt = conn.createStatement();
        print("Verändere Tabelle '" + table + "'.");
        stmt.execute(update);
        print("Update Statement");
        conn.close();



    }

    //update PreparedStatement
    public static void updateTablePS(String table, String changingColumn, String changingValue, String column, String value) throws SQLException {

        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("UPDATE Kunde SET Name= ? WHERE Vorname= ?;");

        ps.setString(1, changingValue);
        ps.setString(2, value);

        print("Verändere Tabelle '" + table + "'.");

        ps.executeUpdate();
        ps.close();
        print("Update PreparedStatment");
        conn.close();
    }
}
