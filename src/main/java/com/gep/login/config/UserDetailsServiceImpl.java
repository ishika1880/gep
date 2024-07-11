
package com.gep.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gep.login.dao.LoginRepository;
import com.gep.login.entities.UserLogin;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserLogin user=loginRepository.getUserByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("could not found user");
		}
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
		return customUserDetails;
	}

}
