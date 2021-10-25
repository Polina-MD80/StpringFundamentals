package softuni.spring.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseUser() {
    }

    public Long getId() {
        return id;
    }

    public BaseUser setId(Long id) {
        this.id = id;
        return this;
    }
}
