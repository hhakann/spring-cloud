package com.datagenerator.authservice.repository;

import com.datagenerator.authservice.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByEmail(String email);

    List<User> findAllByDeletedAtIsNull();

    Optional<User> findAllByEmailAndDeletedAtIsNull(String email);

    Optional<User> findAllByIdAndDeletedAtIsNull(Long id);
}
