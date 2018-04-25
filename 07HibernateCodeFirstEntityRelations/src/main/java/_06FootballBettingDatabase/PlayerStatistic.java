package _06FootballBettingDatabase;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 21:05 ч.
 */

@Entity
@Table(name = "player_statistics")
public class PlayerStatistic implements Serializable {

    private Game game;
    private Player player;
    private int scoredGoals;
    private int playerAssists;
    private int playedMinutesDuringGame;


    public PlayerStatistic() {
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
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public int getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minuted_during_game")
    public int getPlayedMinutesDuringGame() {
        return playedMinutesDuringGame;
    }

    public void setPlayedMinutesDuringGame(int playedMinutesDuringGame) {
        this.playedMinutesDuringGame = playedMinutesDuringGame;
    }
}