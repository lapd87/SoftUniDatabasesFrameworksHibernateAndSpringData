package _09IncreaseSalaries;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:10 ч.
 */

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> filteredEmployees = em.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name " +
                "IN('Engineering', " +
                "'Tool Design', " +
                "'Marketing', " +
                "'Information Services')", Employee.class)
                .getResultList();

        em.getTransaction().begin();

        for (Employee currentEmployee : filteredEmployees) {
            currentEmployee
                    .setSalary(currentEmployee
                            .getSalary()
                            .multiply(BigDecimal
                                    .valueOf(1.12)));

            System.out.printf("%s %s %s ($%.2f)%n",
                    currentEmployee.getFirstName(),
                    currentEmployee.getLastName(),
                    currentEmployee.getDepartment().getName(),
                    currentEmployee.getSalary());
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}