package _04HospitalDatabase;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 15:25 ч.
 */

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    private int id;
    private String name;
    private String comments;
    private Set<Patient> patients;


    public Diagnose() {
    }

    public Diagnose(int id, String name, String comments,
                    Set<Patient> patients) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.patients = patients;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToMany(mappedBy = "diagnoses",
            targetEntity = Patient.class)
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}