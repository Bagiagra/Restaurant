package by.overone.demo.controllers;


import by.overone.demo.entity.User;
//import by.overone.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {

    /*@Autowired
    public UserRepo userRepo;*/

    @GetMapping("/")
    public String mainForAll(
            @RequestParam(name = "name", required = false, defaultValue = "Гость") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        return "main";
    }
}


