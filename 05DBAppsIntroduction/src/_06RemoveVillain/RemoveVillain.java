package _06RemoveVillain;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.3.2018 г.
 * Time: 21:22 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Connector.Connector.initMySQLLocalConnection;
import static Connector.Connector.getConnection;

public class RemoveVillain {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        boolean rollback = true;

        try {
            initMySQLLocalConnection("MinionsDB");

            conn = getConnection();

            String workbench = "SELECT \n" +
                    "    `name`\n" +
                    "FROM\n" +
                    "    `villains`\n" +
                    "WHERE\n" +
                    "    `id` = ?;";

            int villainID = Integer.parseInt(reader.readLine());

            prstmt = conn.prepareStatement(workbench);
            prstmt.setInt(1, villainID);

            rs = prstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("No such villain was found");
                return;
            }

            String villainName = rs.getString(1);

            workbench = "SELECT \n" +
                    "    COUNT(`minion_id`)\n" +
                    "FROM\n" +
                    "    `villains_minions`\n" +
                    "WHERE\n" +
                    "    `villain_id` = ?;";

            prstmt = conn.prepareStatement(workbench);
            prstmt.setInt(1, villainID);

            rs = prstmt.executeQuery();

            rs.next();
            int minionsReleased = rs.getInt(1);

            workbench = "SET foreign_key_checks = 0;\n" +
                    "\n" +
                    "DELETE `v` , `vm` \n" +
                    "FROM `villains` AS `v`\n" +
                    "        JOIN\n" +
                    "    `villains_minions` AS `vm` \n" +
                    "    ON `v`.`id` = `vm`.`villain_id` \n" +
                    "WHERE\n" +
                    "    `v`.`id` = ?;    \n" +
                    "    \n" +
                    "SET foreign_key_checks = 0;\n";

            prstmt = conn.prepareStatement(workbench);
            prstmt.setInt(1, villainID);
            prstmt.executeUpdate();

            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released", minionsReleased);

        } catch (SQLException e) {
            if (rollback)
                conn.rollback();
            e.printStackTrace();
        } finally {
            rs.close();
            prstmt.close();
            conn.close();
        }
    }
}