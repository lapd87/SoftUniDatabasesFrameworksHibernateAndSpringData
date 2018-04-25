package _06FootballBettingDatabase;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 21:18 ч.
 */

@Entity
@Table(name = "bets_games")
public class BetGame implements Serializable {

    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;


    public BetGame() {
    }




    @Id
    @ManyToOne
    public Game getGame() {
        return game;
    }


    public void setGame(Game game) {
        this.game = game;
    }

    @Id
    @ManyToOne
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @ManyToOne
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}