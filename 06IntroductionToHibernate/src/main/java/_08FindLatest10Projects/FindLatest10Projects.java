package _08FindLatest10Projects;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:10 ч.
 */


public class FindLatest10Projects {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Project> lastProjects = em.
                createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toList());

        for (Project currentProject : lastProjects) {
            System.out.printf("Project name: %s%n",
                    currentProject.getName());
            System.out.printf("\tProject Description: %s%n",
                    currentProject.getDescription());
            System.out.printf("\tProject Start Date:%s%n",
                    currentProject.getStartDate());
            System.out.printf("\tProject End Date: %s%n",
                    currentProject.getEndDate());
        }

        em.close();
        emf.close();
    }
}