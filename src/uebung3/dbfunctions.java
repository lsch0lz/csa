package uebung3;

import java.sql.*;

public class dbfunctions implements secrets {

    public static Connection conn() throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //insert Statement
    public static void insertKunde(String name, String vorname, int plz, String ort, String land, String strassehnr) throws SQLException {
        Connection conn = conn();
        String insert = "INSERT INTO Kunde (Name, Vorname, PLZ, Ort, Land, StrasseHnr) VALUES ('" + name + "', '" + vorname + "', '" + plz +"', '" + ort + "', '" + land + "', '" + strassehnr + "');";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(insert);

        conn.close();
    }

    //insert PreparedStatement
    public static void insertKundePS(String name, String vorname, int plz, String ort, String land, String strassehnr) throws SQLException {
        Connection conn = conn();
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

    //select
    public static void outputKunde() throws  SQLException{
        System.out.println("--------------------------");
        System.out.println("Gebe Tabelle 'Kunde' aus: ");
        System.out.println();

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


            System.out.println(name + " " + vorname + " " + plz + " " + ort + " " + land + " " + k_id + " " + strassehnr);
        }
        conn.close();

        System.out.println();
        System.out.println("Ende der Tabelle 'Kunde'.");
        System.out.println("--------------------------");
        System.out.println();
    }

    //delete Statement
    public static void emptyTable(String table) throws SQLException {
        Connection conn = conn();

        String delete = "DELETE FROM " + "`" + table + "`;";
        Statement stmt = conn.createStatement();
        stmt.execute(delete);

        conn.close();

        System.out.println("Leere Tabelle '" + table + "'.");

    }

    public static void selectKunde(String name) throws SQLException{
        Connection conn = conn();

        String select = "SELECT * FROM Kunde WHERE Name= " + "'" + name + "';";
        Statement statement = conn.createStatement();

        System.out.println("Gebe Kunden: " + name + " aus.");
        statement.execute(select);

        conn.close();
    }

    public  static void selectKundePS(String name) throws SQLException{
        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Kunde WHERE Name= ?");
        ps.setString(1, name);
        System.out.println("Gebe Kunden: " + name + " aus.");

        ps.executeQuery();
        ps.close();
        conn.close();
    }

    public static void deleteKunde(String name) throws SQLException{
        Connection conn = conn();

        String delete = "DELETE FROM KUNDE WHERE Name= " + "`" + name + "`;";
        Statement stmt = conn.createStatement();
        stmt.execute(delete);

        System.out.println("Lösche Kunde'" + name + "'.");

        conn.close();
    }

    public static void deleteKundePS(String name) throws SQLException{
        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Kunde WHERE Name= ?");

        ps.setString(1, name);

        System.out.println("Lösche Kunde'" + name + "'.");

        ps.executeUpdate();
        ps.close();
        conn.close();

    }

    //update Statement
    public static void updateTable(String table, String changingColumn, String changingValue, String column, String value) throws SQLException {
        Connection conn = conn();

        String update = "UPDATE "  + table  + " SET " +  changingColumn + "= " + "'" + changingValue + "'" + " WHERE " + column + "= " + "'" + value + "'" + ";";
        Statement stmt = conn.createStatement();
        stmt.execute(update);

        conn.close();

        System.out.println("Verändere Tabelle '" + table + "'.");

    }

    //update PreparedStatement
    public static void updateTablePS(String table, String changingColumn, String changingValue, String column, String value) throws SQLException {

        Connection conn = conn();

        PreparedStatement ps = conn.prepareStatement("UPDATE Kunde SET Name= ? WHERE Vorname= ?;");

        ps.setString(1, changingValue);
        ps.setString(2, value);

        System.out.println("Verändere Tabelle '" + table + "'.");

        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
