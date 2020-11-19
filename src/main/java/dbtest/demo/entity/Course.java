package dbtest.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
@Data
public class Course {

    @Id
  String  courseId;

    String courseName;

    @ManyToMany(mappedBy = "courses")
    List<Student> students;
}
