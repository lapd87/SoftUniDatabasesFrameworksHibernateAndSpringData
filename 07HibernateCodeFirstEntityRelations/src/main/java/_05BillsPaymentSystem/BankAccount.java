package _05BillsPaymentSystem;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 19:48 ч.
 */

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail {

    private String bankName;
    private String SWIFTcode;

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "SWIFT_code")
    public String getSWIFTcode() {
        return SWIFTcode;
    }

    public void setSWIFTcode(String SWIFTcode) {
        this.SWIFTcode = SWIFTcode;
    }



}