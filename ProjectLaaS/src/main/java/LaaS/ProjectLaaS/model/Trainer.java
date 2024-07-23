package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int TrainerId;
	private int userId;
	
	public int getTrainerId() {
		return TrainerId;
	}
	public void setTrainerId(int trainerId) {
		TrainerId = trainerId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

	
}
