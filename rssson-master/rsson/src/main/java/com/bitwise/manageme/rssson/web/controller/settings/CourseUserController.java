package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 10/07/16
 *
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.service.courses.CourseService;
import com.bitwise.manageme.rssson.service.courses.CourseUserService;
import com.bitwise.manageme.rssson.service.users.UserService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class CourseUserController {

	final Logger logger = LoggerFactory.getLogger(CourseUserController.class);
	
	@Autowired
	private CourseUserService courseUserService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courseusers", method=RequestMethod.GET)
	public ModelAndView requestCourseUsersPage() {
		ModelAndView mav = new ModelAndView();
		List<CourseUser> courseUsers = courseUserService.findAll();
		mav.addObject("courseUsers", courseUsers);
		mav.setViewName("settings/courseusers");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcourseuser", method=RequestMethod.GET)
	public ModelAndView requestAddCourseUserPage(@ModelAttribute CourseUser courseUser) {
		ModelAndView mav = new ModelAndView();
		List<Course> courses = courseService.findAll();
		mav.addObject("courses", courses);
		List<User> users = userService.findAll();
		mav.addObject("users", users);
		mav.addObject("courseUser", courseUser);
		mav.setViewName("settings/createcourseuser");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courseusers/edit/{id}", method=RequestMethod.GET)
	public String requestEditCourseUserPage(@PathVariable("id") Long id, @ModelAttribute CourseUser courseUser, ModelMap model) {
		courseUser = courseUserService.findById(id);
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		model.addAttribute("courseUser", courseUser);
		return "settings/courseusers/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courseusers/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteCourseUserPage(@PathVariable("id") Long id, @ModelAttribute CourseUser courseUser, ModelMap model) {
		courseUser = courseUserService.findById(id);
		model.addAttribute("courseUser", courseUser);
		return "settings/courseusers/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcourseuser", method=RequestMethod.POST)
	public String addCourseUser(@ModelAttribute CourseUser courseUser) {
		logger.info("Creating Course User...");
		this.courseUserService.save(courseUser);
		return "redirect:/settings/courseusers";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courseusers/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute CourseUser courseUser, HttpServletRequest request) {
		this.courseUserService.save(courseUser);
		return "redirect:/settings/courseusers/edit/" + UrlUtil.encodeUrlPathSegment(courseUser.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courseusers/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute CourseUser courseUser) {
		this.courseUserService.delete(courseUser);
		return "redirect:/settings/courseusers";
	}
}
