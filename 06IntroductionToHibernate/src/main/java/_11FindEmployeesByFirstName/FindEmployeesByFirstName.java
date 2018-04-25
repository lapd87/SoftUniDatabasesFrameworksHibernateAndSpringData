package _11FindEmployeesByFirstName;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:11 ч.
 */

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeesByFirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Enter employee first name pattern: ");
        String pattern = reader.readLine() + "%";

        em.createQuery("SELECT e FROM Employee e " +
                "WHERE e.firstName LIKE(:pattern)", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .stream()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));

        em.close();
        emf.close();
    }
}