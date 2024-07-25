package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.persistence.InlogService;

@RestController
public class InlogEndpoint {

	@Autowired
	InlogService inlogs;
	
//	Not Final code
	
	@GetMapping("/trainees")
	public Iterable<Trainee> alleTrainees(){
		return inlogs.geefAlleTrainees();
	}
	
	

}