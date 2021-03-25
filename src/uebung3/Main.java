package uebung3;

import java.sql.*;
import uebung3.secrets;

public class Main implements secrets{

    public static void main(String[] args) throws SQLException {

        insert("Dang", "Duy Anh", 10315, "Berlin", "Deutschland", "Hauptstrasse 15");
        select();



    }

    public static void insert(String name, String vorname, int plz, String ort, String land, String strassehnr) throws SQLException {
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

    public static void select() throws  SQLException{
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
    }


}
