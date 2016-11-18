package com.bitwise.manageme.rssson.web.security;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.service.users.UserService;
import com.bitwise.manageme.rssson.web.exception.AccountLockedException;

@Service("rsssonUserDetailsService")
public class RSSSONUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService authService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isBlank(username)) {
			throw new UsernameNotFoundException("Username was empty");
		}
		
		User systemUser = authService.getAccount(username);
		
		if (systemUser == null) {
			throw new UsernameNotFoundException(String.format("User with Username %s does not exist", username));
		}
		
		if (!systemUser.isActive()) {
			try {
				throw new AccountLockedException("User Account is locked", "validation.user.locked");
			} catch (AccountLockedException e) {
				e.printStackTrace();
			}
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (com.bitwise.manageme.rssson.domain.security.Role role : systemUser.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleType()));
		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(systemUser.getUsername(), systemUser.getPassword(), grantedAuthorities);
		return userDetails;
	}

}
