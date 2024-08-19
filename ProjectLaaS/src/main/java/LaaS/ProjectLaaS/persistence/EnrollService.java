package LaaS.ProjectLaaS.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.LearningPaths;
import LaaS.ProjectLaaS.model.Trainee;

@Service
public class EnrollService {
	
	@Autowired
	private TraineeRepository traineer;
	
	@Autowired
	private LearningPathsRepository learningpathsr;
	
	
}
