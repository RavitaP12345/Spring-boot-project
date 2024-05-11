package com.example.springsecurityexample.resources;

import com.example.springsecurityexample.models.JwtRequest;
import com.example.springsecurityexample.models.JwtResponse;
import com.example.springsecurityexample.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class AuthResource {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login (@RequestBody JwtRequest jwtRequest){
        this.doAuthenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
        String token = this.jwtHelper.generateToken(userDetails);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        try{
            authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException e){
            throw new RuntimeException("Invalid username or password. !!");
        }

    }
}
