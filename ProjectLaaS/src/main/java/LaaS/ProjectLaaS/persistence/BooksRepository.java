package LaaS.ProjectLaaS.persistence;


import LaaS.ProjectLaaS.model.Books;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
		Books findByPhysicalContentId(Long physicalContentId);
		
		@Query("SELECT MAX(b.physicalContentId) FROM Books b")
	    Optional<Integer> findMaxPhysicalContentId();
}