package com.quiz.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.UserDto;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;

import com.quiz.exception.UserNotFoundException;
import com.quiz.repo.RoleRepository;
import com.quiz.repo.UserRepository;
import com.quiz.service.UserService;
import com.quiz.util.UserConverter;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserConverter userConverter;


    @Override
    public UserDto createUser(UserDto userDto, Set<UserRole> userRoles) throws Exception {

       User local= this.userRepository.findByUsername(userDto.getUsername());
       if(local !=null){

           System.out.println("User is alredy there");

           throw new  UserNotFoundException("User is alredy Present");

       }else {
           //create user
           for(UserRole ur:userRoles){
               roleRepository.save(ur.getRole());
           }
          User user = this.userConverter.convertToUser(userDto);
          
          
//           System.out.println(user);
//           user.getUserRoles().addAll(userRoles);
//           
//           System.out.println(userRoles);
//           System.out.println(user);
//           local = this.userRepository.save(user);
//           System.out.println(local);
           
           for (UserRole ur : userRoles) {
        	    ur.setUser(user);
        	}

        	// Add userRoles to the user
        	user.getUserRoles().addAll(userRoles);

        	local = this.userRepository.save(user);


      }
        return this.userConverter.convertToUserDto(local);
    	
    	
    	 

       
    }

    @Override
    public UserDto getUser(String userName) {
         User user = this.userRepository.findByUsername(userName);
         System.out.println(user);
         if(user != null) {
 			 UserDto userDto = this.userConverter.convertToUserDto(user);
 			 System.out.println("user Dto"+userDto);
 			 return userDto;
 		}else {
 		throw new UserNotFoundException("user With "+userName+" username is not present");
 		}
        
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.findById(id).orElseThrow(()-> new  UserNotFoundException("User With id "+id+" is Not present"));
    }

	@Override
	public UserDto updateUser(Long id  ,UserDto userDto) {
		// TODO Auto-generated method stub
		User updateUser=	this.userRepository.findById(id).orElseThrow(()-> new  UserNotFoundException("User With id "+id+" is Not present"));
		
		updateUser.setFirstName(userDto.getFirstName());
		updateUser.setLastName(userDto.getLastName());
		updateUser.setEmail(userDto.getEmail());
		updateUser.setPhone(userDto.getPhone());
		 User saveUser = this.userRepository.save(updateUser);
		
		
		return this.userConverter.convertToUserDto(saveUser);
	}
}
