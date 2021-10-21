package softuni.spring.model.view;

import softuni.spring.model.entity.ClassificationEntity;
import softuni.spring.model.entity.UserEntity;
import softuni.spring.model.entity.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {
    private Long id;
    private String name;
    private UserEntity assignedTo;
    private ClassificationEntity classification;
    private LocalDate dueDate;
    private ProgressEnum progress;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public UserEntity getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(UserEntity assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationEntity classification) {
        this.classification = classification;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }
}
