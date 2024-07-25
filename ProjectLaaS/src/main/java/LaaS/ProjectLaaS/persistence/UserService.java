package LaaS.ProjectLaaS.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.Trainee;

@Service
public class UserService {
	
	@Autowired
	private TraineeRepository traineer;
	
	@Autowired
	private TrainerRepository trainerr;
	
//	Not Final code
	public void slaEenUserOp(Trainee trainee) {
		traineer.save(trainee);
		
	}

}
