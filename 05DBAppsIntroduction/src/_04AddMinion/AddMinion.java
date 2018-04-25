package _04AddMinion;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.3.2018 г.
 * Time: 15:16 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static Connector.Connector.initMySQLLocalConnection;
import static Connector.Connector.getConnection;

public class AddMinion {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        boolean rollback = true;

        try {
            initMySQLLocalConnection("MinionsDB");

            conn = getConnection();

            conn.setAutoCommit(false);

            String[] minion = reader.readLine().split("\\s+");

            String minionName = minion[1];
            int minionAge = Integer.parseInt(minion[2]);
            String minionTown = minion[3];

            String villainName = reader.readLine().split("\\s+")[1];

            String checkTownExists = "SELECT \n" +
                    "    *\n" +
                    "FROM\n" +
                    "    `towns`\n" +
                    "WHERE\n" +
                    "    `name` = ?;";

            prstmt = conn.prepareStatement(checkTownExists);
            prstmt.setString(1, minionTown);

            rs = prstmt.executeQuery();

            if (!rs.isBeforeFirst()) {

                String addTownIfNone = "INSERT INTO `towns` (`name`,`country_id`)\n" +
                        " VALUES (?, 1);";

                prstmt = conn.prepareStatement(addTownIfNone);
                prstmt.setString(1, minionTown);

                prstmt.executeUpdate();

                System.out.printf("Town %s was added to the database.%n",
                        minionTown);
            }

            String getTownId = "SELECT \n" +
                    "    `id`\n" +
                    "FROM\n" +
                    "    `towns`\n" +
                    "WHERE\n" +
                    "    `name` = ?";

            prstmt = conn.prepareStatement(getTownId);
            prstmt.setString(1, minionTown);

            rs = prstmt.executeQuery();

            rs.next();
            int townId = rs.getInt(1);

            String addMinion = "INSERT INTO `minions` (`name`,`age`, `town_id`)\n" +
                    " VALUES (?, ?, ?);";

            prstmt = conn.prepareStatement(addMinion);
            prstmt.setString(1, minionName);
            prstmt.setInt(2, minionAge);
            prstmt.setInt(3, townId);

            prstmt.executeUpdate();

            String getMinionId = "SELECT \n" +
                    "    `id`\n" +
                    "FROM\n" +
                    "    `minions`\n" +
                    "WHERE\n" +
                    "    `name` = ?" +
                    "ORDER BY `id` DESC;";

            prstmt = conn.prepareStatement(getMinionId);
            prstmt.setString(1, minionName);

            rs = prstmt.executeQuery();

            rs.next();
            int minionId = rs.getInt(1);

            String checkVillainExists = "SELECT \n" +
                    "    *\n" +
                    "FROM\n" +
                    "    `villains`\n" +
                    "WHERE\n" +
                    "    `name` = ?;";

            prstmt = conn.prepareStatement(checkVillainExists);
            prstmt.setString(1, villainName);

            rs = prstmt.executeQuery();

            if (!rs.isBeforeFirst()) {

                String addVillainIfNone = "INSERT INTO `villains` (`name`,`evilness_factor`)\n" +
                        "VALUES (?, 3);";

                prstmt = conn.prepareStatement(addVillainIfNone);
                prstmt.setString(1, villainName);
                prstmt.executeUpdate();

                System.out.printf("Villain %s was added to the database.%n",
                        villainName);
            }

            String getVillainId = "SELECT \n" +
                    "    `id`\n" +
                    "FROM\n" +
                    "    `villains`\n" +
                    "WHERE\n" +
                    "    `name` = ?;";

            prstmt = conn.prepareStatement(getVillainId);
            prstmt.setString(1, villainName);

            rs = prstmt.executeQuery();

            rs.next();
            int villainId = rs.getInt(1);

            String setMinionVillain = "INSERT INTO `villains_minions`\n" +
                    "VALUES (?, ?);";

            prstmt = conn.prepareStatement(setMinionVillain);
            prstmt.setInt(1, villainId);
            prstmt.setInt(2, minionId);

            prstmt.executeUpdate();
            conn.commit();
            rollback = false;

            System.out.printf("Successfully added %s to be minion of %s.%n",
                    minionName, villainName);

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