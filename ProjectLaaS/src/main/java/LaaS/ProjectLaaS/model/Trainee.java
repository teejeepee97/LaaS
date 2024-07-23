package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int traineeId;
	private int userId;
	private String learningPathEnrollment;
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLearningPathEnrollment() {
		return learningPathEnrollment;
	}
	public void setLearningPathEnrollment(String learningPathEnrollment) {
		this.learningPathEnrollment = learningPathEnrollment;
	}
	

	
	
}
