package _04EmployeesWithSalaryOver50000;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:07 ч.
 */

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> salaryOverEmployees = em
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary>50000", Employee.class)
                .getResultList();

        for (Employee e : salaryOverEmployees) {
            System.out.println(e.getFirstName());
        }

        em.close();
        emf.close();
    }
}