package LaaS.ProjectLaaS.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LearningPaths {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int learningPathId ;
	private String learningPathName;
	private int userId;
	
	
	public int getLearningPathId() {
		return learningPathId;
	}
	public void setLearningPathId(int learningPathId) {
		this.learningPathId = learningPathId;
	}
	public String getLearningPathName() {
		return learningPathName;
	}
	public void setLearningPathName(String learningPathName) {
		this.learningPathName = learningPathName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
