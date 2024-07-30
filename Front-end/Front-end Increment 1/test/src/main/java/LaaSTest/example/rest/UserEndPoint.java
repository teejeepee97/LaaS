package LaaSTest.example.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import LaaSTest.example.domain.*;
import LaaSTest.example.persistence.*;
import LaaSTest.example.domain.*;

@RestController
public class UserEndPoint {
	@Autowired
	UserService us;
	
	@GetMapping("userdata")
	public Iterable<User> allUsers(){
		return us.userdata();
	}
	
	@GetMapping("Login2.html/{username}/{password}")
	public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
		return username + " " + password;
	}

}



