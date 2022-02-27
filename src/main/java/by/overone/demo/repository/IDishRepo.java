package by.overone.demo.repository;

import by.overone.demo.entity.Dish;

import java.util.List;

public interface IDishRepo {

        List<Dish> findAll();

        Dish findById(int dishId);

        void create (Dish dish);

        void delete (int dishId);

}
