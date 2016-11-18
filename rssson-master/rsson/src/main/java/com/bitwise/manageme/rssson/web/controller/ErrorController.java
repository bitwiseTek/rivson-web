package com.bitwise.manageme.rssson.web.controller;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	
	@RequestMapping(value="/accessdenied", method=RequestMethod.GET)
	public ModelAndView requestAccessDeniedPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("accessdenied");
		return mav;
	}
	
	@RequestMapping(value="/defaulterror", method=RequestMethod.GET)
	public ModelAndView requestErrorPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("defaulterror");
		return mav;
	}
	
	@RequestMapping(value="/resourceNotFound", method=RequestMethod.GET)
	public ModelAndView requestResourceNotFoundPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("resourceNotFound");
		return mav;
	}
	
	@RequestMapping(value="/dataAccessFailure", method=RequestMethod.GET)
	public ModelAndView requestDataAccessFailurePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dataAccessFailure");
		return mav;
	}
}
