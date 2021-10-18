package softuni.spring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    //    •	Has a Name
//    o	The length of the name must be between 3 and 20 characters (both numbers are INCLUSIVE).
//            •	Has a Price
//    o	The price must be a positive number
//•	Has an Order time
//    o	The date and time that cannot be in the future
//•	Has a Category
//    o	Has ONLY ONE category
//    o	This is the relation with categories.
//•	Has a Description
//    o	The length of the description must be at least 5 (INCLUSIVE) characters
//    o	The description is a long text field.
//•	Has a Employee (user)
//    o	A user that adds this order to the Coffee Shop application
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDateTime time;
    @ManyToOne
    private CategoryEntity category;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String description;
    @ManyToOne
    private UserEntity employee;

    public OrderEntity() {
    }

    public String getName() {
        return name;
    }

    public OrderEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public OrderEntity setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public OrderEntity setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
