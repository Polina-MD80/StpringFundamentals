package softuni.spring.model.entity;

import softuni.spring.model.entity.enums.ProgressEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity{
//    •	Has a Name (unique)
//    o	Name length must be between 3 and 20 characters (inclusive 3 and 20).
//            •	Has a Description
//    o	Description min length must be minimum 5(inclusive) characters
//•	Has a Progress (unique)
//    o	Option between (OPEN, IN_PROGRESS, COMPLETED, OTHER)
//•	Has a Due Date
//    o	A date, that cannot be in the past
//•	Has a Classification
//    o	Classification cannot be null.
//            •	Has a User
//    o	Cannot be null.
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private ProgressEnum progress;
    @Column(nullable = false)
    private LocalDate dueDate;
    @ManyToOne
    private ClassificationEntity classification;
    @ManyToOne
    private UserEntity assignedTo;

    public TaskEntity() {
    }

    public UserEntity getAssignedTo() {
        return assignedTo;
    }

    public TaskEntity setAssignedTo(UserEntity assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskEntity setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskEntity setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public TaskEntity setClassification(ClassificationEntity classification) {
        this.classification = classification;
        return this;
    }
}
