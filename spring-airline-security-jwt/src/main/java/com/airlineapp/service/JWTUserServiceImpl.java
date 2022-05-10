package com.airlineapp.service;

import com.airlineapp.model.JWTUser;
import com.airlineapp.repository.IJWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTUserServiceImpl implements UserDetailsService {
    @Autowired
    private IJWTUserRepository ijwtUserRepository;
    public void addUser(JWTUser user){
        ijwtUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       JWTUser user=ijwtUserRepository.findByUsername(username);
       if(user==null)
           throw  new UsernameNotFoundException("invalid username");
       //create ythe roles and authorities
        List<GrantedAuthority> authorities= Arrays.asList(
                new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("User"));

        //create inbuit user object using the data
       UserDetails userDetails=new User(user.getUsername(),user.getPassword(),authorities);
        return userDetails;
    }


}
