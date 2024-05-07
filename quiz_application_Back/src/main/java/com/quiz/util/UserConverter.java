package com.quiz.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz.dto.UserDto;
import com.quiz.entity.User;

@Component
public class UserConverter {
	
	//convert User to USerDto
		public UserDto convertToUserDto(User user) {
			UserDto userDto=new UserDto();
			
			if(user!=null) {
				BeanUtils.copyProperties(user, userDto);
			}
			return userDto;
		}
		
		//convert UserDto to USer
			public User convertToUser(UserDto userDto) {
				User user=new User();
				
				if(userDto!=null) {
					BeanUtils.copyProperties(userDto, user);
					
				}
				return user;
			}

}
