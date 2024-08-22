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
	
	public void specifyReservation(String username, Books book, Reservations reservation) {
		reservation.setUserName(username);
		reservation.setBook(book);
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        ReservationStatus status = ReservationStatus.IN_AFWACHTING; 
	    if (book.isAvailable()) {
	        book.setAvailable(false);
	        status = ReservationStatus.UITGELEEND; // Set the initial reservation status if the book is available
	    }
	    reservation.setReservationStatus(status);
	}
	
	public Reservations updateReservationBookFrontEnd2(String username, Long contentId) {
		boolean canMakeReservation = false;
		Reservations reservation = new Reservations();
		Books book = booksRepository.findByContentId(contentId);
	    Trainee trainee = traineeRepository.findByName(username).orElse(null);
	    
	    if (trainee != null) {
	    	if(booksRepository.findCountByUsername(username) < 3) {
	    		specifyReservation(username, book, reservation);
	    		canMakeReservation = true;
	    	}
	    	else {
	    		System.out.println("The maximum amount a reservations has been reached.");
	    		throw new IllegalArgumentException("The maximum amount a reservations has been reached.");
	    	}
	    }
	    else {
	    	Trainer trainer = trainerRepository.findByName(username).orElse(null);
	    	specifyReservation(username, book, reservation);
	    	canMakeReservation = true;
	    }
	    
	    if(canMakeReservation) {
	    	booksRepository.save(book);
	        return reservationsRepository.save(reservation);  
	    }
	    else {
	    	return null;
	    }
	}
	
	public String updateReservationBookFrontEnd3(String username, Long contentId) {
	    Books book = booksRepository.findByContentId(contentId);
	    if (book == null) {
	        throw new IllegalArgumentException("Book with the given content ID does not exist.");
	    }

	    Trainee trainee = traineeRepository.findByName(username).orElse(null);
	    List<showReservedBooksProjection> reservedBooksList = booksRepository.findReserveredBooksByUsername(username);
	    if (reservedBooksList.stream().anyMatch(reservation -> reservation.getContentName().equals(book.getContentName()))) {
//	        throw new IllegalArgumentException("Book already in reservations by this user.");
	    	return String.format("%s has already been reserved by %s", book.getContentName(), username);
	    }

	    if (trainee != null && booksRepository.findCountByUsername(username) >= 3) {
//	        throw new IllegalArgumentException("The maximum amount of reservations has been reached.");
	        return "Your maximum amount of reservations has been reached.";
	    }

	    Reservations reservation = new Reservations();
	    reservation.setUserName(username);
		reservation.setBook(book);
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        ReservationStatus status = ReservationStatus.IN_AFWACHTING; 
	    if (book.isAvailable()) {
	        book.setAvailable(false);
	        status = ReservationStatus.UITGELEEND; // Set the initial reservation status if the book is available
	    }
	    reservation.setReservationStatus(status);
	    booksRepository.save(book);
	    reservationsRepository.save(reservation); 
	    return String.format("Reservation for book %s has been reserved by user s%",book.getContentName(), username);
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

