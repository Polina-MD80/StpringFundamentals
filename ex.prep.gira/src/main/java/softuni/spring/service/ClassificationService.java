package softuni.spring.service;

import softuni.spring.model.entity.ClassificationEntity;
import softuni.spring.model.entity.enums.ClassificationNameEnum;

public interface ClassificationService {
    void initializeClassifications();


    ClassificationEntity findBy(ClassificationNameEnum classification);
}
