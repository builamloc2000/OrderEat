package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.serviceImpl.AccountServiceImpl;
import com.example.orderEat.application.service.webtoken.JwtService;
import com.example.orderEat.application.service.webtoken.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountServiceImpl accountService;

    //check authorize for all role
    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }
    //check user homepage authorize
    @GetMapping("/user/home")
    public String handleUserHome() {
        return "home_user";
    }
    //check shipper homepage authorize
    @GetMapping("/shipper/home")
    public String handleShipperHome() {
        return "home_shipper";
    }
    //authenticate user to get jwt token
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.username(), loginForm.password()
        ));
        if(authentication.isAuthenticated()){
           return jwtService.generateToken(accountService.loadUserByUsername(loginForm.username()));
        }else{
            throw new UsernameNotFoundException("Invalid");
        }
    }
}
