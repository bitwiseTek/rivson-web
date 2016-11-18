package com.bitwise.manageme.rssson.web.controller.student;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.help.StudentManual;
import com.bitwise.manageme.rssson.service.help.StudentManualService;

@Controller
public class StudentManualController {

	@Autowired
	private StudentManualService manualService;
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/manuals", method=RequestMethod.GET)
	public ModelAndView requestStudentManualPage() {
		ModelAndView mav = new ModelAndView();
		List<StudentManual> manuals = manualService.findAll();
		mav.addObject("manuals", manuals);
		mav.setViewName("students/manuals");
		return mav;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/manuals/download/{id}", method=RequestMethod.GET)
	public String requestShowStudentManualPage(@PathVariable("id") Long id, ModelMap model) {
		StudentManual manual = manualService.findById(id);
		model.addAttribute("manual", manual);
		return "students/manuals/download";
	}
}
