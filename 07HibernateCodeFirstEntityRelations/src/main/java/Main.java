
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 18:38 ч.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        //for each task right click on directory
        //under 'mark directory as'
        //select to exclude/include to change task


        //drop database if exists
        Connection conn = null;
        PreparedStatement prstmt = null;

        Connector.initMySQLLocalConnection("");

        conn = Connector.getConnection();

        String workbench = "DROP DATABASE IF EXISTS `hdb_code_first`;";

        prstmt = conn.prepareStatement(workbench);
        prstmt.executeUpdate();

        prstmt.close();
        conn.close();


        //create database using code first approach
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("CodeFirst");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}