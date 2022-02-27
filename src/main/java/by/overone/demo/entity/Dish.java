package by.overone.demo.entity;


import by.overone.demo.entity.Enum.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="dishers")
public class Dish {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer dishId;

    @Column(name="type")
    @Enumerated (EnumType.STRING)
    public Type type;

    @Column(name="name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public double price;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "orders_has_dishers",
            joinColumns = @JoinColumn(name = "dishers_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    public List<Order> order;

    public Dish() {
    }

    public Dish(Type type, String name, String description, double price) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Dish(int dishId, Type type, String name, String description, double price) {
        this.dishId = dishId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return getDishId() == dish.getDishId() && Double.compare(dish.getPrice(), getPrice()) == 0 && getType() == dish.getType() && Objects.equals(getName(), dish.getName()) && Objects.equals(getDescription(), dish.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDishId(), getType(), getName(), getDescription(), getPrice());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
