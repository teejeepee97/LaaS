package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Trainee extends User {
    @OneToMany(mappedBy = "trainee")
    private List<Reservations> reservations;

    @OneToOne
    private LearningPaths learningPaths;

    // Getters and Setters
    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    public LearningPaths getLearningPaths() {
        return learningPaths;
    }

    public void setLearningPaths(LearningPaths learningPaths) {
        this.learningPaths = learningPaths;
    }
}
