package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 09/07/16
 *
 */
import java.util.List;
import java.util.Map;

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
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseState;
import com.bitwise.manageme.rssson.domain.courses.CourseType;
import com.bitwise.manageme.rssson.service.base.CourseBaseService;
import com.bitwise.manageme.rssson.service.courses.CourseService;
import com.bitwise.manageme.rssson.service.courses.CourseStateService;
import com.bitwise.manageme.rssson.service.courses.CourseTypeService;
import com.bitwise.manageme.rssson.util.forms.CurrenciesList;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class CourseController {

	final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseBaseService baseService;
	
	@Autowired
	private CourseStateService stateService;
	
	@Autowired
	private CourseTypeService typeService;
	
	@ModelAttribute("currencies")
	public Map<String, String> currencies(String currentCurrency) {
		Map<String, String> currencies = CurrenciesList.getCurrencies();
		return currencies;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courses", method=RequestMethod.GET)
	public ModelAndView requestCoursesPage() {
		ModelAndView mav = new ModelAndView();
		List<Course> courses = courseService.findAll();
		mav.addObject("courses", courses);
		mav.setViewName("settings/courses");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcourse", method=RequestMethod.GET)
	public ModelAndView requestAddCoursePage(@ModelAttribute Course course) {
		ModelAndView mav = new ModelAndView();
		List<CourseBase> courseBases = baseService.findAll();
		mav.addObject("courseBases", courseBases);
		List<CourseState> states = stateService.findAll();
		mav.addObject("states", states);
		List<CourseType> types = typeService.findAll();
		mav.addObject("types", types);
		mav.addObject("course", course);
		mav.setViewName("settings/createcourse");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courses/edit/{id}", method=RequestMethod.GET)
	public String requestEditCoursePage(@PathVariable("id") Long id, @ModelAttribute Course course, ModelMap model) {
		course = courseService.findById(id);
		List<CourseBase> courseBases = baseService.findAll();
		model.addAttribute("courseBases", courseBases);
		List<CourseState> states = stateService.findAll();
		model.addAttribute("states", states);
		List<CourseType> types = typeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("course", course);
		return "settings/courses/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courses/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteCoursePage(@PathVariable("id") Long id, @ModelAttribute Course course, ModelMap model) {
		course = courseService.findById(id);
		model.addAttribute("course", course);
		return "settings/courses/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createcourse", method=RequestMethod.POST)
	public String addCourse(@Valid @ModelAttribute Course course, BindingResult result) {
		boolean courseAlreadyExists = course.getName() != null
				&& (courseService.findByName(course.getName()) != null);
		if (result.hasErrors() || courseAlreadyExists) {
			if (courseAlreadyExists) {
				result.rejectValue("name", "validation.course.alreadyExists", "Course already exists");
			}
			return "redirect:/settings/createcourse";
		} else {
			logger.info("Creating Course...");
			this.courseService.save(course);
			return "redirect:/settings/courses";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courses/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute Course course, HttpServletRequest request) {
		this.courseService.save(course);
		return "redirect:/settings/courses/edit/" + UrlUtil.encodeUrlPathSegment(course.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/courses/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute Course course) {
		this.courseService.delete(course);
		return "redirect:/settings/courses";
	}
}
