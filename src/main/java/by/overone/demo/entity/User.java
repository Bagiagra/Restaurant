package by.overone.demo.entity;


import by.overone.demo.entity.Enum.Role;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer userId;

    @Column(name="name")
    @Size(min=4, max=10, message = "name invalid, need more than 3 and less than 10 characters")
    public String name;

    @Column(name="e-mail")
    public String email;

    @Column(name="password")
    public String password;

    @Column(name="balance")
    public double balance;

    @Column(name="role")
    @Enumerated (EnumType.STRING)
    public Role role;

    @OneToMany(mappedBy = "user", cascade={CascadeType.MERGE, CascadeType.REFRESH})
    public List <Order> order;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int userId, String name, String email, String password, double balance, Role role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public User(Integer userId, String name, String email, double balance, Role role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && Double.compare(user.getBalance(), getBalance()) == 0 && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getEmail(), getPassword(), getBalance(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", role=" + role +
                '}';
    }


}
