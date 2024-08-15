package LaaS.ProjectLaaS.persistence;

import LaaS.ProjectLaaS.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
