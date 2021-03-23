package uebung3;

import java.sql.*;
import uebung3.secrets;

public class Main implements secrets{

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(url, user, password);

        String query = "SELECT * FROM test";

        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery(query);

        while(result.next()) {
            String name = result.getString("Name");

            System.out.println(name);
        }
        conn.close();

    }

}
