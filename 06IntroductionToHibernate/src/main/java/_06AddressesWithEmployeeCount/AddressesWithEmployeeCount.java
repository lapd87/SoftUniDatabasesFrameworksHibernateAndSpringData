package _06AddressesWithEmployeeCount;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:09 ч.
 */


public class AddressesWithEmployeeCount {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Address> fileredAddresses = em
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY employees.size DESC, a.town.id", Address.class)
                .setMaxResults(10)
                .getResultList();


        for (Address currentAddress : fileredAddresses) {
            System.out.printf("%s, %s - %d employees%n",
                    currentAddress.getText(),
                    currentAddress.getTown().getName(),
                    currentAddress.getEmployees().size());
        }

        em.close();
        emf.close();
    }
}