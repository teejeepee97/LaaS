package LaaS.ProjectLaaS.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Books extends PhysicalContent{

	@OneToMany
	private List<Reservations>reservations;
	
}
