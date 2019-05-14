package com.datagenerator.authservice.controller;

import com.datagenerator.authservice.model.User;
import com.datagenerator.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public User get(@PathVariable("id") Long id){
        Optional<User> user=userService.findAllByIdAndDeletedAtIsNull(id);
        return user.get();
    }

    @PostMapping
    public User saveUser(@Valid @RequestBody User user){
        return userService.save(user);
    }
    @DeleteMapping(path = "{id}")
    public Map<String,Object> delete(@PathVariable("id") Long id){
        userService.softDelete(id);
        Map<String,Object> success=new HashMap<>();
        success.put("status","true");
        return success;
    }
    @DeleteMapping(path = "{id}/hard")
    public Map<String,Object> hardDelete(@PathVariable("id") Long id){
        userService.hardDelete(id);
        Map<String,Object> success=new HashMap<>();
        success.put("status","true");
        return success;
    }


}
