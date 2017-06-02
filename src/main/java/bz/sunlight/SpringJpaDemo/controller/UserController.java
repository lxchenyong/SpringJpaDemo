package bz.sunlight.SpringJpaDemo.controller;

import bz.sunlight.SpringJpaDemo.bean.User;
import bz.sunlight.SpringJpaDemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * UserController 相当于API
 * Created by chen_yong on 2017/6/1.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService service) {
        this.userService = service;

    }

    @RequestMapping(value = "/create/user",method = RequestMethod.GET)
    public void create() {

//        return "创建成功";
    }

    /**
     * @param name    名字
     * @param address 地址
     * @return 添加user
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add/{name}/{address}")
    public User addUser(@PathVariable String name, @PathVariable String address) {
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        userService.saveUser(user);
        return user;
    }

    /**
     * @param id userId
     * @return 根据id查询User
     */
    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.findOne(id);
    }

//    @ExceptionHandler(value = {Exception.class})
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
////    @ResponseBody
//    public String constraintViolationException(Exception ex) {
////        ex.printStackTrace();
//        return "exception info....."+ex.getMessage();
//    }
    /**
     * 根据userID删除user
     *
     * @param id userID
     */
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteOne(id);
        return "删除成功";
    }


    /**
     * 根据id修改数据
     *
     * @param id      userID
     * @param address 地址
     */
    @RequestMapping("/update/{id}/address/{address}")
    public String update(@PathVariable int id, @PathVariable String address) {
        userService.updateUser(id, address);

        return "修改成功";
    }

    /**
     * @return 查询所有的User
     */
    @RequestMapping("/All")
    public List<User> getUsers() {

        return userService.findAll();
    }

    /**
     * @param name 名字
     * @return 根据名字查询出所有User
     */
    @RequestMapping("/search/name/{name}")
    public List<User> getUsers(@PathVariable String name) {
        return userService.findByName(name);
    }
}
