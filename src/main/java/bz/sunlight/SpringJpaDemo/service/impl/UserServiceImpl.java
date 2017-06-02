package bz.sunlight.SpringJpaDemo.service.impl;

import bz.sunlight.SpringJpaDemo.bean.User;
import bz.sunlight.SpringJpaDemo.repository.UserRepository;
import bz.sunlight.SpringJpaDemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl
 * Created by chen_yong on 2017/6/1.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void deleteOne(int id) {
        userRepository.delete(id);
    }

    @Override
    public void updateUser(int id, String address) {
        userRepository.findByUpdateUser(id, address);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
