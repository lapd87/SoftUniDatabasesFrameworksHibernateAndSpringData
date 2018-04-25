package _04HospitalDatabase;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 15:17 ч.
 */

@Entity
@Table(name = "patients")
public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Date dateOfBirth;
    private byte[] picture;
    private boolean hasMedicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicine> prescribedMedicines;


    public Patient() {
    }

    public Patient(int id, String firstName, String lastName,
                   String address, String email,
                   Date dateOfBirth, byte[] picture,
                   boolean hasMedicalInsurance,
                   Set<Visitation> visitations,
                   Set<Diagnose> diagnoses,
                   Set<Medicine> prescribedMedicines) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.visitations = visitations;
        this.diagnoses = diagnoses;
        this.prescribedMedicines = prescribedMedicines;
    }

    public Patient(String firstName, String lastName,
                   String address, String email,
                   Date dob, byte[] picture,
                   boolean hasMedicalInsurance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.picture = picture;
        this.hasMedicalInsurance = hasMedicalInsurance;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "picture")
    @Lob
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "medical_insurance", nullable = false)
    public boolean hasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    @OneToMany(mappedBy = "patient",
            targetEntity = Visitation.class)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany(targetEntity = Diagnose.class)
    @JoinTable(name = "patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id",
                    referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "FK_patients_diagnoses_patient"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id",
                    referencedColumnName = "id"),
            inverseForeignKey = @ForeignKey(name = "FK_patients_diagnoses_diagnose"))
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany(targetEntity = Medicine.class)
    @JoinTable(name = "patients_medicines",
            joinColumns = @JoinColumn(name = "patient_id",
                    referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "FK_patients_medicines_patient"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id",
                    referencedColumnName = "id"),
            inverseForeignKey = @ForeignKey(name = "FK_patients_medicines_medicine"))
    public Set<Medicine> getPrescribedMedicines() {
        return prescribedMedicines;
    }

    public void setPrescribedMedicines(Set<Medicine> prescribedMedicines) {
        this.prescribedMedicines = prescribedMedicines;
    }
}