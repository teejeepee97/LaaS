package LaaS.ProjectLaaS.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Trainee extends User{
	
	private String learningPathEnrollment;
	
	@ManyToMany
	private List <LearningPaths> LearningPathsTrainee = new ArrayList();		
	
	
	public String getLearningPathEnrollment() {
		return learningPathEnrollment;
	}
	public void setLearningPathEnrollment(String learningPathEnrollment) {
		this.learningPathEnrollment = learningPathEnrollment;
	}
	

	
	
}
