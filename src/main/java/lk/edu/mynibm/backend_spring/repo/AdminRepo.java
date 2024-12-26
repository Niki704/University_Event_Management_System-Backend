package lk.edu.mynibm.backend_spring.repo;

import lk.edu.mynibm.backend_spring.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
