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

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.courses.CourseUser;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.service.accommodation.RoomService;
import com.bitwise.manageme.rssson.service.base.BillingDetailsService;
import com.bitwise.manageme.rssson.service.courses.CourseStudentService;
import com.bitwise.manageme.rssson.service.courses.CourseUserService;
import com.bitwise.manageme.rssson.service.students.StudentService;
import com.bitwise.manageme.rssson.util.forms.CourseEnrolmentTypeList;
import com.bitwise.manageme.rssson.util.forms.CourseOptionalityList;
import com.bitwise.manageme.rssson.util.forms.CourseParticipationTypeList;
import com.bitwise.manageme.rssson.util.forms.CurrenciesList;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class CourseStudentController {

	final Logger logger = LoggerFactory.getLogger(CourseStudentController.class);
	
	@Autowired
	private CourseStudentService courseStudentService;
	
	@Autowired
	private CourseUserService courseUserService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BillingDetailsService billingService;
	
	@Autowired
	private RoomService roomService;
	
	@ModelAttribute("partTypes")
	public Map<String, String> partTypes(String currentPartType) {
		Map<String, String> partTypes = CourseParticipationTypeList.getPartTypes();
		return partTypes;
	}
	
	@ModelAttribute("enrolmentTypes")
	public Map<String, String> enrolmentTypes(String currentEnrolType) {
		Map<String, String> enrolmentTypes = CourseEnrolmentTypeList.getEnrolmentTypes();
		return enrolmentTypes;
	}
	
	@ModelAttribute("optionalities")
	public Map<String, String> optionalities(String currentOption) {
		Map<String, String> optionalities = CourseOptionalityList.getOptionalities();
		return optionalities;
	}
	
	@ModelAttribute("currencies")
	public Map<String, String> currencies(String currentCurrency) {
		Map<String, String> currencies = CurrenciesList.getCurrencies();
		return currencies;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestudents", method=RequestMethod.GET)
	public ModelAndView requestCourseStudentsPage() {
		ModelAndView mav = new ModelAndView();
		List<CourseStudent> courseStudents = courseStudentService.findAll();
		mav.addObject("courseStudents", courseStudents);
		mav.setViewName("settings/coursestudents");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcoursestudent", method=RequestMethod.GET)
	public ModelAndView requestAddCourseStudentPage(@ModelAttribute CourseStudent courseStudent) {
		ModelAndView mav = new ModelAndView();
		List<CourseUser> courseUsers = courseUserService.findAll();
		mav.addObject("courseUsers", courseUsers);
		List<Student> students = studentService.findAll();
		mav.addObject("students", students);
		List<BillingDetails> billingDetails = billingService.findAll();
		mav.addObject("billingDetails", billingDetails);
		List<Room> rooms = roomService.findAll();
		mav.addObject("rooms", rooms);
		mav.addObject("courseStudent", courseStudent);
		mav.setViewName("settings/createcoursestudent");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestudents/edit/{id}", method=RequestMethod.GET)
	public String requestEditCourseStudentPage(@PathVariable("id") Long id, @ModelAttribute CourseStudent courseStudent, ModelMap model) {
		courseStudent = courseStudentService.findById(id);
		List<CourseUser> courseUsers = courseUserService.findAll();
		model.addAttribute("courseUsers", courseUsers);
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		List<BillingDetails> billingDetails = billingService.findAll();
		model.addAttribute("billingDetails", billingDetails);
		List<Room> rooms = roomService.findAll();
		model.addAttribute("rooms", rooms);
		model.addAttribute("courseStudent", courseStudent);
		return "settings/coursestudents/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestudents/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteCourseStudentPage(@PathVariable("id") Long id, @ModelAttribute CourseStudent courseStudent, ModelMap model) {
		courseStudent = courseStudentService.findById(id);
		model.addAttribute("courseStudent", courseStudent);
		return "settings/coursestudents/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcoursestudent", method=RequestMethod.POST)
	public String addCourseStudent(@ModelAttribute CourseStudent courseStudent) {
		logger.info("Creating Course Student...");
		this.courseStudentService.save(courseStudent);
		return "redirect:/settings/coursestudents";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestudents/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute CourseStudent courseStudent, HttpServletRequest request) {
		this.courseStudentService.save(courseStudent);
		return "redirect:/settings/coursestudents/edit/" + UrlUtil.encodeUrlPathSegment(courseStudent.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursestudents/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute CourseStudent courseStudent) {
		this.courseStudentService.delete(courseStudent);
		return "redirect:/settings/coursestudents";
	}
}
