package _06FootballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:22 ч.
 */

@Entity
@Table(name = "continents")
public class Continent extends Nameable {

    private Set<Country> countries;


    @OneToMany(mappedBy = "continent")
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}