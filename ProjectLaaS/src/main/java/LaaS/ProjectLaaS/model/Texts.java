package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Texts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int textId;
	private int onlineContentId;
	
	public int getTextId() {
		return textId;
	}
	public void setTextId(int textId) {
		this.textId = textId;
	}
	public int getOnlineContentId() {
		return onlineContentId;
	}
	public void setOnlineContentId(int onlineContentId) {
		this.onlineContentId = onlineContentId;
	}
	
}
