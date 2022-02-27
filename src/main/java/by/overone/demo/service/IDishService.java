package by.overone.demo.service;

import by.overone.demo.entity.Dish;

import java.util.List;
import java.util.Optional;

public interface IDishService {

    List<Dish> findAll();

    Dish findById(int dishId);

    void create (Dish dish);

    void delete (int dishId);

}
