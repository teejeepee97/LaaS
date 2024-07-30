package LaaSTest.example.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import LaaSTest.example.domain.TeachingMaterial;

@Component
public class TeachingMaterialService {
	@Autowired // Dependency Injection
	TeachingMaterialRepository tr;
	
	public Iterable<TeachingMaterial> teachingMaterialData(){
		return tr.findAll();
	}
	
}
