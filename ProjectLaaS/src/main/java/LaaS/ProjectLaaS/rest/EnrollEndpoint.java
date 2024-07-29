package LaaS.ProjectLaaS.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.LearningPaths;
import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.User;
import LaaS.ProjectLaaS.persistence.EnrollService;


@RestController
public class EnrollEndpoint {

	@Autowired
	EnrollService enrolls;
	
//	@GetMapping("/EnrollmentTrainee")
//	public void slaLearningPathOp() {
//		enrolls.slaEnrollmentOp(userId, learningPathId );
//		
//	}
	
	
	
	

}