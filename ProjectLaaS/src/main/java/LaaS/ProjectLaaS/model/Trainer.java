package LaaS.ProjectLaaS.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Trainer extends User{

	
//	@ManyToMany
//	private List <LearningPaths> LearningPathsTrainer = new ArrayList();
	
	@OneToMany
	private List<Reservations> reservation;
	
}
