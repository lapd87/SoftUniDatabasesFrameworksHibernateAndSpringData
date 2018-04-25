package _05BillsPaymentSystem;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 19:35 ч.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {

    private int number;
    private int owner;


    public BillingDetail() {
    }

    public BillingDetail(int number, int owner_id) {
        this.number = number;
        this.owner = owner_id;
    }

    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


   @ManyToOne(targetEntity = User.class)
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}