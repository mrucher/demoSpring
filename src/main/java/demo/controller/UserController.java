package demo.controller;

import demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping(
            value = "/addUser", consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) throws Exception {
        System.out.println(user.getfirstname());
        userService.save(user);
        return user;
    }

    @GetMapping(
            value = "/getUsers")
    public List<User> getUsers() throws Exception {

        return userService.getUsers();
    }
}