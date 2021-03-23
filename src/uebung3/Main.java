package uebung3;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://lukasscholz.de:3306/d035dbd4?useSSL=false&serverTimezone=Europe/Warsaw";
        String user = "d035dbd4";
        String password = "uN5s45ppG2G3YwJ5";

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
