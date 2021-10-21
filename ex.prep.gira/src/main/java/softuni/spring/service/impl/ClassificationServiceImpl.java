package softuni.spring.service.impl;

import org.springframework.stereotype.Service;
import softuni.spring.model.entity.ClassificationEntity;
import softuni.spring.model.entity.enums.ClassificationNameEnum;
import softuni.spring.service.ClassificationService;
import softuni.spring.repository.ClassificationRepository;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initializeClassifications() {
        if (classificationRepository.count()==0){
            classificationRepository.save(new ClassificationEntity("This is a bug", ClassificationNameEnum.BUG));
            classificationRepository.save(new ClassificationEntity("This is a feature", ClassificationNameEnum.FEATURE));
            classificationRepository.save(new ClassificationEntity("This is a support", ClassificationNameEnum.SUPPORT));
            classificationRepository.save(new ClassificationEntity("This is a other", ClassificationNameEnum.OTHER));
        }
    }

    @Override
    public ClassificationEntity findBy(ClassificationNameEnum classification) {
        return classificationRepository.findByClassificationName(classification).orElse(null);
    }
}
