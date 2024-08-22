package LaaS.ProjectLaaS.persistence;

import LaaS.ProjectLaaS.model.Books;
import LaaS.ProjectLaaS.model.ReservationStatus;
import LaaS.ProjectLaaS.model.DTO.showBooksObject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface BooksRepository extends CrudRepository<Books, Long> {
		//Books findByPhysicalContentId(long physicalContentId);
		Books findByContentId(long contentId);
		
		//@Query(value="SELECT laas.reservations.reservation_id, laas.books.content_name, laas.books.available, laas.books.content_description, laas.books.content_subject, laas.books.content_id, laas.books.amount, laas.books.physical_content_id, laas.books.physical_wear, laas.books.reservation_reservation_id FROM laas.books JOIN laas.reservations ON laas.books.content_id = laas.reservations.content_id WHERE laas.reservations.reservation_status =:status;", nativeQuery=true)
		//@Query(value="SELECT new LaaS.ProjectLaas.model.DTO.showBooksObject(b.content_name, b.available, b.content_description, b.content_subject, b.content_id, b.amount, b.physical_content_id, b.physical_wear, r.reservation_id)FROM laas.books b JOIN laas.reservations r ON laas.books.content_id = laas.reservations.content_id WHERE laas.reservations.reservation_status =:status;", nativeQuery=true)
		@Query(value="SELECT b.content_name, b.available, b.content_description, b.content_subject, b.content_id, b.physical_wear, r.reservation_id FROM laas.books b JOIN laas.reservations r ON b.content_id = r.book_content_id WHERE r.reservation_status =:status;", nativeQuery=true)
		List<showBooksProjection> findByReservationStatus(@Param("status") String status);
		
		@Query(value="SELECT COUNT(user_name) FROM laas.reservations WHERE user_name=:userName AND reservation_status !=  \"TERUG_GEBRACHT\";", nativeQuery=true)
		Integer findCountByUsername(@Param("userName") String userName);
		
		@Query(value="SELECT b.content_name FROM laas.books b JOIN laas.reservations r ON b.content_id = r.book_content_id WHERE r.user_name=:userName AND r.reservation_status !=  \"TERUG_GEBRACHT\";",nativeQuery=true)
		List<showReservedBooksProjection> findReserveredBooksByUsername(@Param("userName") String userName);
}

