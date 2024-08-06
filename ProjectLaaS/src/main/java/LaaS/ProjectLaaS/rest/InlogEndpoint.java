package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.persistence.InlogService;

@RestController
@RequestMapping
public class InlogEndpoint {
	
	@Autowired
	private final InlogService inlogService = new InlogService();

	
//	@GetMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        if (inlogService.authenticate(username, password)) {
//            return "Login successful!";
//        } else {
//            return "Invalid username or password.";
//        }
//    }
	
	@GetMapping("/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password) {
		try {
	        if (inlogService.authenticate(username, password)) {
	            return "Login successful!";
	        } else {
	            return "Invalid username or password.";
	        }
		} catch(Exception e) {
			return "Unknown username";
		}
	}
	
}

