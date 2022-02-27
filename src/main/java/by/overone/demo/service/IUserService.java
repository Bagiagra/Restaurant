package by.overone.demo.service;

import by.overone.demo.entity.User;

import java.util.List;


public interface IUserService {


    List<User> findAll();

    User findById(int userId);

    void create (User user);

    void delete (int userId);

}

