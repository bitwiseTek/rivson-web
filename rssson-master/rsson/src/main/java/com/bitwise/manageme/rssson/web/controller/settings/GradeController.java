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

import com.bitwise.manageme.rssson.domain.grading.Grade;
import com.bitwise.manageme.rssson.domain.grading.GradingScale;
import com.bitwise.manageme.rssson.service.grading.GradeService;
import com.bitwise.manageme.rssson.service.grading.GradingScaleService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class GradeController {

	final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private GradingScaleService gradingScaleService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/grades", method=RequestMethod.GET)
	public ModelAndView requestGradesPage() {
		ModelAndView mav = new ModelAndView();
		List<Grade> grades = gradeService.findAll();
		mav.addObject("grades", grades);
		mav.setViewName("settings/grades");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/creategrade", method=RequestMethod.GET)
	public String requestAddGradePage(@ModelAttribute Grade grade, ModelMap model) {
		List<GradingScale> gradingScales = gradingScaleService.findAll();
		model.addAttribute("gradingScacles", gradingScales);
		model.addAttribute("grade", grade);
		return "settings/creategrade";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/grades/edit/{id}", method=RequestMethod.GET)
	public String requestEditGradesPage(@PathVariable("id") Long id, @ModelAttribute Grade grade, ModelMap model) {
		grade = gradeService.findById(id);
		List<GradingScale> gradingScales = gradingScaleService.findAll();
		model.addAttribute("gradingScales", gradingScales);
		model.addAttribute("grade", grade);
		return "settings/grades/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/creategrade", method={RequestMethod.POST})
	public String addGrade(@ModelAttribute Grade grade) {
		this.gradeService.save(grade);
		return "redirect:/settings/grades";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/grades/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute Grade grade, HttpServletRequest request) {
		this.gradeService.save(grade);
		return "redirect:/settings/grades/edit/" + UrlUtil.encodeUrlPathSegment(grade.getId().toString(), request);
	}
}
