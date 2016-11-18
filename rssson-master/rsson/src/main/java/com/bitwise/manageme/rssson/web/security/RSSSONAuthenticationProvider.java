package com.bitwise.manageme.rssson.web.security;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class RSSSONAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private CredentialValidation credentialValidation;
	
	@Autowired
	private RSSSONUserContext userContext;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
		User systemUser;
		if (token.getPrincipal() instanceof User) {
			systemUser = (User) token.getPrincipal();
		} else {
			systemUser = credentialValidation.validateUsernameAndPassword(token.getName(), (CharSequence) token.getCredentials());
		}
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (com.bitwise.manageme.rssson.domain.security.Role role : systemUser.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleType()));
		}
		userContext.setCurrentUser(systemUser);
		return new UsernamePasswordAuthenticationToken(systemUser.getUsername(), systemUser.getPassword(), grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> auth) {
		return UsernamePasswordAuthenticationToken.class.equals(auth);
	}

}
