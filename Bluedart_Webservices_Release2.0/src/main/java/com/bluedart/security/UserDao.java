package com.bluedart.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
 
    public User loadUserByUsername(final String userinfo) {
        User user = new User();
        List<Role> roles = new ArrayList<Role>();
        String username = userinfo.substring(0, userinfo.indexOf(":"));
		String password = userinfo.substring(userinfo.indexOf(":")+1);
        if(UserConstants.USERTYPE_GUEST.equals(username) && UserConstants.USER_GUEST_PASSWORD.equals(password)) {
        	Role r = new Role();
        	r.setName(UserConstants.USER_GUESTROLE);
        	roles.add(r);
        }
        else if(UserConstants.USERTYPE_ADMIN.equals(username) && UserConstants.USER_ADMIN_PASSWORD.equals(password)) {
        	Role r = new Role();
        	r.setName(UserConstants.USER_ADMINROLE);
        	roles.add(r);
        }
        else if(UserConstants.USERTYPE_CORPORATE.equals(username) && UserConstants.USER_CORPORATE_PASSWORD.equals(password)) {
        	Role r = new Role();
        	r.setName(UserConstants.USER_CORPORATEROLE);
        	roles.add(r);
        }
        else if(UserConstants.USERTYPE_POD.equals(username) && UserConstants.USER_POD_PASSWORD.equals(password)) {
        	Role r = new Role();
        	r.setName(UserConstants.USER_PODROLE);
        	roles.add(r);
        }
        else if(UserConstants.USERTYPE_SUPERADMIN.equals(username) && UserConstants.SUPERADMIN_PASSWORD.equals(password)) {
        	Role r = new Role();
        	r.setName(UserConstants.USER_SUPERADMINROLE);
        	roles.add(r);
        }
        else {
        	
        }
        if(roles.size() == 0) {
        	user = null;
        }
        else {
        	user.setAuthorities(roles);
        }
    
       /* Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        user.setAuthorities(roles);*/
        return user;
    }
}