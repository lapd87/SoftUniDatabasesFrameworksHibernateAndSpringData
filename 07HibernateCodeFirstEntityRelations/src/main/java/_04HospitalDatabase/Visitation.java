package _04HospitalDatabase;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 15:24 ч.
 */

@Entity
@Table(name = "visitations")
public class Visitation {

    private int id;
    private Date date;
    private String comments;
    private Patient patient;


    public Visitation() {
    }

    public Visitation(int id, Date date, String comments,
                      Patient patient) {
        this.id = id;
        this.date = date;
        this.comments = comments;
        this.patient = patient;
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_visitation_patient"))
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}