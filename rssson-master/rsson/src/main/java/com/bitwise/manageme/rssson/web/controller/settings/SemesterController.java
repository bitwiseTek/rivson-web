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

import com.bitwise.manageme.rssson.domain.base.AcademicSemester;
import com.bitwise.manageme.rssson.service.base.AcademicSemesterService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class SemesterController {

	final Logger logger = LoggerFactory.getLogger(SemesterController.class);
	
	@Autowired
	private AcademicSemesterService semesterService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/academicsemesters", method=RequestMethod.GET)
	public ModelAndView requestSemestersPage() {
		ModelAndView mav = new ModelAndView();
		List<AcademicSemester> semesters = semesterService.findAll();
		mav.addObject("semesters", semesters);
		mav.setViewName("settings/academicsemesters");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/academicsemesters/edit/{id}", method=RequestMethod.GET)
	public String requestEditSemestersPage(@PathVariable("id") Long id, @ModelAttribute AcademicSemester semester, ModelMap model) {
		semester = semesterService.findById(id);
		List<AcademicSemester> semesters = semesterService.findAll();
		model.addAttribute("semesters", semesters);
		model.addAttribute("semester", semester);
		return "settings/academicsemesters/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/academicsemesters/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute AcademicSemester semester, HttpServletRequest request) {
		this.semesterService.save(semester);
		return "redirect:/settings/academicsemesters/edit/" + UrlUtil.encodeUrlPathSegment(semester.getId().toString(), request);
	}
}
