package by.overone.demo.service;

import by.overone.demo.entity.Dish;
import by.overone.demo.entity.User;
import by.overone.demo.exceptions.UserNoFoundException;
import by.overone.demo.repository.IUserRepo;
import by.overone.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional
    public List<User> findAll(){
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public User findById(int userId){
        User user = userRepo.findById(userId);
        if (user == null){
            throw new UserNoFoundException("Пользователь c ID=" + userId + "не существует");
        }
        return userRepo.findById(userId);
    };

    @Override
    @Transactional
    public void create(User user){
        userRepo.create(user);
    };

    @Override
    @Transactional
    public void delete(int userId){
        userRepo.delete(userId);
    };

}
