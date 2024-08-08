package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.User;
import LaaS.ProjectLaaS.persistence.InlogService;

@RestController
@RequestMapping
public class InlogEndpoint {
	
	@Autowired
	private final InlogService inlogService = new InlogService();

	
	@GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password) {
		try {
			if (true) {
//	        if (inlogService.authenticate(username, password) != null) {
//	            return inlogService.authenticate(username, password);
	        	return null;
	        } else {
	            return null;
	        }
		} catch(Exception e) {
			return null;
		}
	}
}

