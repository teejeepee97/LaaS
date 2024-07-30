package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.Reservations;
import LaaS.ProjectLaaS.persistence.BookService;


@RestController
@RequestMapping("Books")
public class BookEndpoint {
	
	@Autowired
	private BookService BookService; 
	
	@PostMapping("/reserve")
    public Reservations reserveBook(@RequestParam long userId, @RequestParam long physicalContentId) {
        return BookService.reserveBook(userId, physicalContentId);
    }

}