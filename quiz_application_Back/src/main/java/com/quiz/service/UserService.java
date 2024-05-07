package com.quiz.service;


import java.util.Set;

import com.quiz.dto.UserDto;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;

public interface UserService {
    public UserDto createUser(UserDto userDto, Set<UserRole> userRoles) throws Exception;

    //get user by Username
    public UserDto getUser(String userName);

    //delete user by id
    public  void  deleteUser(long id);
    
    public UserDto updateUser(Long id,  UserDto userDto);
}
