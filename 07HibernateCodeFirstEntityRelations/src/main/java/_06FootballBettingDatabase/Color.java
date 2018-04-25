package _06FootballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:19 ч.
 */
@Entity
@Table(name = "colors")
public class Color extends Nameable {

    private Set<Team> primaryTeams;
    private Set<Team> secondaryTeams;



    public Color() {
        this.primaryTeams = new HashSet<>();
        this.secondaryTeams = new HashSet<>();
    }


    @OneToMany
    public Set<Team> getPrimaryTeams() {
        return primaryTeams;
    }

    public void setPrimaryTeams(Set<Team> primaryTeams) {
        this.primaryTeams = primaryTeams;
    }

    @OneToMany
    public Set<Team> getSecondaryTeams() {
        return secondaryTeams;
    }

    public void setSecondaryTeams(Set<Team> secondaryTeams) {
        this.secondaryTeams = secondaryTeams;
    }
}