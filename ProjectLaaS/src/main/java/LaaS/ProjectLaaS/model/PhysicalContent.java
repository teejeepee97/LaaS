package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhysicalContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int physicalContentId;
	private int contentId;
	
	public int getPhysicalContentId() {
		return physicalContentId;
	}
	public void setPhysicalContentId(int physicalContentId) {
		this.physicalContentId = physicalContentId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	
}
