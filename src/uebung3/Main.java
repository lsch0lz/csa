package uebung3;

import java.sql.*;
import uebung3.secrets;

public class Main implements secrets {

    public static void main(String[] args) throws SQLException {

<<<<<<< HEAD
        insert("Dang", "Duy Anh", 10315, "Berlin", "Deutschland", "Hauptstrasse 15");
        select();
=======
        insertKunde("Mustermann", "Max", 12345, "Berlin", "Deutschland", "Musterstraße 123");
        insertKundePS("Scholz", "Lukas", 10315, "Berlin", "Deutschland", "Hauptstrasse 10");
        outputKunde();
>>>>>>> d5da52b9ef8528db95578625db72d41657924b73

        emptyTable("Kunde");
        outputKunde();

    }

    public static void insertKunde(String name, String vorname, int plz, String ort, String land, String strassehnr) throws SQLException  {
        Connection conn = DriverManager.getConnection(url, user, password);
        String insert = "INSERT INTO Kunde (Name, Vorname, PLZ, Ort, Land, StrasseHnr) VALUES ('" + name + "', '" + vorname + "', '" + plz +"', '" + ort + "', '" + land + "', '" + strassehnr + "');";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insert);

        conn.close();
    }


    public static void insertKundePS(String name, String vorname, int plz, String ort, String land, String strassehnr) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        String insert = "INSERT INTO Kunde (Name, Vorname, PLZ, Ort, Land, StrasseHnr) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(insert);

        statement.setString(1, name);
        statement.setString(2, vorname);
        statement.setInt(3, plz);
        statement.setString(4, ort);
        statement.setString(5, land);
        statement.setString(6, strassehnr);


        statement.executeUpdate();

        conn.close();
    }

    public static void outputKunde() throws  SQLException{
        System.out.println("--------------------------");
        System.out.println("Gebe Tabelle 'Kunde' aus: ");
        System.out.println();

        Connection conn = DriverManager.getConnection(url, user, password);

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


            System.out.println(name + " " + vorname + " " + plz + " " + ort + " " + land + " " + k_id + " " + strassehnr);
        }
        conn.close();

        System.out.println();
        System.out.println("Ende der Tabelle 'Kunde'.");
        System.out.println("--------------------------");
        System.out.println();
    }

    public static void emptyTable(String table) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);

        String delete = "DELETE FROM " + "`" + table + "`;";
        Statement stmt = conn.createStatement();
        stmt.execute(delete);

        conn.close();

        System.out.println("Leere Tabelle '" + table + "'.");

    }


}
