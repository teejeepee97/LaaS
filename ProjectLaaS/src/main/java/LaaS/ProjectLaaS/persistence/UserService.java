package LaaS.ProjectLaaS.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	public Iterable<User> geefAlleUsers() {
		return ur.findAll();
	}

	public void slaUserOp(User user) {
		ur.save(user);
	}
	
	public void verwijderUser(long userId) {
		ur.deleteById(userId);
	}

}
