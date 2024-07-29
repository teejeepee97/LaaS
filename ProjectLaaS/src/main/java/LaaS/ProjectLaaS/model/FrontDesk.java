package LaaS.ProjectLaaS.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class FrontDesk extends User{
	
	@OneToMany
	private List<Reservations> reservation;
}
