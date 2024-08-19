package LaaS.ProjectLaaS.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import LaaS.ProjectLaaS.model.LearningPaths;
import LaaS.ProjectLaaS.model.Reservations;

@Component
public interface ReservationsRepository extends CrudRepository <Reservations, Long>{
	Optional<Reservations> findByContentId(long contentId);
	//Iterable<Reservations> findByReservationStatus(ReservationStatus reservationStatus);
	@Query(value="SELECT * FROM laas.reservations;", nativeQuery=true)
	List<Reservations> getReservations();
}

