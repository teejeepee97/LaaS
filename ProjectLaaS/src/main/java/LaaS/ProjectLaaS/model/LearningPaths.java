package LaaS.ProjectLaaS.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LearningPaths {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long learningPathId ;
	private String learningPathName;
	private int userId;
	
	@ManyToAny
	private List <Course> Courses = new ArrayList();	
	
	
	public long getLearningPathId() {
		return learningPathId;
	}
	public void setLearningPathId(long learningPathId) {
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
