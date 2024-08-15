package LaaS.ProjectLaaS.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public class PhysicalContent extends Content{
	
//	private int physicalContentId;
	private boolean available;
	private String physicalWear;
	
	@OneToOne
	private Reservations reservation;

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getPhysicalWear() {
		return physicalWear;
	}
	public void setPhysicalWear(String physicalWear) {
		this.physicalWear = physicalWear;
	}
	public Reservations getReservation() {
		return reservation;
	}
	public void setReservation(Reservations reservation) {
		this.reservation = reservation;
	}
	
	
}
