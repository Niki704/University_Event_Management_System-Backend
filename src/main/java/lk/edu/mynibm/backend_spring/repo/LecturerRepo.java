package lk.edu.mynibm.backend_spring.repo;

import lk.edu.mynibm.backend_spring.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Integer> {
}
