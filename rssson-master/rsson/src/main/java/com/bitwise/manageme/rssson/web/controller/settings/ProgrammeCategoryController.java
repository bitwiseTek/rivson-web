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

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;
import com.bitwise.manageme.rssson.service.base.EducationTypeService;
import com.bitwise.manageme.rssson.service.base.StudyProgrammeCategoryService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class ProgrammeCategoryController {

	final Logger logger = LoggerFactory.getLogger(ProgrammeCategoryController.class);
	
	@Autowired
	private StudyProgrammeCategoryService categoryService;
	
	@Autowired
	private EducationTypeService educationTypeService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/programmecategories", method=RequestMethod.GET)
	public ModelAndView requestProgrammeCategoriesPage() {
		ModelAndView mav = new ModelAndView();
		List<StudyProgrammeCategory> categories = categoryService.findAll();
		mav.addObject("categories", categories);
		mav.setViewName("settings/programmecategories");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createprogrammecategory", method=RequestMethod.GET)
	public ModelAndView requestAddProgrammeCategoryPage(@ModelAttribute StudyProgrammeCategory category) {
		ModelAndView mav = new ModelAndView();
		List<EducationType> educationTypes = educationTypeService.findAll();
		mav.addObject("educationTypes", educationTypes);
		mav.addObject("category", category);
		mav.setViewName("settings/createprogrammecategory");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/programmecategories/edit/{id}", method=RequestMethod.GET)
	public String requestEditProgrammeCategoryPage(@PathVariable("id") Long id, @ModelAttribute StudyProgrammeCategory category, ModelMap model) {
		category = categoryService.findById(id);
		List<EducationType> educationTypes = educationTypeService.findAll();
		model.addAttribute("educationTypes", educationTypes);
		model.addAttribute("category", category);
		return "settings/programmecategories/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/programmecategories/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteProgrammeCategoryPage(@PathVariable("id") Long id, @ModelAttribute StudyProgrammeCategory category, ModelMap model) {
		category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "settings/programmecategories/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createprogrammecategory", method=RequestMethod.POST)
	public String addProgrammeCategory(@Valid @ModelAttribute StudyProgrammeCategory category, BindingResult result) {
		boolean categoryAlreadyExists = category.getName() != null
				&& (categoryService.findByName(category.getName()) != null);
		if (result.hasErrors() || categoryAlreadyExists) {
			if (categoryAlreadyExists) {
				result.rejectValue("name", "validation.category.alreadyExists", "Programme already exists");
			}
			return "redirect:/settings/createstudyprogramme";
		} else {
			logger.info("Creating Study Programme Category...");
			this.categoryService.save(category);
			return "redirect:/settings/programmecategories";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/programmecategories/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute StudyProgrammeCategory category, HttpServletRequest request) {
		this.categoryService.save(category);
		return "redirect:/settings/programmecategories/edit/" + UrlUtil.encodeUrlPathSegment(category.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/programmecategories/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute StudyProgrammeCategory category) {
		this.categoryService.delete(category);
		return "redirect:/settings/progammecategories";
	}
}
