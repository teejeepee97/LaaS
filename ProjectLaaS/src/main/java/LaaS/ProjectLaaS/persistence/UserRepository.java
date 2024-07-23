package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ZondagDemo.demo.model.Schip;

@Component
public interface UserRepository extends CrudRepository <Schip, Long>{

}
