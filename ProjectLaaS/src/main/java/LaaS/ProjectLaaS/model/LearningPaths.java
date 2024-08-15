package LaaS.ProjectLaaS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LearningPaths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long learningPathId;
    private String learningPathName;

    @ManyToOne
    private Trainee trainee; 

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    // Getters and Setters
    public long getLearningPathId() {
        return learningPathId;
    }

    public void setLearningPathId(long learningPathId) {
        this.learningPathId = learningPathId;
    }

    public String getLearningPathName() {
        return learningPathName;
    }

    public void setLearningPathName(String learningPathName) {
        this.learningPathName = learningPathName;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
