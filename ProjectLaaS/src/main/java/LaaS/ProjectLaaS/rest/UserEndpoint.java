package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.User;
import LaaS.ProjectLaaS.persistence.UserService;

@RestController
public class UserEndpoint {
	
	@Autowired
	UserService us;
	
	@GetMapping("/deUsers")
	public Iterable<User> alleUsers(){
		return us.geefAlleUsers();
	}
	
	@PostMapping("/voegUserToe")
	public void voegUserToe(@RequestBody User user) {
		us.slaUserOp(user);	
	}
	
	@DeleteMapping("/verwijderUser/{userId}")
	public void verwijderUser(@PathVariable("userId") int userId) {
		us.verwijderUser(userId);
	}
	
	
}
