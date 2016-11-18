package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 10/07/16
 *
 */
import java.util.List;
import java.util.Map;

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

import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.service.courses.CourseStaffMemberService;
import com.bitwise.manageme.rssson.service.courses.CourseUserService;
import com.bitwise.manageme.rssson.service.users.StaffMemberService;
import com.bitwise.manageme.rssson.util.forms.RolesList;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class CourseStaffController {

	final Logger logger = LoggerFactory.getLogger(CourseStaffController.class);
	
	@Autowired
	private CourseStaffMemberService courseStaffService;
	
	@Autowired
	private StaffMemberService staffService;
	
	@Autowired
	private CourseUserService courseUserService;
	
	@ModelAttribute("roles")
	public Map<String, String> roles(String currentRole) {
		Map<String, String> roles = RolesList.getRoles();
		return roles;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestaff", method=RequestMethod.GET)
	public ModelAndView requestCourseStaffPage() {
		ModelAndView mav = new ModelAndView();
		List<CourseStaffMember> courseStaff = courseStaffService.findAll();
		mav.addObject("courseStaff", courseStaff);
		mav.setViewName("settings/coursestaff");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcoursestaff", method=RequestMethod.GET)
	public ModelAndView requestAddCourseStaffPage(@ModelAttribute CourseStaffMember courseStaff) {
		ModelAndView mav = new ModelAndView();
		List<CourseUser> courseUsers = courseUserService.findAll();
		mav.addObject("courseUsers", courseUsers);
		List<StaffMember> staffMembers = staffService.findAll();
		mav.addObject("staffMembers", staffMembers);
		mav.addObject("courseStaff", courseStaff);
		mav.setViewName("settings/createcoursestaff");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestaff/edit/{id}", method=RequestMethod.GET)
	public String requestEditCourseStaffPage(@PathVariable("id") Long id, @ModelAttribute CourseStaffMember courseStaff, ModelMap model) {
		courseStaff = courseStaffService.findById(id);
		List<CourseUser> courseUsers = courseUserService.findAll();
		model.addAttribute("courseUsers", courseUsers);
		List<StaffMember> staffMembers = staffService.findAll();
		model.addAttribute("staffMembers", staffMembers);
		model.addAttribute("courseStaff", courseStaff);
		return "settings/coursestaff/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestaff/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteCourseUserPage(@PathVariable("id") Long id, @ModelAttribute CourseStaffMember courseStaff, ModelMap model) {
		courseStaff = courseStaffService.findById(id);
		model.addAttribute("courseStaff", courseStaff);
		return "settings/coursestaff/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcoursestaff", method=RequestMethod.POST)
	public String addCourseStaff(@ModelAttribute CourseStaffMember courseStaff) {
		logger.info("Creating Course Staff...");
		this.courseStaffService.save(courseStaff);
		return "redirect:/settings/coursestaff";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestaff/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute CourseStaffMember courseStaff, HttpServletRequest request) {
		this.courseStaffService.save(courseStaff);
		return "redirect:/settings/coursestaff/edit/" + UrlUtil.encodeUrlPathSegment(courseStaff.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestaff/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute CourseStaffMember courseStaff) {
		this.courseStaffService.delete(courseStaff);
		return "redirect:/settings/coursestaff";
	}
}
