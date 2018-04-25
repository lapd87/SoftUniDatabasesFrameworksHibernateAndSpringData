package _06FootballBettingDatabase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 21:18 ч.
 */

@Entity
@Table(name = "bets")
public class Bet {

    private int id;
    private BigDecimal betMoney;
    private Date dateTimeOfBet;
    private User user;


    public Bet() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_and_time_of_bet")
    public Date getDateTimeOfBet() {
        return dateTimeOfBet;
    }

    public void setDateTimeOfBet(Date dateTimeOfBet) {
        this.dateTimeOfBet = dateTimeOfBet;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}