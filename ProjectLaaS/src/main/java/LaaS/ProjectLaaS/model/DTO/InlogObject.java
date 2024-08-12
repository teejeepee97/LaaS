package LaaS.ProjectLaaS.model.DTO;

import LaaS.ProjectLaaS.model.Trainee;
import LaaS.ProjectLaaS.model.User;

public class InlogObject {
	Long UserId;
	String Rol;
	String Name;
	
	public InlogObject(User user){
		UserId = user.getUserId();
		Name = user.getName();
		if (user instanceof Trainee) {
			Rol = "Trainee";
		}else {
			Rol = "Trainer";
		}
	}
	
	public User verkrijgUser() {
		User user = new User();
		user.setName(Name);
		user.setUserId(UserId);
		return user;
	}
	
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	

	
	

}
