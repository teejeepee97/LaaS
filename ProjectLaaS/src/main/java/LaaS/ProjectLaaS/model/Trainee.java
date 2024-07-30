package LaaS.ProjectLaaS.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Trainee extends User{
	
	private String learningPathEnrollment;
	
	@OneToMany
	private List<Reservations> reservation;
	
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
	public List<Reservations> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservations> reservation) {
		this.reservation = reservation;
	}
	
}
