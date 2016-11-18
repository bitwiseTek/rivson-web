package com.bitwise.manageme.rssson.web.controller;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
		
		@RequestMapping(value = "/users/login", method = RequestMethod.GET)
		public String logIn(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout, HttpSession session,
				HttpServletRequest request, ModelMap model) {
			{
				CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
				if (token != null) {
					model.addAttribute("csrfParameterName", token.getParameterName());
					model.addAttribute("csrfToken", token.getToken());
				}
				return "login";
			}
		}
		
		@RequestMapping(value="/users/logout", method=RequestMethod.GET)
		public String logOut(HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return "redirect:/users/login?logout";
		}
}
