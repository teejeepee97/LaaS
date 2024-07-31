package LaaS.ProjectLaaS.persistence;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.Books;
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
        reservation.setBook(book);
        reservation.setBookName(book.getContentName());
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        reservation.setReservationStatus(true);

        return reservationsRepository.save(reservation);
	}
}
