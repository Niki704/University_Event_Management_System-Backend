package lk.edu.mynibm.backend_spring.repo;

import lk.edu.mynibm.backend_spring.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch, String> {
}
