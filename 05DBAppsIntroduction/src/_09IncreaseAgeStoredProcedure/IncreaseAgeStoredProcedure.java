package _09IncreaseAgeStoredProcedure;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 21.3.2018 г.
 * Time: 15:17 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import static Connector.Connector.getConnection;
import static Connector.Connector.initMySQLLocalConnection;

public class IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Connection conn = null;
        PreparedStatement prstmt = null;
        CallableStatement clstmt = null;
        ResultSet rs = null;

        initMySQLLocalConnection("MinionsDB");

        conn = getConnection();

        int minionID = Integer.parseInt(reader.readLine());

        String dropProcedureIfAny = "DROP PROCEDURE" +
                " IF EXISTS `usp_get_older`;\n";

        prstmt = conn.prepareStatement(dropProcedureIfAny);

        prstmt.executeUpdate();

        String createProcedure = "CREATE PROCEDURE" +
                "`usp_get_older`(IN `minionID` INT)\n" +
                "BEGIN\n" +
                "UPDATE `minions`\n" +
                "SET `age` = `age` + 1\n" +
                "WHERE\n" +
                "    `id` = `minionID`;\n" +
                "END;";

        prstmt = conn.prepareStatement(createProcedure);

        prstmt.executeUpdate();

        String callProcedure = "CALL `usp_get_older`(?);";

        clstmt = conn.prepareCall(callProcedure);
        clstmt.setInt(1, minionID);

        clstmt.executeUpdate();

        String printMinion = "SELECT \n" +
                "    `name`, `age`\n" +
                "FROM\n" +
                "    `minions`\n" +
                "WHERE\n" +
                "    `id` = ?;";

        prstmt = conn.prepareStatement(printMinion);
        prstmt.setInt(1, minionID);

        rs = prstmt.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getString(1)
                    + " " + rs.getInt(2));
        } else {
            System.out.println("No minion with ID: " + minionID);
        }

        rs.close();
        prstmt.close();
        clstmt.close();
        conn.close();
    }
}