package bz.sunlight.SpringJpaDemo.service;

import bz.sunlight.SpringJpaDemo.bean.User;

import java.util.List;

/**
 * UserService
 * Created by chen_yong on 2017/6/1.
 */
public interface UserService {

    void saveUser(User user);

    User findOne(int id);

    void deleteOne(int id);

    void updateUser(int id, String address);

    List<User> findAll();

    List<User> findByName(String name);
}
