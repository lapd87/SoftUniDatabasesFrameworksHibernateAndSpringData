package _03ContainsEmployee;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:06 ч.
 */

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Enter employee name: ");
        String[] employeeName = reader.readLine().split("\\s+");

        try {
            Employee foundEmployee = em
                    .createQuery("SELECT e FROM Employee e " +
                                    "WHERE e.firstName = :firstName " +
                                    "AND e.lastName =:lastName",
                            Employee.class)
                    .setParameter("firstName", employeeName[0])
                    .setParameter("lastName", employeeName[1])
                    .getSingleResult();

            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }
        finally {
            em.close();
            emf.close();
        }
    }
}