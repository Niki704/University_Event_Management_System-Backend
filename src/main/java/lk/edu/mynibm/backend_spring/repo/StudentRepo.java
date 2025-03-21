package lk.edu.mynibm.backend_spring.repo;

import lk.edu.mynibm.backend_spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query(value ="SELECT * FROM Student WHERE id = ?1", nativeQuery = true)
    Student findStudentById(int Id);
}
