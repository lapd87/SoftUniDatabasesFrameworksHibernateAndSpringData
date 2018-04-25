package _08IncreaseMinionsAge;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 21.3.2018 г.
 * Time: 09:17 ч.
 */

import org.apache.commons.lang3.text.WordUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Connector.Connector.getConnection;
import static Connector.Connector.initMySQLLocalConnection;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        String[] input = reader.readLine().split("\\s+");

        List<String> minionIDs = new ArrayList<>(Arrays.asList(input));
        minionIDs.removeAll(Arrays.asList("", null));

        String changeAge = "UPDATE `minions` \n" +
                "SET \n" +
                "    `age` = `age` + 1\n" +
                "WHERE\n" +
                "    `id` IN (?);";

        changeAge = changeAge
                .replace("?", String.join(", ", minionIDs));

        prstmt = conn.prepareStatement(changeAge);

        prstmt.executeUpdate();

        String getMinionName = "SELECT \n" +
                "    `name`\n" +
                "FROM\n" +
                "    `minions`\n" +
                "WHERE\n" +
                "    `id` IN (?);";

        getMinionName = getMinionName
                .replace("?", String.join(", ", minionIDs));

        prstmt = conn.prepareStatement(getMinionName);

        rs = prstmt.executeQuery();

        List<String> minionsNewName = new ArrayList<>();

        while (rs.next()) {

            String newName = WordUtils
                    .capitalizeFully(rs.getString(1), ' ');

            minionsNewName.add(newName);
        }

        for (int i = 0; i < minionIDs.size(); i++) {

            String changeNameCase = "UPDATE `minions` \n" +
                    "SET \n" +
                    "    `name` = ?\n" +
                    "WHERE\n" +
                    "    `id` = ?;";

            prstmt = conn.prepareStatement(changeNameCase);
            prstmt.setString(1, minionsNewName.get(i));
            prstmt.setString(2, minionIDs.get(i));

            prstmt.executeUpdate();
        }

        String selectAll = "SELECT \n" +
                "    `name`,\n" +
                "    `age`\n" +
                "FROM\n" +
                "    `minions`;";

        prstmt = conn.prepareStatement(selectAll);

        rs = prstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(1)
                    + " " + rs.getInt(2));
        }

        rs.close();
        prstmt.close();
        conn.close();
    }
}