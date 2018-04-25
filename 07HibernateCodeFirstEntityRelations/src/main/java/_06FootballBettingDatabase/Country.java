package _06FootballBettingDatabase;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:21 ч.
 */
@Entity
@Table(name = "countries")
public class Country {

    private String Id;
    private String name;
    private Continent continent;
    private Set<Town> towns;


    public Country() {
    }



    @Id
    @Column(length = 3)
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @OneToMany
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}