package _02RemoveObjects;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:06 ч.
 */

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RemoveObjects {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Town> towns = em
                .createQuery("SELECT t FROM Town t", Town.class)
                .getResultList();

        List<String> result = new ArrayList<>();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }
        }

        em.getTransaction().begin();

        for (Town town : towns) {
            if (em.contains(town)) {
                town.setName(town.getName().toLowerCase());
                result.add(town.getName());
            }
        }

        em.getTransaction().commit();

        em.close();
        emf.close();

        for (String s : result) {
            System.out.println(s);
        }
    }
}