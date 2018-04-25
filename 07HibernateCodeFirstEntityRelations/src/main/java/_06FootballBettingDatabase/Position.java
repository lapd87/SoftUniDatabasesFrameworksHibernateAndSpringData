package _06FootballBettingDatabase;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:28 ч.
 */

@Entity
@Table(name = "positions")
public class Position {

    private String id;
    private String description;
    private Set<Player> players;


    public Position() {
    }




    @Id
    @Column(length = 2)
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "position")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}