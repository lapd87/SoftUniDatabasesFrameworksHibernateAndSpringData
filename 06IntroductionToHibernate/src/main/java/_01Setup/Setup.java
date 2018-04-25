package _01Setup; /**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 09:17 ч.
 */

import org.apache.commons.io.FileUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static _01Setup.Connector.getConnection;
import static _01Setup.Connector.initMySQLLocalConnection;


public class Setup {
    public static void main(String[] args) throws IOException, SQLException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();

        System.out.println("Successful creation of soft_uni database.");

//        Connection conn = null;
//        PreparedStatement prstmt = null;
//
//        initMySQLLocalConnection("soft_uni");
//
//        conn = getConnection();
//
//        String sql = FileUtils
//                .readFileToString(new File("src/main/java/_01Setup/softuni_database.sql"));
//
//        prstmt = conn.prepareStatement(sql);
//
//        prstmt.executeUpdate();
//
//        prstmt.close();
//        conn.close();
    }
}