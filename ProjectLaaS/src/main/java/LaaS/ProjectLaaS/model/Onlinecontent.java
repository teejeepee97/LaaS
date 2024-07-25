package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Onlinecontent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int onlineContentId ;
	private int contentId;
	
	public int getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(int onlineContentId) {
		this.onlineContentId = onlineContentId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	
}
