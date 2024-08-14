package LaaS.ProjectLaaS.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.PasswordHasher;
import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.Trainer;
import LaaS.ProjectLaaS.model.User;

@Service
public class InlogService {
	
	@Autowired
	private TraineeRepository traineer;
	
	@Autowired
	private TrainerRepository trainerr;
	
//	Not Final code
	
	public Iterable<Trainee> geefAlleTrainees() {
		return traineer.findAll();
		
	}
	
	public Iterable<Trainer> geefAlleTrainers() {
		return trainerr.findAll();
		
	}

	public User authenticate(String username, String password) {
	    // Try to find the Trainee first
	    Trainee trainee = traineer.findByName(username).orElse(null);
	    PasswordHasher hasher = new PasswordHasher();
	    String hashed_password = hasher.createHashFromPassword(password);
	    
	    
	    if (trainee != null) {
	        if (trainee.getPasswordHash().equals(hashed_password)) {
	            return trainee; // Return the authenticated Trainee
	        } else {
	            throw new RuntimeException("Incorrect password for Trainee");
	        }
	    }

	    // If no Trainee was found, try to find the Trainer
	    Trainer trainer = trainerr.findByName(username).orElse(null);
	    
	    if (trainer != null) {
	        if (trainer.getPasswordHash().equals(password)) {
	            return trainer; // Return the authenticated Trainer
	        } else {
	            throw new RuntimeException("Incorrect password for Trainer");
	        }
	    }

	    // If neither a Trainee nor Trainer was found
	    throw new RuntimeException("User not found");
	}

}
