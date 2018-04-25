package _03UniversitySystem;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 13:27 ч.
 */

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    private String email;
    private BigDecimal salaryPerHour;
    private Set<Course> toughtCourses;


    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "salary_per_hour")
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher",
            targetEntity = Course.class)
    public Set<Course> getToughtCourses() {
        return toughtCourses;
    }

    public void setToughtCourses(Set<Course> toughtCourses) {
        this.toughtCourses = toughtCourses;
    }
}