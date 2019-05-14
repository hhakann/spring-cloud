package com.datagenerator.authservice.service;

import com.datagenerator.authservice.model.User;
import com.datagenerator.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id){

        return userRepository.findById(id);
    }
    public User save(User user){
      return userRepository.save(user);
    }

    public void softDelete(Long id){
        User foundUser=userRepository.findAllByIdAndDeletedAtIsNull(id).orElse(null);
        if(nonNull(foundUser)){
            foundUser.setDeletedAt(LocalDateTime.now());
            userRepository.save(foundUser);
        }else{
            throw new NullPointerException( id+" id user not found");
        }

    }
    public void hardDelete(Long id){
        User foundUser=userRepository.findById(id).orElse(null);
        if(nonNull(foundUser)){
            foundUser.setDeletedAt(LocalDateTime.now());
            userRepository.delete(foundUser);
        }else{
            throw new NullPointerException( id+" id user not found");
        }
    }

    public Optional<User> findByEmailAndDeletedAtIsNull(String email){

        return userRepository.findAllByEmailAndDeletedAtIsNull(email);

    }
    public List<User> findAllByDeletedAtIsNull(){
        return userRepository.findAllByDeletedAtIsNull();
    }

    public Optional<User> findAllByIdAndDeletedAtIsNull(Long id){
        return userRepository.findAllByIdAndDeletedAtIsNull(id);
    }
}
