package com.airlineapp.config;


import com.airlineapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //get the header with name authorization from request
        String headerValue = request.getHeader("Authorization");
        String jwtToken = null;
        String username = null;
        //check if the header is not null and starts with Bearer
        if (headerValue != null && headerValue.startsWith("Bearer")) {
            // Bearer ebjask32oewemew.asdkhadjhajsd.askdkjhajkd21
            jwtToken = headerValue.substring(7);
            //get usernamde from the token
            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        } else
            logger.warn("Invalid header");
        // if th username is not null and the security context is not null
        // then specify the type of authentication
        if (username != null && SecurityContextHolder.getContext() != null) {
            //check if the username is available in the db
            UserDetails details = userDetailsService.loadUserByUsername(username);
            List<GrantedAuthority> authorities= Arrays.asList(
                    new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("User"));
            //configure the authenication type
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(details.getUsername(),null,authorities);
            //set the authentication type
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //see the authentication for the security context
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        //no header means move to the next filter and then to Ds
        filterChain.doFilter(request, response);
    }
}
