package _12EmployeesMaximumSalaries;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:11 ч.
 */


public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT e FROM Employee e " +
                "WHERE e.salary < 30000 OR e.salary > 70000 " +
                "GROUP BY e.department.id " +
                "ORDER BY e.salary DESC", Employee.class)
                .getResultList()
                .stream()
                .sorted(Comparator
                        .comparing(e -> e
                                .getDepartment()
                                .getId()))
                .forEach(e -> System.out.printf("%s - %.2f%n",
                        e.getDepartment().getName(),
                        e.getSalary()));

        em.close();
        emf.close();
    }
}