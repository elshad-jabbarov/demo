package dbtest.demo.repo;

import dbtest.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepo extends CrudRepository<Student,Integer> {
         Optional<Student>  findByFirstName(String fs );
}
