package com.quiz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.quiz.dto.UserDto;
import com.quiz.entity.Role;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;
import com.quiz.repo.RoleRepository;
import com.quiz.service.UserService;
import com.quiz.util.UserConverter;

import io.jsonwebtoken.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserConverter userConverter;
    
    @Autowired
    private RoleRepository roleRepository;
    
    

    //creating User
    @PostMapping("/")

    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto
    		) throws Exception {
   
    	
    	
    userDto.setProfile("profile.jpg");
    
    	    // encoding password
    	    userDto.setPassword(this.bCryptPasswordEncoder.encode(userDto.getPassword()));

    	    Set<UserRole> roles = new HashSet<>();

    	    Role role = new Role();
    	    role.setRoleId(45L);
    	    role.setRoleName("NORMAL");

    	    UserRole userRole = new UserRole();
    	    userRole.setRole(role);
    	    roles.add(userRole);

    	    // Save the User instance first
    	    User user = this.userConverter.convertToUser(userDto);
    	    System.out.println("controller"+userDto);
    	    System.out.println("controller"+roles);
    	    UserDto savedUser = this.userService.createUser(userDto, roles);

  	    // Set the saved User instance in UserRole and save UserRole
    	    userRole.setUser(user);
    	//    this.userService.(userRole);
       
    	    return new ResponseEntity<UserDto>(this.userConverter.convertToUserDto(user),HttpStatus.OK);
    	

    }
    @GetMapping("/{userName}")
    public  ResponseEntity<UserDto> getUser(@PathVariable("userName") String userName){

        return new ResponseEntity<UserDto>(this.userService.getUser(userName),HttpStatus.OK);

    }

    //delete controller
    @DeleteMapping("/{id}")
    public  ResponseEntity<String>  deleteUser(@PathVariable("id") long id){
        this.userService.deleteUser(id);
        return new ResponseEntity<String>("User Deleted Succesfuuly",HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody UserDto userDto){
    	UserDto updateUser = this.userService.updateUser(id, userDto);
    	
    	return ResponseEntity.ok(updateUser);
    }
}
