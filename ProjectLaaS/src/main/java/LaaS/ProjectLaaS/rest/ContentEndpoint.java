package LaaS.ProjectLaaS.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import LaaS.ProjectLaaS.persistence.ContentService;


@RestController
public class ContentEndpoint {

	@Autowired
	ContentService contents;
	
//	Not Final code
	
	

}