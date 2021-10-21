package softuni.spring.model.entity;

import softuni.spring.model.entity.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class ClassificationEntity extends BaseEntity{
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private ClassificationNameEnum classificationName;

    public ClassificationEntity() {
    }

    public ClassificationEntity(String description, ClassificationNameEnum classificationName) {
        this.description = description;
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return description;
    }

    public ClassificationEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public ClassificationEntity setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }
}
