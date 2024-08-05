package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.ReservationStatus;
import LaaS.ProjectLaaS.model.Reservations;
import LaaS.ProjectLaaS.persistence.BookService;


@RestController
public class BookEndpoint {
	
	@Autowired
	private BookService BookService; 
	
	@GetMapping("/reserve")
    public Reservations reserveBook(@RequestParam long userId, @RequestParam long physicalContentId) {
        return BookService.reserveBook(userId, physicalContentId);
    }
	
	@GetMapping("/reserveFrontEnd/{userId}/{contentId}")
    public Books reserveBookFrontEnd(@PathVariable("userId") long userId, @PathVariable("contentId") long contentId) {
        return BookService.reserveBookFrontEnd(userId, contentId);
    }
	
	
	@GetMapping("/updateReservationStatus")
    public void updateReservationStatus(@RequestParam Long reservationId, @RequestParam ReservationStatus status) {
        BookService.updateReservationStatus(reservationId, status);
    }
	
	@GetMapping("/showBooks")
    public Iterable<Books> showBooks() {
        return BookService.showBooks();
    }
	
	@GetMapping("/addBook/{newTitle}")
	public void addBook(@PathVariable("newTitle")String title) {
		Books book = new Books();
		book.setContentName(title);
		book.setAvailable(true);
		book.setContentDescription("test");
		BookService.saveBook(book);
	}
	
	@GetMapping("/returnFrontEnd/{userId}/{contentId}")
    public Books returnBookFrontEnd(@PathVariable("userId") long userId, @PathVariable("contentId") long contentId) {
        return BookService.returnBookFrontEnd(userId, contentId);
    }
}	
	

	
	