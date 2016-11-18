package com.bitwise.manageme.rssson.web.security;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class RSSSONUserContext {

	public User getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication auth = securityContext.getAuthentication();
		if (auth == null || auth.getPrincipal() == null || auth.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		return (User) auth.getPrincipal();
	}
	
	public void setCurrentUser(User user) {
		Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
