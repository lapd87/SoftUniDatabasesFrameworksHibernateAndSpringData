package _02GetVillainsNames;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.3.2018 г.
 * Time: 11:18 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static Connector.Connector.getConnection;
import static Connector.Connector.initMySQLLocalConnection;

public class GetVillainsNames {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        String workbench = "SELECT \n" +
                "    `v`.`name`, \n" +
                "    COUNT(`vm`.`minion_id`) AS `minions_count`\n" +
                "FROM\n" +
                "    `villains` AS `v`\n" +
                "        JOIN\n" +
                "    `villains_minions` AS `vm` \n" +
                "    ON `v`.`id` = `vm`.`villain_id`\n" +
                "GROUP BY `v`.`id`\n" +
                "HAVING `minions_count` > 3\n" +
                "ORDER BY `minions_count` DESC;";

        prstmt = conn.prepareStatement(workbench);
        rs = prstmt.executeQuery();


        while (rs.next()) {
            System.out.printf("%s %d%n",
                    rs.getString(1),
                    rs.getInt(2));
        }

        rs.close();
        prstmt.close();
        conn.close();
    }
}