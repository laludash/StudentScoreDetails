package studentrestapi.studentrepo;

import org.springframework.data.repository.CrudRepository;

import studentrestapi.stduententity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
