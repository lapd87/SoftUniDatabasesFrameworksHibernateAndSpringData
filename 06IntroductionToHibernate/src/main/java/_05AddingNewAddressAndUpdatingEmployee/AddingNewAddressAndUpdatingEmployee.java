package _05AddingNewAddressAndUpdatingEmployee;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 23.3.2018 г.
 * Time: 10:08 ч.
 */

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Town sofia = em
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name='Sofia'", Town.class)
                .getSingleResult();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        newAddress.setTown(sofia);

        System.out.printf("Enter employee last name: ");
        String employeeLastName = reader.readLine();

        Employee setAddressEmployee = em
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :lastName", Employee.class)
                .setParameter("lastName", employeeLastName)
                .getSingleResult();

        em.getTransaction().begin();

        em.persist(newAddress);
        setAddressEmployee.setAddress(newAddress);

        em.getTransaction().commit();

        System.out.printf("Changed %s %s address.%n",
                setAddressEmployee.getFirstName(),
                setAddressEmployee.getLastName());

        em.close();
        emf.close();
    }
}