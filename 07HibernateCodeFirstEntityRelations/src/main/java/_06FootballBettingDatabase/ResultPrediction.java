package _06FootballBettingDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 21:18 ч.
 */
@Entity
@Table(name = "result_prediction")
public class ResultPrediction {

    private int id;
    private Prediction prediction;

    private Set<BetGame> betGames;


    public ResultPrediction() {
        this.betGames = new HashSet<>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }


    @OneToMany
    public Set<BetGame> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGame> betGames) {
        this.betGames = betGames;
    }
}