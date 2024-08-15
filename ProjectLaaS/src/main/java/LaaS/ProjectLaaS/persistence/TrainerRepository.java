package LaaS.ProjectLaaS.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.Trainer;

@Component
public interface TrainerRepository extends CrudRepository <Trainer, Long>{
	Optional<Trainer> findByUserId(long userId);
	Optional<Trainer> findByName(String name);
	
		

}
