package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.spring.model.entity.ProductEntity;
import softuni.spring.model.entity.enums.CategoryName;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  List<ProductEntity> findByCategory_Name(CategoryName categoryName);
}
