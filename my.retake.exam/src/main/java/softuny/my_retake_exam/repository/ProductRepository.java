package softuny.my_retake_exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuny.my_retake_exam.model.entity.ProductEntity;
import softuny.my_retake_exam.model.entity.enums.CategoryName;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  List<ProductEntity> findByCategory_Name(CategoryName categoryName);
}
