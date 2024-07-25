package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.LearningPaths;

@Component
public interface LearningPathsRepository extends CrudRepository <LearningPaths, Long>{

}
