package _05EmployeesFromDepartment;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:08 ч.
 */


public class EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> rdEmployees = em
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = 'Research and Development'" +
                        "ORDER BY e.salary, e.id")
                .getResultList();

        for (Employee rdEmployee : rdEmployees) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    rdEmployee.getFirstName(),
                    rdEmployee.getLastName(),
                    rdEmployee.getDepartment().getName(),
                    rdEmployee.getSalary());
        }

        em.close();
        emf.close();
    }
}