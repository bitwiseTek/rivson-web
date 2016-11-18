package com.bitwise.manageme.rssson.web.controller.student;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
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

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.StudentSubject;
import com.bitwise.manageme.rssson.service.courses.CourseStudentService;
import com.bitwise.manageme.rssson.service.students.StudentSubjectService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class StudentSubjectsController {

	final Logger logger = LoggerFactory.getLogger(StudentSubjectsController.class);
	
	@Autowired
	private StudentSubjectService subjectService;
	
	@Autowired
	private CourseStudentService courseStudentService;
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/subjects", method=RequestMethod.GET)
	public ModelAndView requestSubjectsPage() {
		ModelAndView mav = new ModelAndView();
		List<StudentSubject> oneStudentSubjects = subjectService.findAllOne();
		mav.addObject("oneStudentSubjects", oneStudentSubjects);
		List<StudentSubject> twoStudentSubjects = subjectService.findAllTwo();
		mav.addObject("twoStudentSubjects", twoStudentSubjects);
		mav.setViewName("students/subjects");
		return mav;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/registered/subjects", method=RequestMethod.GET)
	public ModelAndView requestRegisteredSubjectsPage() {
		ModelAndView mav = new ModelAndView();
		List<StudentSubject> oneStudentSubjects = subjectService.findAllRegisteredOne();
		mav.addObject("oneStudentSubjects", oneStudentSubjects);
		List<StudentSubject> twoStudentSubjects = subjectService.findAllRegisteredTwo();
		mav.addObject("twoStudentSubjects", twoStudentSubjects);
		List<CourseStudent> courseStudents = courseStudentService.findAll();
		mav.addObject("courseStudents", courseStudents);
		mav.setViewName("students/registered/subjects");
		return mav;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/subjects/register/{id}", method=RequestMethod.GET)
	public String requestRegisterStudentSubjectPage(@PathVariable("id") Long id, @ModelAttribute StudentSubject studentSubject, ModelMap model) {
		studentSubject = subjectService.findById(id);
		List<CourseStudent> courseStudents = courseStudentService.findAll();
		model.addAttribute("studentSubject", studentSubject);
		model.addAttribute("courseStudents", courseStudents);
		return "students/subjects/register";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/subjects/register/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute StudentSubject studentSubject, HttpServletRequest request) {
		this.subjectService.save(studentSubject);
		return "redirect:/students/subjects/register/" + UrlUtil.encodeUrlPathSegment(studentSubject.getId().toString(), request);
	}
}
