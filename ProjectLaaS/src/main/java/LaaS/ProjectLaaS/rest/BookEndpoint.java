package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.persistence.BookService;


@RestController
public class BookEndpoint {

	@Autowired
	BookService books;
	
//	Not Final code
	
	

}