package _001AccessingDatabaseViaSimpleJavaApplicationDemo;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 19.3.2018 г.
 * Time: 19:53 ч.
 */

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AccessingDatabaseViaSimpleJavaApplicationDemo {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "1234");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://" +
                        "localhost:3306/soft_uni", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM " +
                        "employees WHERE salary > ?");
        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name")
                    + " " + rs.getString("last_name"));
        }
    }
}