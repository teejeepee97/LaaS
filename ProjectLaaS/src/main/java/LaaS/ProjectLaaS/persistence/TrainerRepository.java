package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.Trainer;

@Component
public interface TrainerRepository extends CrudRepository <Trainer, Long>{

}
