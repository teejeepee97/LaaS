package LaaS.ProjectLaaS.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Trainer extends User{

	
	@ManyToMany
	private List <LearningPaths> LearningPathsTrainer = new ArrayList();

	
}
