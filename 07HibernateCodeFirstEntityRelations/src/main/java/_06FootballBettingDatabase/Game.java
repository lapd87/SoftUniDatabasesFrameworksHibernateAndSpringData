package _06FootballBettingDatabase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 20:40 ч.
 */

@Entity
@Table(name = "games")
public class Game {

    private int id;
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private Date dateTimeOfGame;
    private BigDecimal homeTeamBetRate;
    private BigDecimal awayTeamBetRate;
    private BigDecimal drawTeamBetRate;
    private Round round;
    private Competition competition;



    public Game() {
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_goals")
    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    @Column(name = "away_goals")
    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Column(name = "date_and_time_of_game")
    public Date getDateTimeOfGame() {
        return dateTimeOfGame;
    }

    public void setDateTimeOfGame(Date dateTimeOfGame) {
        this.dateTimeOfGame = dateTimeOfGame;
    }

    @Column(name = "home_team_bet_rate")
    public BigDecimal getHomeTeamBetRate() {
        return homeTeamBetRate;
    }

    public void setHomeTeamBetRate(BigDecimal homeTeamBetRate) {
        this.homeTeamBetRate = homeTeamBetRate;
    }

    @Column(name = "away_team_bet_rate")
    public BigDecimal getAwayTeamBetRate() {
        return awayTeamBetRate;
    }

    public void setAwayTeamBetRate(BigDecimal awayTeamBetRate) {
        this.awayTeamBetRate = awayTeamBetRate;
    }

    @Column(name = "draw_team_bet_rate")
    public BigDecimal getDrawTeamBetRate() {
        return drawTeamBetRate;
    }

    public void setDrawTeamBetRate(BigDecimal drawTeamBetRate) {
        this.drawTeamBetRate = drawTeamBetRate;
    }

    @ManyToOne
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}