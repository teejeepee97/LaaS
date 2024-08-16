package LaaS.ProjectLaaS.persistence;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.PhysicalWear;
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
	
	public void updateWaitList(String bookName) {
		Iterator<Reservations> reservations = showReservations().iterator();
		
		while(reservations.hasNext()) {
			Reservations reservation = reservations.next();
			if (reservation.getBookName().equals(bookName) && reservation.getReservationStatus() == ReservationStatus.IN_AFWACHTING) {
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
	
	public Reservations updateReservationBookFrontEnd(Long userId, Long contentId) {
		Trainee trainee = traineer.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Trainee not found"));
		Books book = booksRepository.findByContentId(contentId);
		
		Reservations reservation = new Reservations();
        reservation.setTrainee(trainee);
        reservation.setBook(book); // Associate the book entity
        reservation.setBookName(book.getContentName()); // Set the book name
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        reservation.setReservationStatus(ReservationStatus.IN_AFWACHTING); // Set the initial reservation status
        reservation.setContentId();
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
	
	public ReservationStatus getReservationStatus(long contentId) {
		Reservations reservation = reservationsRepository.findByContentId(contentId)
				.orElseThrow(() -> new RuntimeException("Content not found"));
		return reservation.getReservationStatus();
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
//---------------------------------------------------------------------------------------------------------------------------------------------
//	public Reservations reserveBook (Long userId, Long physicalContentId) {
//		Trainee trainee = traineer.findByUserId(userId)
//	                .orElseThrow(() -> new RuntimeException("Trainee not found"));
//
//		Books book = booksRepository.findByPhysicalContentId(physicalContentId);
//	    new RuntimeException("Book not found");
//	    
//	    //Check if the book is available
//	    if (book.getAmount() <= 0) {
//	    	throw new RuntimeException("Book not available");
//	    }
//	    
//	    //Decrease the amount by 1
//	    book.setAmount(book.getAmount()-1);
//	    booksRepository.save(book);
//
//        Reservations reservation = new Reservations();
//        reservation.setTrainee(trainee);
//        reservation.setBook(book); // Associate the book entity
//        reservation.setBookName(book.getContentName()); // Set the book name
//        reservation.setReservationDate(new Date(System.currentTimeMillis()));
//        reservation.setReservationStatus(ReservationStatus.IN_AFWACHTING); // Set the initial reservation status
//
//        return reservationsRepository.save(reservation);   
//	}
//	
//	public Books reserveBookFrontEnd(Long userId, Long contentId) {
//		Books book = booksRepository.findByContentId(contentId);
//	    
//	    
//	    if(book.isAvailable()) {
//	    	book.setAvailable(false);
//	    }
//	    else {
//	    	new RuntimeException("Book not available");
//	    }
//	    return booksRepository.save(book);
//	    
//	}
//	
//	public Books returnBookFrontEnd(Long userId, Long contentId) {
//		Books book = booksRepository.findByContentId(contentId);
//		System.out.println(book.isAvailable());
//		
//		if(!book.isAvailable()) {
//			book.setAvailable(true);
//		}
//		else {
//	    	new RuntimeException("Book is available");
//	    }
//		return booksRepository.save(book);
//	}
//	
//	public void updateReservationStatus(Long reservationId, ReservationStatus status) {
//		Reservations reservation = reservationsRepository.findById(reservationId)
//                .orElseThrow(() -> new RuntimeException("Reservation not found"));
//		
//		
//		 if (status == ReservationStatus.TERUG_GEBRACHT) {
//	            Books book = reservation.getBook();
//	            if (book != null) {
//	                book.setAmount(book.getAmount() + 1);
//	                booksRepository.save(book);
//	            }
//	        }
//	
//        reservation.setReservationStatus(status);
//        reservationsRepository.save(reservation);
//	}
//
//public void updateReservationFrontEnd(Long reservationId, ReservationStatus status) {
//	boolean inReservation = false;
//	Reservations reservation = reservationsRepository.findById(reservationId)
//            .orElseThrow(() -> new RuntimeException("Reservation not found"));
//	
//	 if (status == ReservationStatus.TERUG_GEBRACHT) {
//            Books book = reservation.getBook();
//            if (book != null) {
//                book.setAvailable(true);
//                booksRepository.save(book);
//                inReservation = updateWaitList(book.getContentName());
//            }
//        }
//	 if(!inReservation) {
//		 reservation.setReservationStatus(status);
//	     reservationsRepository.save(reservation);
//	 }
//}
//
//public Books updatePhysicalWear(Long contentId, PhysicalWear newWear) {
//    Books book = booksRepository.findByContentId(contentId);
//    if (book != null) {
//        // Degrade physical wear if the new wear is worse
//        if (book.getPhysicalWear() == PhysicalWear.GOOD && newWear == PhysicalWear.MEDIUM) {
//            book.setPhysicalWear(newWear);
//        } else if (book.getPhysicalWear() == PhysicalWear.MEDIUM && newWear == PhysicalWear.BAD) {
//            book.setPhysicalWear(newWear);
//        } else if (book.getPhysicalWear() == PhysicalWear.GOOD && newWear == PhysicalWear.BAD) {
//            book.setPhysicalWear(newWear);
//        } else {
//            throw new RuntimeException("The physical wear can only be downgraded.");
//        }
//        booksRepository.save(book);
//    } else {
//        throw new RuntimeException("Book not found.");
//    }
//    return book;
//}