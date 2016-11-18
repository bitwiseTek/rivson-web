package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 10/07/16
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

import com.bitwise.manageme.rssson.domain.grading.GradingScale;
import com.bitwise.manageme.rssson.service.grading.GradingScaleService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class GradingScaleController {

	final Logger logger = LoggerFactory.getLogger(GradingScaleController.class);
	
	@Autowired
	private GradingScaleService scaleService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/gradingscales", method=RequestMethod.GET)
	public ModelAndView requestGradingScalesPage() {
		ModelAndView mav = new ModelAndView();
		List<GradingScale> gradingScales = scaleService.findAll();
		mav.addObject("gradingScales", gradingScales);
		mav.setViewName("settings/gradingscales");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/creategradingscale", method=RequestMethod.GET)
	public ModelAndView requestAddScalePage(@ModelAttribute GradingScale gradingScale) {
		ModelAndView mav = new ModelAndView();
		List<GradingScale> gradingScales = scaleService.findAll();
		mav.addObject("gradingScales", gradingScales);
		mav.addObject("gradingScale", gradingScale);
		mav.setViewName("settings/creategradingscale");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/gradingscales/edit/{id}", method=RequestMethod.GET)
	public String requestEditScalePage(@PathVariable("id") Long id, @ModelAttribute GradingScale gradingScale, ModelMap model) {
		gradingScale = scaleService.findById(id);
		List<GradingScale> gradingScales = scaleService.findAll();
		model.addAttribute("gradingScales", gradingScales);
		model.addAttribute("gradingScale", gradingScale);
		return "settings/gradingscales/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/gradingscales/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteScalePage(@PathVariable("id") Long id, @ModelAttribute GradingScale gradingScale, ModelMap model) {
		gradingScale = scaleService.findById(id);
		model.addAttribute("gradingScale", gradingScale);
		return "settings/gradingscales/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/creategradingscale", method=RequestMethod.POST)
	public String addScale(@Valid @ModelAttribute GradingScale gradingScale, BindingResult result) {
		boolean scaleAlreadyExists = gradingScale.getName() != null
				&& (scaleService.findByName(gradingScale.getName()) != null);
		if (result.hasErrors() || scaleAlreadyExists) {
			if (scaleAlreadyExists) {
				result.rejectValue("name", "validation.scale.alreadyExists", "Scale already exists");
			}
			return "redirect:/settings/creategradingscale";
		} else {
			logger.info("Creating Scale...");
			this.scaleService.save(gradingScale);
			return "redirect:/settings/gradingscales";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/gradingscales/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute GradingScale gradingScale, HttpServletRequest request) {
		this.scaleService.save(gradingScale);
		return "redirect:/settings/gradingscales/edit/" + UrlUtil.encodeUrlPathSegment(gradingScale.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/gradingscales/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute GradingScale gradingScale) {
		this.scaleService.delete(gradingScale);
		return "redirect:/settings/gradingscales";
	}
}
