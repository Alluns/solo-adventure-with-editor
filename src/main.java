import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
            // Set up connection to database
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "SAD" +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "Allun", JOptionPane.showInputDialog(null, "Password"));

            // Variables

            Statement stmt = conn.createStatement();
            Scanner scanner = new Scanner(System.in);
            int activeRoom = 1;

            //   Variables   //



            //  Main Loop

            while(activeRoom != 0) {
                String strSelect = "select body from story where id = " + activeRoom;
                ResultSet results = stmt.executeQuery(strSelect);
                results.next();
                System.out.println(results.getString("body"));
            }

            //  Main Loop   //

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
