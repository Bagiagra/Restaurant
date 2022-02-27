package by.overone.demo.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Order{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer orderId;

    @Column(name = "date")
    public String orderDate;

    @Column(name = "order_status")
    public String orderStatus;

    @Column(name = "amount")
    public double amount;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="payments_id")
    public Payment orderPayment;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "users_id")
    public User user;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "orders_has_dishers",
                joinColumns = @JoinColumn(name="orders_id"),
    inverseJoinColumns = @JoinColumn(name="dishers_id"))
    public List <Dish> dish;



    public Order() {
    }

      public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() && Double.compare(order.getAmount(), getAmount()) == 0 && Objects.equals(getOrderDate(), order.getOrderDate()) && Objects.equals(getOrderStatus(), order.getOrderStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getOrderDate(), getOrderStatus(), getAmount());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", amount=" + amount +
                '}';
    }
}