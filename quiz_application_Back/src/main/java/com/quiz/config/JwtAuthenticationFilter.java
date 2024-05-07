package com.quiz.config;


import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.quiz.service.impl.UserDetailServiceImpl;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtils jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      final   String requestTokenHeader = request.getHeader("Authorization");
        System.out.println(requestTokenHeader);
        String userName=null;
        String jwtToken=null;

        if(requestTokenHeader !=null && requestTokenHeader.startsWith("Bearer")){

            jwtToken = requestTokenHeader.substring(7);

            try{
                userName = this.jwtUtil.extractUsername(jwtToken);
            }catch (ExpiredJwtException e){
                e.printStackTrace();
                System.out.println("Jwt token has expired");

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error");
            }

        }else {
            System.out.println("Invalid Token ,Not start with bearer string");
        }


        //validate

        if (userName !=null && SecurityContextHolder.getContext().getAuthentication()==null){
           final UserDetails userDetails = this.userDetailService.loadUserByUsername(userName);

           if (this.jwtUtil.validateToken(jwtToken,userDetails)) {
               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

               SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }
        }else {
            System.out.println("Token is not valid");
        }

        filterChain.doFilter(request,response);

    }
}
