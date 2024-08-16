package LaaS.ProjectLaaS.persistence;

public interface showBooksProjection {
	    String getContentName();
	    Boolean getAvailable();
	    String getContentDescription();
	    String getContentSubject();
	    Long getContentId();
	    Integer getAmount();
	    String getPhysicalContentId();
	    String getPhysicalWear();
	    Long getReservationId();
}
