package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.User;
import LaaS.ProjectLaaS.model.DTO.InlogObject;
import LaaS.ProjectLaaS.persistence.InlogService;

@RestController
@RequestMapping
public class InlogEndpoint {
	
	@Autowired
	private final InlogService inlogService = new InlogService();

	
//	@GetMapping("/login/{username}/{password}")
//    public InlogObject login(@PathVariable String username, @PathVariable String password) {
//		try {
//	        if (inlogService.authenticate(username, password) != null) {
//	            //return "Login successful!";
//	           // return inlogService.authenticate(username, password);
////	        	InlogObject inlogObject = new InlogObject();
//	        	User a = inlogService.authenticate(username, password);
////	        	inlogObject.setName(a.getName());
////	        	inlogObject.setUserId(a.getUserId());
////	        	if (a instanceof Trainee ) {
////	        		inlogObject.setRol("Trainee");
////	        	}else {
////	        		inlogObject.setRol("Trainer");
////	        	}	
//	        	return new InlogObject(a);
//	        } else {
//	            //return "Invalid username or password.";
//	            return null;
//	        }
//		} catch(Exception e) {
//			//return "Unknown username";
//			return null;
//		}
//	}
	
	
	@GetMapping("/login/{username}/{password}")
	public InlogObject login(@PathVariable String username, @PathVariable String password) {
	    try {
	        User user = inlogService.authenticate(username, password);
	        return new InlogObject(user);
	    } catch(Exception e) {
	        return null;
	    }
	}

	@GetMapping("/SnappenWijEvenDTOs")
	public void SnappenWijEvenDTOs(InlogObject io) {
		User u = io.verkrijgUser();
		//DTO's gebruiken we in de volgende situaties
		// 1. Maskeren
		// 2. Ten delen exposen
		// 3. Combinatie van Entiteiten
	}
}

