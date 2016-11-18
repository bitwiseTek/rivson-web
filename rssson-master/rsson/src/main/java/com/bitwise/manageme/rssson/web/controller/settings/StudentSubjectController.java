package com.bitwise.manageme.rssson.web.controller.settings;

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
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.StudentSubject;
import com.bitwise.manageme.rssson.service.base.SubjectService;
import com.bitwise.manageme.rssson.service.courses.CourseStudentService;
import com.bitwise.manageme.rssson.service.students.StudentSubjectService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class StudentSubjectController {

	final Logger logger = LoggerFactory.getLogger(StudentSubjectController.class);

	@Autowired
	private StudentSubjectService studentSubjectService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CourseStudentService studentService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studentsubjects", method=RequestMethod.GET)
	public ModelAndView requestStudentSubjectsPage() {
		ModelAndView mav = new ModelAndView();
		List<StudentSubject> studentSubjects = studentSubjectService.findAll();
		mav.addObject("studentSubjects", studentSubjects);
		mav.setViewName("settings/studentsubjects");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createstudentsubject", method=RequestMethod.GET)
	public ModelAndView requestAddStudentSubjectPage(@ModelAttribute StudentSubject studentSubject) {
		ModelAndView mav = new ModelAndView();
		List<Subject> subjects = subjectService.findAll();
		mav.addObject("subjects", subjects);
		List<CourseStudent> courseStudents = studentService.findAll();
		mav.addObject("courseStudents", courseStudents);
		mav.addObject("studentSubject", studentSubject);
		mav.setViewName("settings/createstudentsubject");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studentsubjects/edit/{id}", method=RequestMethod.GET)
	public String requestEditStudentSubjectPage(@PathVariable("id") Long id, @ModelAttribute StudentSubject studentSubject, ModelMap model) {
		studentSubject = studentSubjectService.findById(id);
		List<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		List<CourseStudent> courseStudents = studentService.findAll();
		model.addAttribute("courseStudents", courseStudents);
		model.addAttribute("studentSubject", studentSubject);
		return "settings/studentsubjects/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studentsubjects/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteStudentSubjectPage(@PathVariable("id") Long id, @ModelAttribute StudentSubject studentSubject, ModelMap model) {
		studentSubject = studentSubjectService.findById(id);
		model.addAttribute("studentSubject", studentSubject);
		return "settings/studentsubjects/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createstudentsubject", method=RequestMethod.POST)
	public String addStudentSubject(@ModelAttribute StudentSubject studentSubject) {
		logger.info("Creating Subject Course Student...");
		this.studentSubjectService.save(studentSubject);
		return "redirect:/settings/studentsubjects";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studentsubjects/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute StudentSubject studentSubject, HttpServletRequest request) {
		this.studentSubjectService.save(studentSubject);
		return "redirect:/settings/studentsubjects/edit/" + UrlUtil.encodeUrlPathSegment(studentSubject.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studentsubjects/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute StudentSubject studentSubject) {
		this.studentSubjectService.delete(studentSubject);
		return "redirect:/settings/studentsubjects";
	}
}
