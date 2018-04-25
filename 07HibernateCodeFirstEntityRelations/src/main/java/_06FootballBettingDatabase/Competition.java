package _06FootballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:36 ч.
 */

@Entity
@Table(name = "competitions")
public class Competition extends Nameable {

    private CompetitionType type;
    private Set<Game> games;

    @ManyToOne
    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "competition")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}