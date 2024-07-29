package LaaS.ProjectLaaS.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Trainee extends User{
	
	private String learningPathEnrollment;
	
	@OneToOne
	private LearningPaths LearningPathsTrainee;		
	
	
	public String getLearningPathEnrollment() {
		return learningPathEnrollment;
	}
	public void setLearningPathEnrollment(String learningPathEnrollment) {
		this.learningPathEnrollment = learningPathEnrollment;
	}
	public LearningPaths getLearningPathsTrainee() {
		return LearningPathsTrainee;
	}
	public void setLearningPathsTrainee(LearningPaths learningPathsTrainee) {
		LearningPathsTrainee = learningPathsTrainee;
	}



	
	
}
