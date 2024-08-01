package LaaS.ProjectLaaS.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.Trainer;

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

	  public boolean authenticate(Long userId, String password) {
	        Trainee trainee = traineer.findByUserId(userId)
	                .orElseThrow(() -> new RuntimeException("Trainee not found"));
	        
	        if (trainee != null) {
	            return trainee.getPasswordHash().equals(password);
	        }
	        
	        return false;
	    }
}
