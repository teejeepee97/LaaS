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

        Reservations reservation = new Reservations();
        reservation.setTrainee(trainee);
        reservation.setBook(book);
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        reservation.setReservationStatus(true);

        return reservationsRepository.save(reservation);
	}
	
	
	
//	Not Final code


}
