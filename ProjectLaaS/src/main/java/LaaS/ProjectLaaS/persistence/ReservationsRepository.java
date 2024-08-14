package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.LearningPaths;
import LaaS.ProjectLaaS.model.Reservations;

@Component
public interface ReservationsRepository extends CrudRepository <Reservations, Long>{
	
}