package by.overone.demo.repository;

import by.overone.demo.entity.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DishRepo implements IDishRepo{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Dish> findAll(){
        return entityManager.unwrap(Session.class)
                .createQuery("from Dish", Dish.class)
                .getResultList();
    }

    @Override
    public Dish findById(int dishId){
        return entityManager.unwrap(Session.class).get(Dish.class, dishId);
    }

    @Override
    public void create(Dish dish) {
        entityManager.unwrap(Session.class).saveOrUpdate(dish);
    }

    @Override
    public void delete(int dishId){
        entityManager.unwrap(Session.class)
                .createQuery("delete from Dish where id=dishId")
                .setParameter("dishId", dishId)
                .executeUpdate();
    }
}
