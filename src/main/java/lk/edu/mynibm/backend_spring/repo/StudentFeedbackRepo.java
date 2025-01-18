package lk.edu.mynibm.backend_spring.repo;

import lk.edu.mynibm.backend_spring.model.StudentFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFeedbackRepo extends JpaRepository<StudentFeedback, Integer> {
    List<StudentFeedback> findByTeacherID(Integer teacherID);
}
