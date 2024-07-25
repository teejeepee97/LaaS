package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tutorials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int tutorialId;
	private int onlineContentId;
	
	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public int getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(int onlineContentId) {
		this.onlineContentId = onlineContentId;
	}
	
	
}
