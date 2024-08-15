package LaaS.ProjectLaaS.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.ReservationStatus;
import LaaS.ProjectLaaS.model.Reservations;
import LaaS.ProjectLaaS.model.Trainee;

import java.sql.Date;
import java.util.Iterator;

@Service
public class BookService {

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    public Books reserveBookFrontEnd(Long userId, Long contentId) {
        Books book = booksRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.isAvailable()) {
            book.setAvailable(false);
            booksRepository.save(book);
            createReservation(userId, book, ReservationStatus.UITGELEEND);
        } else {
            throw new RuntimeException("Book not available");
        }
        return book;
    }

    public Books returnBookFrontEnd(Long userId, Long contentId) {
        Books book = booksRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            book.setAvailable(true);
            booksRepository.save(book);
            updateReservationStatusForReturnedBook(book);
        } else {
            throw new RuntimeException("Book is already available");
        }
        return book;
    }

    public boolean updateWaitList(String bookName) {
        Iterator<Reservations> reservations = reservationsRepository.findAll().iterator();
        while (reservations.hasNext()) {
            Reservations reservation = reservations.next();
            if (reservation.getBook().getContentName().equals(bookName)) {
                reservation.setReservationStatus(ReservationStatus.UITGELEEND);
                reservationsRepository.save(reservation);
                return true;
            }
        }
        return false;
    }

    public void updateReservationFrontEnd(Long reservationId, ReservationStatus status) {
        Reservations reservation = reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if (status == ReservationStatus.TERUG_GEBRACHT) {
            Books book = reservation.getBook();
            if (book != null) {
                book.setAvailable(true);
                booksRepository.save(book);
                updateWaitList(book.getContentName());
            }
        }
        reservation.setReservationStatus(status);
        reservationsRepository.save(reservation);
    }

    public Reservations createReservation(Long userId, Books book, ReservationStatus status) {
        Trainee trainee = traineeRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Trainee not found"));

        Reservations reservation = new Reservations();
        reservation.setTrainee(trainee);
        reservation.setBook(book);
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        reservation.setReservationStatus(status);

        return reservationsRepository.save(reservation);
    }

    private void updateReservationStatusForReturnedBook(Books book) {
        Iterator<Reservations> reservations = reservationsRepository.findAll().iterator();
        while (reservations.hasNext()) {
            Reservations reservation = reservations.next();
            if (reservation.getBook().equals(book) && reservation.getReservationStatus() == ReservationStatus.UITGELEEND) {
                reservation.setReservationStatus(ReservationStatus.TERUG_GEBRACHT);
                reservationsRepository.save(reservation);
                updateWaitList(book.getContentName());
                break;
            }
        }
    }

    public Iterable<Reservations> showReservations() {
        return reservationsRepository.findAll();
    }

    public Iterable<Books> showBooks() {
        return booksRepository.findAll();
    }

    public void saveBook(Books book) {
        booksRepository.save(book);
    }
}
