package by.overone.demo.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer paymentId;

    @Column(name = "date")
    public String paymentDate;

    @Column(name = "amount")
    public double paymentAmount;

   @OneToOne(mappedBy = "orderPayment", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Order order;

    public Payment() {
    }

    public Payment(int paymentId, String paymentDate, double paymentAmount) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getPaymentId() == payment.getPaymentId() && Double.compare(payment.getPaymentAmount(), getPaymentAmount()) == 0 && Objects.equals(getPaymentDate(), payment.getPaymentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getPaymentDate(), getPaymentAmount());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
