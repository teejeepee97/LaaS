package LaaS.ProjectLaaS.persistence;

import LaaS.ProjectLaaS.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}
