package _002WritingYourOwnDataRetrievalApplication;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.3.2018 г.
 * Time: 20:13 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.*;
import java.util.Properties;

public class WritingYourOwnDataRetrievalApplication {
    public static void main(String[] args) throws IOException, SQLException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "1234");

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://"
                            + "localhost:3306/diablo", prop);

            String user = reader.readLine();

            String workbench = "SELECT \n" +
                    "    `u`.`user_name`,\n" +
                    "    `u`.`first_name`,\n" +
                    "    `u`.`last_name`,\n" +
                    "    COUNT(`ug`.`game_id`) AS `games`\n" +
                    "FROM\n" +
                    "    `users` AS `u`\n" +
                    "        JOIN\n" +
                    "    `users_games` AS `ug` ON `u`.`id` = `ug`.`user_id`\n" +
                    "WHERE\n" +
                    "    `user_name` = ?;";

            prstmt = conn.prepareStatement(workbench);

            prstmt.setString(1, user);

            rs = prstmt.executeQuery();

            if (rs.next() && rs.getString(1) != null) {
                System.out.println("User: " + user);
                System.out.printf("%s %s has played %d games%n",
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            } else {
                System.out.println("No such user exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (prstmt != null)
                prstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}