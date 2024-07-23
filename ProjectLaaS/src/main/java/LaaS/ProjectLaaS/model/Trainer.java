package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int tranerId;

	public int getTranerId() {
		return tranerId;
	}

	public void setTranerId(int tranerId) {
		this.tranerId = tranerId;
	}
	
	
	

}
