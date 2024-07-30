package LaaSTest.example.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaSTest.example.domain.*;

@Component
public interface TeachingMaterialRepository extends CrudRepository<TeachingMaterial, Long>{
	
}
