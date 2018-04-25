package _07PrintAllMinionNames;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.3.2018 г.
 * Time: 21:50 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Connector.Connector.getConnection;
import static Connector.Connector.initMySQLLocalConnection;

import static Connector.Connector.initMySQLLocalConnection;
import static Connector.Connector.getConnection;

public class PrintAllMinionNames {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection conn = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        String workbench = "SELECT \n" +
                "    `name`\n" +
                "FROM\n" +
                "    `minions`;";

        prstmt = conn.prepareStatement(workbench);

        rs = prstmt.executeQuery();

        List<String> minionNames = new ArrayList<>();

        while (rs.next()) {
            minionNames.add(rs.getString(1));
        }

        for (int i = 0; i < minionNames.size() - i; i++) {
            System.out.println(minionNames.get(i));

            if (i != minionNames.size() - i - 1)
                System.out.println(minionNames.get(minionNames.size() - i - 1));
        }

        rs.close();
        prstmt.close();
        conn.close();
    }
}