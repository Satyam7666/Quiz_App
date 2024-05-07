package com.quiz.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String userName);


}
