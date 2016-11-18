package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 09/07/16
 *
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.service.base.CourseBaseService;
import com.bitwise.manageme.rssson.service.base.EducationalLengthService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class CourseBaseController {

	final Logger logger = LoggerFactory.getLogger(CourseBaseController.class);
	
	@Autowired
	private CourseBaseService baseService;
	
	@Autowired
	private EducationalLengthService eduLengthService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursebases", method=RequestMethod.GET)
	public ModelAndView requestCourseBasesPage() {
		ModelAndView mav = new ModelAndView();
		List<CourseBase> courseBases = baseService.findAll();
		mav.addObject("courseBases", courseBases);
		mav.setViewName("settings/coursebases");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcoursebase", method=RequestMethod.GET)
	public ModelAndView requestAddCourseBasePage(@ModelAttribute CourseBase courseBase) {
		ModelAndView mav = new ModelAndView();
		List<EducationalLength> educationLengths = eduLengthService.findAll();
		mav.addObject("educationLengths", educationLengths);
		User creator = new User();
		mav.addObject("user", creator);
		User lastModifier = new User();
		mav.addObject("lastModifier", lastModifier);
		mav.addObject("courseBase", courseBase);
		mav.setViewName("settings/createcoursebase");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursebases/edit/{id}", method=RequestMethod.GET)
	public String requestEditCourseBasePage(@PathVariable("id") Long id, @ModelAttribute CourseBase courseBase, ModelMap model) {
		courseBase = baseService.findById(id);
		List<EducationalLength> educationLengths = eduLengthService.findAll();
		model.addAttribute("educationLengths", educationLengths);
		model.addAttribute("courseBase", courseBase);
		return "settings/coursebases/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursebases/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteCourseBasePage(@PathVariable("id") Long id, @ModelAttribute CourseBase courseBase, ModelMap model) {
		courseBase = baseService.findById(id);
		model.addAttribute("courseBase", courseBase);
		return "settings/coursebases/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcoursebase", method=RequestMethod.POST)
	public String addCourseBase(@Valid @ModelAttribute CourseBase courseBase, BindingResult result) {
		boolean courseBaseAlreadyExists = courseBase.getName() != null
				&& (baseService.findByName(courseBase.getName()) != null);
		boolean courseCodeAlreadyExists = courseBase.getCourseCode() != null
				&& (baseService.findByCode(courseBase.getCourseCode()) != null);
		if (result.hasErrors() || courseBaseAlreadyExists) {
			if (courseBaseAlreadyExists) {
				result.rejectValue("name", "validation.coursebase.alreadyExists", "Course Base already exists");
			}
			return "redirect:/settings/createcoursebase";
		} else if (result.hasErrors() || courseCodeAlreadyExists) {
			if (courseCodeAlreadyExists) {
				result.rejectValue("courseCode", "validation.coursebasecode.alreadyExists", "Course base code already exists");
			}
			return "redirect:/settings/createcoursebase";
		} else {
			logger.info("Creating Course Base...");
			this.baseService.save(courseBase);
			return "redirect:/settings/coursebases";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursebases/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute CourseBase courseBase, HttpServletRequest request) {
		this.baseService.save(courseBase);
		return "redirect:/settings/coursebases/edit/" + UrlUtil.encodeUrlPathSegment(courseBase.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/coursebases/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute CourseBase courseBase) {
		this.baseService.delete(courseBase);
		return "redirect:/settings/coursebases";
	}
}
