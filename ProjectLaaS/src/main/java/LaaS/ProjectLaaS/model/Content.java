package LaaS.ProjectLaaS.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Content {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contentId;
//	private int courseId;
	private String contentName;
	private String contentDescription;
	private String contentSubject;
	
	public long getContentId() {
		return contentId;
	}
	public void setContentId(long contentId) {
		this.contentId = contentId;
	}
//	public int getCourseId() {
//		return courseId;
//	}
//	public void setCourseId(int courseId) {
//		this.courseId = courseId;
//	}
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentDescription() {
		return contentDescription;
	}
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}
	public String getContentSubject() {
		return contentSubject;
	}
	public void setContentSubject(String contentSubject) {
		this.contentSubject = contentSubject;
	}
	
	
}
