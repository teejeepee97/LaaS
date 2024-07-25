package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.persistence.FeedbackService;


@RestController
public class FeedbackEndpoint {

	@Autowired
	FeedbackService feedbacks;
	
//	Not Final code
	
	

}