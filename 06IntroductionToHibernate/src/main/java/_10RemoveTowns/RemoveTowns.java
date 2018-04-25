package _10RemoveTowns;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:10 ч.
 */

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        System.out.printf("Enter name of town to delete: ");
        String deleteTown = reader.readLine();

        List<Address> deleteAddresses = em
                .createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.name = :name", Address.class)
                .setParameter("name", deleteTown)
                .getResultList();

        int deleteAddressesCount = deleteAddresses.size();

        em.getTransaction().begin();

        deleteAddresses.stream()
                .forEach(a -> a.setTown(null));

        em.createQuery("DELETE FROM Town t " +
                "WHERE t.name = :name")
                .setParameter("name", deleteTown)
                .executeUpdate();

        em.getTransaction().commit();

        System.out.printf("%d address in %s deleted%n",
                deleteAddressesCount,
                deleteTown);

        em.close();
        emf.close();
    }
}