package com.quiz.dto;



import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.quiz.entity.UserRole;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class UserDto {
	
	
	    private long userId;
	    @NotBlank(message="UserName cannot be blank!!")
	    private  String username;
	    @NotBlank(message="User Password cannot be blank!!")
	    private String password;
	    @NotBlank(message="User first Name cannot be blank!!")
	    private String firstName;
	    @NotBlank(message="User last Name cannot be blank!!")
	    private String lastName;
	    @NotBlank(message="User Email cannot be blank!!")
		@Email(message="Email id is not proper!!")
	    private String email;

	    private String phone;
	    private  boolean enable=true;
	    
	    private String profile;
	    
	    private Set<UserRole> userRoles=new HashSet<>();


}
