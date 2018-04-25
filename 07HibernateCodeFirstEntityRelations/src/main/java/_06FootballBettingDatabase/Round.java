package _06FootballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:39 ч.
 */

@Entity
@Table(name = "rounds")
public class Round extends Nameable {

    private Set<Game> games;


    @OneToMany(mappedBy = "round")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}