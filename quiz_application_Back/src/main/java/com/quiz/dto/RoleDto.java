package com.quiz.dto;

import java.util.HashSet;
import java.util.Set;

import com.quiz.entity.UserRole;

import jakarta.persistence.Id;
import lombok.Data;
@Data
public class RoleDto {
	  
	    private long roleId;
	    private String roleName;
	    private Set<UserRole> userRoles=new HashSet<>();

}
