package LaaS.ProjectLaaS.persistence;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.ReservationStatus;
import LaaS.ProjectLaaS.model.Reservations;
import LaaS.ProjectLaaS.model.Trainee;

@Service
public class BookService {
	
	@Autowired
	private TraineeRepository traineer;
	
	@Autowired
    private BooksRepository booksRepository;
	
	@Autowired
	private ReservationsRepository reservationsRepository;
	
	public Reservations reserveBook (Long userId, Long physicalContentId) {
		Trainee trainee = traineer.findByUserId(userId)
	                .orElseThrow(() -> new RuntimeException("Trainee not found"));

		Books book = booksRepository.findByPhysicalContentId(physicalContentId);
	    new RuntimeException("Book not found");
	    
	    //Check if the book is available
	    if (book.getAmount() <= 0) {
	    	throw new RuntimeException("Book not available");
	    }
	    
	    //Decrease the amount by 1
	    book.setAmount(book.getAmount()-1);
	    booksRepository.save(book);

        Reservations reservation = new Reservations();
        reservation.setTrainee(trainee);
        reservation.setBook(book); // Associate the book entity
        reservation.setBookName(book.getContentName()); // Set the book name
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        reservation.setReservationStatus(ReservationStatus.IN_AFWACHTING); // Set the initial reservation status

        return reservationsRepository.save(reservation);   
	}
	
	public void updateReservationStatus(Long reservationId, ReservationStatus status) {
		Reservations reservation = reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
		
		
		 if (status == ReservationStatus.TERUG_GEBRACHT) {
	            Books book = reservation.getBook();
	            if (book != null) {
	                book.setAmount(book.getAmount() + 1);
	                booksRepository.save(book);
	            }
	        }
	
        reservation.setReservationStatus(status);
        reservationsRepository.save(reservation);
	}
	
	
	
	public Books addBook(String contentName, String contentDescription, String contentSubject, int amount, boolean available, String physicalWear) {
		int nextPhysicalContentId = booksRepository.findMaxPhysicalContentId().orElse(0) + 1;
		
		Books book = new Books();
        book.setContentName(contentName);
        book.setContentDescription(contentDescription);
        book.setContentSubject(contentSubject);
        book.setAmount(amount);
        book.setAvailable(available);
        book.setPhysicalContentId(nextPhysicalContentId);
        book.setPhysicalWear(physicalWear);

        return booksRepository.save(book);
        
	}
}