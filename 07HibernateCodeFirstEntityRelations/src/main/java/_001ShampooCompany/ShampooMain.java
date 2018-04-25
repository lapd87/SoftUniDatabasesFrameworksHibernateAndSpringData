package _001ShampooCompany;

import _001ShampooCompany.Ingredients.AmmoniumChloride;
import _001ShampooCompany.Ingredients.BasicIngredient;
import _001ShampooCompany.Ingredients.Mint;
import _001ShampooCompany.Ingredients.Nettle;
import _001ShampooCompany.Shampoo.BasicLabel;
import _001ShampooCompany.Shampoo.BasicShampoo;
import _001ShampooCompany.ShampooTypes.FiftyShades;
import _001ShampooCompany.ShampooTypes.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.3.2018 г.
 * Time: 20:58 ч.
 */
public class ShampooMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("CodeFirst");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel label = new BasicLabel("Fresh Nuke Shampoo",
                "Contains mint and nettle");

        BasicShampoo freshNukeShampoo = new FreshNuke(label);

        freshNukeShampoo.getIngredients().add(mint);
        freshNukeShampoo.getIngredients().add(nettle);
        freshNukeShampoo.getIngredients().add(am);

        em.persist(freshNukeShampoo);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}