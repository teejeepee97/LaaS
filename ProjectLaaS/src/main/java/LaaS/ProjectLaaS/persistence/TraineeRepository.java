package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.Trainee;

@Component
public interface TraineeRepository extends CrudRepository <Trainee, Long>{

}
