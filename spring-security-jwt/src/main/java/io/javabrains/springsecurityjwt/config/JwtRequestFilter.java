package io.javabrains.springsecurityjwt.config;

import io.javabrains.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    UserDetailsService cusUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String jwt=null;
        String userName=null;
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            userName=jwtUtil.extractUsername(jwt);
        }

        if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = cusUserDetailsService.loadUserByUsername(userName);
            if(jwtUtil.validateToken(jwt,userDetails)){
                Object userDetails1;
                Object principal;
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);




    }
}
