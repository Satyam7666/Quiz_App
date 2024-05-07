package com.quiz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.quiz.config.JwtUtils;
import com.quiz.entity.JwtRequest;
import com.quiz.entity.JwtRespone;
import com.quiz.entity.User;
import com.quiz.service.impl.UserDetailServiceImpl;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtils jwtUtils;

    //generate Token

@PostMapping("generate-token")
@CrossOrigin("*")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
try{

    authenticate(jwtRequest.getUserName(),jwtRequest.getPassword());

}catch (UsernameNotFoundException e){
  e.printStackTrace();
    throw  new Exception("User not found");
}

    UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUserName());
    String token = this.jwtUtils.generateToken(userDetails);
    return ResponseEntity.ok(new JwtRespone(token));


}


    private void authenticate(String userName,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));

        }catch (DisabledException e){
            throw  new Exception("USER DISABLE" +e.getMessage());

        }catch (BadCredentialsException e){
            throw new Exception("INVALID CREDENTIAL "+e.getMessage());

        }

    }
//return the details of current user
    
@GetMapping("/current-user")
    public User getCureentUser(Principal principal){
    return  ((User) this.userDetailService.loadUserByUsername(principal.getName()));
    }

}
