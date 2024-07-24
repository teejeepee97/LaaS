package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int bookId;
	private int physicalContentId;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getPhysicalContentId() {
		return physicalContentId;
	}
	public void setPhysicalContentId(int physicalContentId) {
		this.physicalContentId = physicalContentId;
	}
	

	
}
