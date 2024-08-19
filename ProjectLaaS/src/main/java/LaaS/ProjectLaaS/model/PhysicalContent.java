package LaaS.ProjectLaaS.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public class PhysicalContent extends Content{
	
	private boolean available;
	
	@Enumerated(EnumType.STRING)
	private PhysicalWear physicalWear;
	
	@OneToOne
	private Reservations reservation;

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public PhysicalWear getPhysicalWear() {
		return physicalWear;
	}
	public void setPhysicalWear(PhysicalWear physicalWear) {
		this.physicalWear = physicalWear;
	}
	public Reservations getReservation() {
		return reservation;
	}
	public void setReservation(Reservations reservation) {
		this.reservation = reservation;
	}
}
