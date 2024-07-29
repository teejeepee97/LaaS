package LaaS.ProjectLaaS.model;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long reservationId;
	private Date reservationDate;
	private int userId;
	private boolean reservationStatus;
	
	
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}
