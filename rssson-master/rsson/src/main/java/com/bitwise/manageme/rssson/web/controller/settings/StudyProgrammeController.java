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

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;
import com.bitwise.manageme.rssson.service.base.StudyProgrammeCategoryService;
import com.bitwise.manageme.rssson.service.base.StudyProgrammeService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class StudyProgrammeController {

	final Logger logger = LoggerFactory.getLogger(StudyProgrammeController.class);
	
	@Autowired
	private StudyProgrammeService programmeService;
	
	@Autowired
	private StudyProgrammeCategoryService categoryService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studyprogrammes", method=RequestMethod.GET)
	public ModelAndView requestProgrammesPage() {
		ModelAndView mav = new ModelAndView();
		List<StudyProgramme> programmes = programmeService.findAll();
		mav.addObject("programmes", programmes);
		mav.setViewName("settings/studyprogrammes");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createstudyprogramme", method=RequestMethod.GET)
	public ModelAndView requestAddProgrammePage(@ModelAttribute StudyProgramme programme) {
		ModelAndView mav = new ModelAndView();
		List<StudyProgrammeCategory> categories = categoryService.findAll();
		mav.addObject("categories", categories);
		mav.addObject("programme", programme);
		mav.setViewName("settings/createstudyprogramme");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studyprogrammes/edit/{id}", method=RequestMethod.GET)
	public String requestEditProgrammePage(@PathVariable("id") Long id, @ModelAttribute StudyProgramme programme, ModelMap model) {
		programme = programmeService.findById(id);
		List<StudyProgrammeCategory> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("programme", programme);
		return "settings/studyprogrammes/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studyprogrammes/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteProgrammePage(@PathVariable("id") Long id, @ModelAttribute StudyProgramme programme, ModelMap model) {
		programme = programmeService.findById(id);
		model.addAttribute("programme", programme);
		return "settings/studyprogrammes/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createstudyprogramme", method=RequestMethod.POST)
	public String addSchoolField(@Valid @ModelAttribute StudyProgramme programme, BindingResult result) {
		boolean programmeAlreadyExists = programme.getName() != null
				&& (programmeService.findByName(programme.getName()) != null);
		boolean codeAlreadyExists = programme.getCode() != null
				&& (programmeService.findByCode(programme.getCode()) != null);
		if (result.hasErrors() || programmeAlreadyExists) {
			if (programmeAlreadyExists) {
				result.rejectValue("name", "validation.programme.alreadyExists", "Programme already exists");
			}
			return "redirect:/settings/createstudyprogramme";
		} else if (result.hasErrors() || codeAlreadyExists) {
			if (codeAlreadyExists) {
				result.rejectValue("name", "validation.programmecode.alreadyExists", "Programme code already exists");
			}
			return "redirect:/settings/createstudyprogramme";
		} else {
			logger.info("Creating Study Programme...");
			this.programmeService.save(programme);
			return "redirect:/settings/studyprogrammes";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studyprogrammes/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute StudyProgramme programme, HttpServletRequest request) {
		this.programmeService.save(programme);
		return "redirect:/settings/studyprogrammes/edit/" + UrlUtil.encodeUrlPathSegment(programme.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/studyprogrammes/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute StudyProgramme programme) {
		this.programmeService.delete(programme);
		return "redirect:/settings/studyprogammes";
	}
}
