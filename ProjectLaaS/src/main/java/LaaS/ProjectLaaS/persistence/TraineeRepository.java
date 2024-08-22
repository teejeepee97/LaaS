package LaaS.ProjectLaaS.persistence;

import LaaS.ProjectLaaS.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    Optional<Trainee> findByUserId(Long userId);
    Optional<Trainee> findByName(String name);
    
}
