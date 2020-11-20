package dbtest.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

// ORM - object re
@Entity
@Table(name ="STUDENTS")
@Data
public class Student {

    @Id
    Integer studentId; // -> STUDENT_ID

    String firstName;

    String lastName;

    @ManyToMany(fetch =FetchType.EAGER )
    @JoinTable(name = "Enrolment",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses;

//    public Student(Integer studentId, String firstName, String lastName) {
//        this.studentId = studentId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.courses = courses;
//    }
}
