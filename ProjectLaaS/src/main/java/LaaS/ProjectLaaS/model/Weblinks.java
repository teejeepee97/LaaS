package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weblinks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int webLinkid;
	private int onlineContentId;
	
	public int getWebLinkid() {
		return webLinkid;
	}
	public void setWebLinkid(int webLinkid) {
		this.webLinkid = webLinkid;
	}
	public int getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(int onlineContentId) {
		this.onlineContentId = onlineContentId;
	}
	
}
