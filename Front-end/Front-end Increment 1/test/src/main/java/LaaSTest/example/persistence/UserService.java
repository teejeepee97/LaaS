package LaaSTest.example.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import LaaSTest.example.domain.*;

@Component
public class UserService {
	@Autowired // Dependency Injection
	UserRepository ur;
	
	public Iterable<User> userdata() {
		System.out.println("All user data is being retrieved...");
		return ur.findAll();
	}
	
//	public String returnCredentials() {
//		return ur.
//	}
}
