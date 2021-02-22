import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
            // Set up connection to database
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "SAD" +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    JOptionPane.showInputDialog(null, "Username"), JOptionPane.showInputDialog(null, "Password"));

            Statement stmt = conn.createStatement();
            Scanner scanner = new Scanner(System.in);
            int activeRoom = 1;

            while(activeRoom != 0) {
                String strSelect = "select body from story where id = " + activeRoom;
                ResultSet results = stmt.executeQuery(strSelect);
                results.next();
                System.out.println(results.getString("body"));


                results = stmt.executeQuery("select body, target_id from links where parent_id = " + activeRoom);
                ArrayList<Integer> links = new ArrayList();

            int link_amt = 0;
            while (results.next()) {
                String description = results.getString("body");
                int storyLink = results.getInt("target_id");
                links.add(storyLink);
                System.out.println(++link_amt + " " + description);
            }

            if (link_amt == 0) {
                System.out.println("Sorry, we can't find any paths from here...");
                System.out.println("You have been sent back to the start");
                activeRoom = 1;
            } else {
                int input = scanner.nextInt();
                while (input < 1 || input > links.size()) {
                    System.out.println("Illegal choice, try again");
                    input = scanner.nextInt();
                }
                activeRoom = links.get(input - 1);
            }



            }

            conn.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
