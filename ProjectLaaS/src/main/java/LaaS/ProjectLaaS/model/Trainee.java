package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Trainee extends User {
    @OneToOne
    private LearningPaths learningPaths;

    public LearningPaths getLearningPaths() {
        return learningPaths;
    }

    public void setLearningPaths(LearningPaths learningPaths) {
        this.learningPaths = learningPaths;
    }
}
