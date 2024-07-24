package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Readers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int readerId ;
	private int physicalContentId;
	
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public int getPhysicalContentId() {
		return physicalContentId;
	}
	public void setPhysicalContentId(int physicalContentId) {
		this.physicalContentId = physicalContentId;
	}

	
}
