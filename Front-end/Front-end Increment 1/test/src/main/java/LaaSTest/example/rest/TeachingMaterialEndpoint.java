package LaaSTest.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import LaaSTest.example.domain.TeachingMaterial;
import LaaSTest.example.persistence.TeachingMaterialService;

@RestController
public class TeachingMaterialEndpoint {
	@Autowired
	TeachingMaterialService ts;
	
	@GetMapping("teachingMaterialData")
	public Iterable<TeachingMaterial> allTeachingMaterial(){
		System.out.println("Waar zijn die teachingMaterials???");
		return ts.teachingMaterialData();
	}
}
