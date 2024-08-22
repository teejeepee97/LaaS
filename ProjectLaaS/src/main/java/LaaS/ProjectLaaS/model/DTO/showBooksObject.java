package LaaS.ProjectLaaS.model.DTO;

public class showBooksObject {
	private String contentName;
    private Boolean available;
    private String contentDescription;
    private String contentSubject;
    private Long contentId;
    private Integer amount;
    private String physicalContentId;
    private String physicalWear;
    private Long reservationId;
    
    public showBooksObject(String contentName, Boolean available, String contentDescription, String contentSubject, Long contentId, Integer amount, String physicalContentId, String physicalWear, Long reservationId) {
        this.contentName = contentName;
        this.available = available;
        this.contentDescription = contentDescription;
        this.contentSubject = contentSubject;
        this.contentId = contentId;
        this.amount = amount;
        this.physicalContentId = physicalContentId;
        this.physicalWear = physicalWear;
        this.reservationId = reservationId;
    }
}
