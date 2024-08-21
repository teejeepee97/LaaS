package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;
    private Date reservationDate;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

//    @ManyToOne
//    private Trainee trainee;
    
    @ManyToOne
    private User user;

    @ManyToOne
    private Books book;

    // Getters and Setters
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

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    
    public long getContentId() {
    	return book.getContentId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(Trainee trainee) {
        this.user = trainee;
    }
    
    public void setUser(Trainer trainer) {
    	this.user = trainer;
    }
    
    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
}

