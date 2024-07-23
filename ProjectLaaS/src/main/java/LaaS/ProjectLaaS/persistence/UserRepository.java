package LaaS.ProjectLaaS.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.User;

@Component
public interface UserRepository extends CrudRepository<User,Long>{

}
