package _04HospitalDatabase;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 15:28 ч.
 */

@Entity
@Table(name = "medicines")
public class Medicine {

    private int id;
    private String name;
    private Set<Patient> patients;


    public Medicine() {
    }

    public Medicine(int id, String name,
                    Set<Patient> patients) {
        this.id = id;
        this.name = name;
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

    @ManyToMany(mappedBy = "prescribedMedicines",
            targetEntity = Patient.class)
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}