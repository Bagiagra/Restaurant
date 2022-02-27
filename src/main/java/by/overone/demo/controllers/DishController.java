package by.overone.demo.controllers;

import by.overone.demo.entity.Dish;
import by.overone.demo.repository.IDishRepo;
import by.overone.demo.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dish")
public class DishController {


    @Autowired
    private IDishService dishService;

    @GetMapping("")
    public String findAll(Model model) {
        List<Dish> dish = dishService.findAll();
        model.addAttribute("dish", dish);
        return "all_dish";
    }

        @GetMapping("/addDish")
        public String addDishPage(Model model){
        Dish dish = new Dish();
        model.addAttribute("dish", dish);
        return "dish_info";
    }

        @PostMapping ("/saveDish")
        public String create(@ModelAttribute(name="dish") Dish dish) {
        dishService.create(dish);
        return "redirect:/dish";
        }

        @GetMapping("/updateInfo")
        public String updateDish(@RequestParam(name="dishId") int dishId, Model model){
        Dish dish = dishService.findById(dishId);
        model.addAttribute("dish", dish);
        return "dish_info";
        }

        @GetMapping("/deleteDish")
        public String delete(@RequestParam(name="dishId") int dishId){
        dishService.delete(dishId);
        return "redirect:/dish";
        }
}
