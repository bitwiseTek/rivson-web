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

import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;
import com.bitwise.manageme.rssson.service.base.EducationalLengthService;
import com.bitwise.manageme.rssson.service.base.EducationalTimeUnitService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class EduLengthController {

	final Logger logger = LoggerFactory.getLogger(EduLengthController.class);
	
	@Autowired
	private EducationalLengthService eduLengthService;
	
	@Autowired
	private EducationalTimeUnitService timeUnitService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/educationlengths", method=RequestMethod.GET)
	public ModelAndView requestEduLengthsPage() {
		ModelAndView mav = new ModelAndView();
		List<EducationalLength> eduLengths = eduLengthService.findAll();
		mav.addObject("ediLengths", eduLengths);
		mav.setViewName("settings/educationlengths");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createeducationlength", method=RequestMethod.GET)
	public String requestAddEduLengthPage(@ModelAttribute EducationalLength eduLength, ModelMap model) {
		List<EducationalTimeUnit> units = timeUnitService.findAll();
		model.addAttribute("units", units);
		model.addAttribute("eduLength", eduLength);
		return "settings/createeducationlength";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/educationlengths/edit/{id}", method=RequestMethod.GET)
	public String requestEditEduLengthPage(@PathVariable("id") Long id, @ModelAttribute EducationalLength eduLength, ModelMap model) {
		eduLength = eduLengthService.findById(id);
		model.addAttribute("eduLength", eduLength);
		return "settings/educationlengths/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createeducationlength", method={RequestMethod.POST})
	public String addEduLength(@ModelAttribute EducationalLength eduLength) {
		this.eduLengthService.save(eduLength);
		return "redirect:/settings/educationlengths";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/educationlengths/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute EducationalLength eduLength, HttpServletRequest request) {
		this.eduLengthService.save(eduLength);
		return "redirect:/settings/educationlengths/edit/" + UrlUtil.encodeUrlPathSegment(eduLength.getId().toString(), request);
	}
}
