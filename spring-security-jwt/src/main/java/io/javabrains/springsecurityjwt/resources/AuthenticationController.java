package io.javabrains.springsecurityjwt.resources;

import io.javabrains.springsecurityjwt.model.AuthenticationRequest;
import io.javabrains.springsecurityjwt.model.AuthenticationResponse;
import io.javabrains.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService customUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password");
        }


        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt);
        return ResponseEntity.ok(authenticationResponse);


    }
}
