package _03GetMinionNames;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.3.2018 г.
 * Time: 11:49 ч.
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

public class GetMinionNames {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        String workbench = "SELECT \n" +
                "    `v`.`name`, `m`.`name`, `m`.`age`\n" +
                "FROM\n" +
                "    `villains` AS `v`\n" +
                "        LEFT JOIN\n" +
                "    `villains_minions` AS `vm`\n" +
                "    ON `v`.`id` = `vm`.`villain_id`\n" +
                "        LEFT JOIN\n" +
                "    `minions` AS `m` \n" +
                "    ON `vm`.`minion_id` = `m`.`id`\n" +
                "WHERE\n" +
                "    `v`.`id` = ?;";

        int villainID = Integer.parseInt(reader.readLine());

        prstmt = conn.prepareStatement(workbench);
        prstmt.setInt(1, villainID);

        rs = prstmt.executeQuery();

        rs.last();

        int resultCount = rs.getRow();

        rs.first();

        if (resultCount == 0) {
            System.out.println("No villain with ID "
                    + villainID
                    + " exists in the database.");
        } else {
            System.out.println("Villain: "
                    + rs.getString(1));

            for (int i = 1; i <= resultCount; i++) {
                if (rs.getString(2) != null) {
                    System.out.printf("%d. %s %d%n",
                            i
                            , rs.getString(2),
                            rs.getInt(3));
                } else {
                    System.out.println("<no minions>");
                }

                rs.next();
            }
        }

        rs.close();
        prstmt.close();
        conn.close();
    }
}