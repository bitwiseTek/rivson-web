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

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.domain.users.StaffMemberSubject;
import com.bitwise.manageme.rssson.service.base.SubjectService;
import com.bitwise.manageme.rssson.service.courses.CourseStaffMemberService;
import com.bitwise.manageme.rssson.service.users.StaffMemberSubjectService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class StaffMemberSubjectController {

	final Logger logger = LoggerFactory.getLogger(StaffMemberSubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StaffMemberSubjectService staffSubjectService;
	
	@Autowired
	private CourseStaffMemberService staffMemberService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staffsubjects", method=RequestMethod.GET)
	public ModelAndView requestStaffSubjectsPage() {
		ModelAndView mav = new ModelAndView();
		List<StaffMemberSubject> staffSubjects = staffSubjectService.findAll();
		mav.addObject("staffSubjects", staffSubjects);
		mav.setViewName("settings/staffsubjects");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createstaffsubject", method=RequestMethod.GET)
	public ModelAndView requestAddStaffSubjectPage(@ModelAttribute StaffMemberSubject staffSubject) {
		ModelAndView mav = new ModelAndView();
		List<Subject> subjects = subjectService.findAll();
		mav.addObject("subjects", subjects);
		List<CourseStaffMember> courseStaff = staffMemberService.findAll();
		mav.addObject("courseStaff", courseStaff);
		mav.addObject("staffSubject", staffSubject);
		mav.setViewName("settings/createstaffsubject");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staffsubjects/edit/{id}", method=RequestMethod.GET)
	public String requestEditStaffSubjectPage(@PathVariable("id") Long id, @ModelAttribute StaffMemberSubject staffSubject, ModelMap model) {
		staffSubject = staffSubjectService.findById(id);
		List<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		List<CourseStaffMember> courseStaff = staffMemberService.findAll();
		model.addAttribute("courseStaff", courseStaff);
		model.addAttribute("staffSubject", staffSubject);
		return "settings/staffsubjects/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staffsubjects/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteStaffSubjectPage(@PathVariable("id") Long id, @ModelAttribute StaffMemberSubject staffSubject, ModelMap model) {
		staffSubject = staffSubjectService.findById(id);
		model.addAttribute("staffSubject", staffSubject);
		return "settings/staffsubjects/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createstaffsubject", method=RequestMethod.POST)
	public String addStaffSubject(@ModelAttribute StaffMemberSubject staffSubject) {
		logger.info("Creating Subject Course Staff...");
		this.staffSubjectService.save(staffSubject);
		return "redirect:/settings/staffsubjects";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staffsubjects/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute StaffMemberSubject staffSubject, HttpServletRequest request) {
		this.staffSubjectService.save(staffSubject);
		return "redirect:/settings/staffsubjects/edit/" + UrlUtil.encodeUrlPathSegment(staffSubject.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staffsubjects/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute StaffMemberSubject staffSubject) {
		this.staffSubjectService.delete(staffSubject);
		return "redirect:/settings/staffsubjects";
	}
		
}
