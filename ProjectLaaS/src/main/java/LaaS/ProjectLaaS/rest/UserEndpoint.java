package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.User;
import LaaS.ProjectLaaS.persistence.UserService;

@RestController
public class UserEndpoint {
	@Autowired
	UserService us;
	
	@GetMapping("/users")
	public Iterable<User> alleUsers(){
		return us.geefAlleUsers();
	}

}
