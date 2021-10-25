package softuni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.spring.model.entity.ShipEntity;
import softuni.spring.model.entity.UserEntity;

import java.util.List;

public interface ShipRepository extends JpaRepository<ShipEntity,Long > {
   @Query("select  s from ShipEntity s order by s.health , s.power, s.id")
    List<ShipEntity> findAll();

   List<ShipEntity> findAllByUser(UserEntity user);

   List<ShipEntity> findAllByUserNot(UserEntity user);

   ShipEntity findByName(String name);

}
