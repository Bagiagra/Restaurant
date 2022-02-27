package by.overone.demo.repository;

import by.overone.demo.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepo implements IUserRepo{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        return entityManager.unwrap(Session.class)
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User findById(int userId){
        return entityManager.unwrap(Session.class).get(User.class, userId);
    }

    @Override
    public void create(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }

    @Override
    public void delete(int userId){
        entityManager.unwrap(Session.class)
                .createQuery("delete from User where id=userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }
}
