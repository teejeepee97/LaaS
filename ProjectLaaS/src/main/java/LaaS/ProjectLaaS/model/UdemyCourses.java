package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UdemyCourses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int udemyId ;
	private int onlineContentId;
	
	public int getUdemyId() {
		return udemyId;
	}
	public void setUdemyId(int udemyId) {
		this.udemyId = udemyId;
	}
	public int getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(int onlineContentId) {
		this.onlineContentId = onlineContentId;
	}
	
}
