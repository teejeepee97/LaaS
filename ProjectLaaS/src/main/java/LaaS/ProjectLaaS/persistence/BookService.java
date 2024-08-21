package LaaS.ProjectLaaS.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.PasswordHasher;
import LaaS.ProjectLaaS.model.PhysicalWear;
import LaaS.ProjectLaaS.model.ReservationStatus;
import LaaS.ProjectLaaS.model.Reservations;
import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.Trainer;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private TraineeRepository traineeRepository;
    
    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private BooksRepository booksRepository;
	
	@Autowired
	private ReservationsRepository reservationsRepository;
	
	public void updateWaitList(String bookName) {
		Iterator<Reservations> reservations = showReservations().iterator();
		while(reservations.hasNext()) {
			Reservations reservation = reservations.next();
			if (reservation.getBook().getContentName().equals(bookName) && reservation.getReservationStatus() == ReservationStatus.IN_AFWACHTING) {
				reservation.setReservationStatus(ReservationStatus.UITGELEEND);
				reservation.getBook().setAvailable(false);
				reservationsRepository.save(reservation);
				break;
			}
		}
	}
	
	public void updateReservationFrontEnd2(Long reservationId) {
		Reservations reservation = reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
		
		 if (reservation.getReservationStatus() == ReservationStatus.UITGELEEND) {
			 	System.out.println("book is available");
	            Books book = reservation.getBook();
	            if (book != null) {
	            	System.out.println("book is weer available");
	                book.setAvailable(true);
	                booksRepository.save(book);
	                updateWaitList(book.getContentName());
//	                reservationList.remove(reservationList.indexOf(reservation));
	            }
	   		 reservation.setReservationStatus(ReservationStatus.TERUG_GEBRACHT);
		     reservationsRepository.save(reservation);
	        }
	}
	
	public Reservations updateReservationBookFrontEnd(String username, Long contentId) {
		Reservations reservation = new Reservations();
	    Trainee trainee = traineeRepository.findByName(username).orElse(null);
	    
	    if (trainee != null) {
	    	reservation.setUserName(username);
	    }
	    else {
	    	Trainer trainer = trainerRepository.findByName(username).orElse(null);
	    	reservation.setUserName(username);
	    }
	    
		Books book = booksRepository.findByContentId(contentId);

        reservation.setBook(book);
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        reservation.setReservationStatus(ReservationStatus.IN_AFWACHTING); // Set the initial reservation status
	    System.out.println(reservation.getReservationStatus());
	    
	    if(book.isAvailable()) {
	    	book.setAvailable(false);
	    	reservation.setReservationStatus(ReservationStatus.UITGELEEND); // Set the initial reservation status
	    }

	    booksRepository.save(book);
        return reservationsRepository.save(reservation);  
	}
	
	
	public Iterable<Reservations> showReservations(){
		return reservationsRepository.findAll();
	}
	
	public Iterable<Books> showBooks() {
		System.out.println("check showbooks");
		return booksRepository.findAll();
	}

	public void saveBook(Books book) {
		booksRepository.save(book);
	}
	
	public Books updatePhysicalWear(Long contentId, PhysicalWear newWear) {
		Books book = booksRepository.findByContentId(contentId);
		if(book != null) {
			if(book.getPhysicalWear().ordinal() < newWear.ordinal()) {
				book.setPhysicalWear(newWear);
			}
			else {
				throw new RuntimeException("The physical wear can only be downgraded.");
			}
		}
		else {
			throw new RuntimeException("Book not found.");
		}
		return book;
	}
	
	public List<showBooksProjection> showBooksByReservationStatus(String reservationStatus) {
		System.out.println("check2");
		return booksRepository.findByReservationStatus(reservationStatus);
	}
	
	public Iterable<Reservations> getAllReservations(){
		return reservationsRepository.findAll();
	}
}	

