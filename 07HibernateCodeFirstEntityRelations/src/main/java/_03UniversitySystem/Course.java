package _03UniversitySystem;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.3.2018 г.
 * Time: 13:26 ч.
 */

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int credits;
    private Set<Student> students;
    private Teacher teacher;


    public Course() {
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @ManyToMany(targetEntity = Student.class)
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "course_id",
                    referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "FK_courses_students_course"),
            inverseJoinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "id"),
            inverseForeignKey = @ForeignKey(name = "FK_courses_students_student"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_course_teacher"))
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}