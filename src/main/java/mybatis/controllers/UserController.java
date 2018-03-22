package mybatis.controllers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import mybatis.model.Greeting;
import mybatis.model.User;
import mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    //RequestMapping maps URLs to methods

    //Get
    @RequestMapping("/")
    public ArrayList<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public User getById(@PathVariable(value="id")int id) {
        return userService.getById(id);
    }

    @RequestMapping("/manual")
    public ArrayList<User> getUsersManually() {
        //write the necessary code to get all users and return
        //them in json to the browser without using mybatis
        return userService.getAllUsersManually();
    }

    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public User addNew(@RequestBody User user) {
        return userService.addNew(user);
    }

    //Update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public User updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    //Delete
    @RequestMapping(method= RequestMethod.DELETE, value="/")
    public User deleteById(@RequestParam(value="id")int id){
        return userService.deleteById(id);
    }
}
