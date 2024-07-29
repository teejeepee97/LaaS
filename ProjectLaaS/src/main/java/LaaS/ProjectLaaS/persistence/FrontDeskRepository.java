package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.FrontDesk;

@Component
public interface FrontDeskRepository extends CrudRepository <FrontDesk, Long>{

}
