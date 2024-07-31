package LaaS.ProjectLaaS.persistence;


import LaaS.ProjectLaaS.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
		Books findByPhysicalContentId(Long physicalContentId);
}