package by.overone.demo.repository;

import by.overone.demo.entity.User;

import java.util.List;

public interface IUserRepo {

    List<User> findAll();

    User findById(int userId);

    void create (User user);

    void delete (int userId);




}
