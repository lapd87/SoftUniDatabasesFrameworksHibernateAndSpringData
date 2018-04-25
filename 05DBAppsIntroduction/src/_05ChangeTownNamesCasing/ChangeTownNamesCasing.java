package _05ChangeTownNamesCasing;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.3.2018 г.
 * Time: 20:08 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Connector.Connector.initMySQLLocalConnection;
import static Connector.Connector.getConnection;

public class ChangeTownNamesCasing {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        String workbench = "SELECT \n" +
                "    `t`.`name`\n" +
                "FROM\n" +
                "    `towns` AS `t`\n" +
                "        JOIN\n" +
                "    `countries` AS `c` \n" +
                "    ON `t`.`country_id` = `c`.`id`\n" +
                "WHERE\n" +
                "    `c`.`name` = ?;";

        String country = reader.readLine();

        prstmt = conn.prepareStatement(workbench);
        prstmt.setString(1, country);

        rs = prstmt.executeQuery();

        List<String> changedTowns = new ArrayList<>();

        boolean hasChange = false;

        while (rs.next()
                && !rs.getString(1)
                .equals(rs.getString(1)
                        .toUpperCase())) {

            changedTowns.add(rs.getString(1).toUpperCase());
            hasChange = true;
        }

        workbench = "UPDATE `towns` AS `t`\n" +
                "        JOIN\n" +
                "    `countries` AS `c` ON `t`.`country_id` = `c`.`id` \n" +
                "SET \n" +
                "    `t`.`name` = UPPER(`t`.`name`)\n" +
                "WHERE\n" +
                "    `c`.`name` = ?;";

        prstmt = conn.prepareStatement(workbench);
        prstmt.setString(1, country);

        prstmt.executeUpdate();


        if (hasChange) {
            System.out.printf("%d town names were affected.%n",
                    changedTowns.size());
            System.out.println("["
                    + String.join(", ", changedTowns)
                    + "]");
        } else {
            System.out.println("No town names were affected.");
        }

        rs.close();
        prstmt.close();
        conn.close();
    }
}