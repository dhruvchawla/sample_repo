package com.bluedart.security;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider
  implements AuthenticationProvider {
	
	@Autowired
    private UserService userService;
 
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
    	User user = null;
        String username = null;
        String password = null;
        
        try{
        	username = authentication.getName();
        	password = SecurityEncryption.decrypt(authentication.getCredentials().toString());
        }
        catch(Exception e) {
        	throw new BadCredentialsException("Invalid token from service.");
        }
        	user = userService.loadUserByUsername(username +":"+password);

        	if(user != null) {
        	Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        	 
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        } else {
        	throw new BadCredentialsException("Invalid token from service.");
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}
