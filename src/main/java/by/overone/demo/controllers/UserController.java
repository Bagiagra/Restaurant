package by.overone.demo.controllers;

import by.overone.demo.entity.User;
import by.overone.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired IUserService userService;

    @GetMapping("")
    public String findAll(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("user", user);
        return "all_users";
    }






     /*
            (@Valid @ModelAttribute("userName") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }

        return "main";
    }
*/

}
