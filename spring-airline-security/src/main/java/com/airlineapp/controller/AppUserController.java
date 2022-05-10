package com.airlineapp.controller;

import com.airlineapp.model.AppUser;
import com.airlineapp.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    private IAppUserService appUserService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAppUserService(IAppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @PostMapping("/")
    public void addUser(@RequestBody AppUser appUser){
        String username= appUser.getUsername();
        String password= appUser.getPassword();
        //encode the password before saving it to db
        String encodePassword=passwordEncoder.encode(password);
        AppUser appUser1=new AppUser(username,encodePassword);
        appUserService.addUser(appUser1);
    }
}
