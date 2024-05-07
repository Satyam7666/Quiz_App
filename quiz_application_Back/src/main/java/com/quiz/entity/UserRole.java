package com.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRoleId;
@ManyToOne(fetch = FetchType.EAGER)
    private  User user;
@ManyToOne(fetch = FetchType.EAGER)
private Role role;
public UserRole(int userRoleId, User user, Role role) {
	super();
	this.userRoleId = userRoleId;
	this.user = user;
	this.role = role;
}
public UserRole() {
	super();
	// TODO Auto-generated constructor stub
}
public int getUserRoleId() {
	return userRoleId;
}
public void setUserRoleId(int userRoleId) {
	this.userRoleId = userRoleId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@Override
public String toString() {
	return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
}







   
}
