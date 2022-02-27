package by.overone.demo.service;

import by.overone.demo.entity.Dish;
import by.overone.demo.entity.User;
import by.overone.demo.exceptions.DishNoFoundException;
import by.overone.demo.repository.IDishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DishService implements IDishService {

    @Autowired
    private IDishRepo dishRepo;

    @Override
    @Transactional
    public List<Dish> findAll(){
        return dishRepo.findAll();
    }

    @Override
    @Transactional
    public Dish findById(int dishId){
        Dish dish = dishRepo.findById(dishId);
        if (dish == null){
            throw new DishNoFoundException("Блюдо c ID=" + dishId + "не существует");
        }
       return dishRepo.findById(dishId);
    };

    @Override
    @Transactional
    public void create(Dish dish){
        dishRepo.create(dish);
    };

    @Override
    @Transactional
    public void delete(int dishId){
        dishRepo.delete(dishId);
    };
}
