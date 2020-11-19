package dbtest.demo.repo;

import dbtest.demo.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo  extends CrudRepository<Course,Integer> {

}
