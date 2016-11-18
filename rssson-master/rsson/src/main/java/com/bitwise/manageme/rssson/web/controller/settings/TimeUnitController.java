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

import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;
import com.bitwise.manageme.rssson.service.base.EducationalTimeUnitService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class TimeUnitController {

	final Logger logger = LoggerFactory.getLogger(TimeUnitController.class);
	
	@Autowired
	private EducationalTimeUnitService timeUnitService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/timeunits", method=RequestMethod.GET)
	public ModelAndView requestTimeUnitsPage() {
		ModelAndView mav = new ModelAndView();
		List<EducationalTimeUnit> timeUnits = timeUnitService.findAll();
		mav.addObject("timeUnits", timeUnits);
		mav.setViewName("settings/timeunits");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createtimeunit", method=RequestMethod.GET)
	public String requestAddTimeUnitPage(@ModelAttribute EducationalTimeUnit timeUnit, ModelMap model) {
		List<EducationalTimeUnit> timeUnits = timeUnitService.findAll();
		model.addAttribute("timeUnits", timeUnits);
		model.addAttribute("timeUnit", timeUnit);
		return "settings/createtimeunit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/timeunits/edit/{id}", method=RequestMethod.GET)
	public String requestEditTimeUnitPage(@PathVariable("id") Long id, @ModelAttribute EducationalTimeUnit timeUnit, ModelMap model) {
		timeUnit = timeUnitService.findById(id);
		model.addAttribute("timeUnit", timeUnit);
		return "settings/timeunits/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createtimeunit", method={RequestMethod.POST})
	public String addTimeUnit(@ModelAttribute EducationalTimeUnit timeUnit) {
		this.timeUnitService.save(timeUnit);
		return "redirect:/settings/timeunits";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/timeunits/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute EducationalTimeUnit timeUnit, HttpServletRequest request) {
		this.timeUnitService.save(timeUnit);
		return "redirect:/settings/timeunits/edit/" + UrlUtil.encodeUrlPathSegment(timeUnit.getId().toString(), request);
	}
}
