package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Onlinecontent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long onlineContentId;
	private int contentId;
	
	int b;
	
	public long getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(long onlineContentId) {
		this.onlineContentId = onlineContentId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	
}
