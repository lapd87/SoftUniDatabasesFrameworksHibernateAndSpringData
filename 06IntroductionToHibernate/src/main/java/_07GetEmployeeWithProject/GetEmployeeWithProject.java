package _07GetEmployeeWithProject;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:09 ч.
 */

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class GetEmployeeWithProject {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Enter employee ID: ");
        int employeeID = Integer.parseInt(reader.readLine());

        Employee foundEmployee = em
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.id = :employeeID", Employee.class)
                .setParameter("employeeID", employeeID)
                .getSingleResult();

        TreeSet<String> foundEmployeeProjects = new TreeSet<>();

        foundEmployee
                .getProjects()
                .stream()
                .forEach(project -> foundEmployeeProjects
                        .add(project.getName()));

        System.out.printf("%s %s - %s%n",
                foundEmployee.getFirstName(),
                foundEmployee.getLastName(),
                foundEmployee.getJobTitle());

        for (String project : foundEmployeeProjects) {
            System.out.printf("\t%s%n", project);
        }

        em.close();
        emf.close();
    }
}