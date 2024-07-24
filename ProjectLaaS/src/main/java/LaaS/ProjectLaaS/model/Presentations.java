package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Presentations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int presentationId;
	private int onlineContentId;
	
	public int getPresentationId() {
		return presentationId;
	}
	public void setPresentationId(int presentationId) {
		this.presentationId = presentationId;
	}
	public int getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(int onlineContentId) {
		this.onlineContentId = onlineContentId;
	}

}
