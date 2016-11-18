package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

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

import com.bitwise.manageme.rssson.domain.help.StudentManual;
import com.bitwise.manageme.rssson.service.help.StudentManualService;
import com.bitwise.manageme.rssson.web.response.UploadItem;

@Controller
public class StudentManualsController {

	final Logger logger = LoggerFactory.getLogger(StudentManualsController.class);
	
	@Autowired
	private StudentManualService manualService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/students/manuals", method=RequestMethod.GET)
	public ModelAndView requestManualPage() {
		ModelAndView mav = new ModelAndView();
		List<StudentManual> manuals = manualService.findAll();
		mav.addObject("manuals", manuals);
		mav.setViewName("settings/students/manuals");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/students/manuals/createmanual", method=RequestMethod.GET)
	public ModelAndView requestAddManualPage(@ModelAttribute StudentManual manual) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("manual", manual);
		mav.setViewName("settings/students/manuals/createmanual");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/students/manuals/show/{id}", method=RequestMethod.GET)
	public String requestShowManualPage(@PathVariable("id") Long id, ModelMap model) {
		StudentManual manual = manualService.findById(id);
		UploadItem uploadItem = new UploadItem();
		uploadItem.setStudentManualId(manual.getId());
		model.addAttribute("uploadItem", uploadItem);
		model.addAttribute("manual", manual);
		return "settings/students/manuals/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/students/manuals/createmanual", method=RequestMethod.POST)
	public String addStudentManual(@Valid @ModelAttribute StudentManual manual, BindingResult result) {
		boolean versionAlreadyExists = manual.getManualVersion() != null
				&& (manualService.findByVersion(manual.getManualVersion()) != null);
		if (result.hasErrors() || versionAlreadyExists) {
			if (versionAlreadyExists) {
				result.rejectValue("versionId", "validation.manual.alreadyExists", "Manual already exists");
			}
			return "redirect:/settings/students/manuals/createmanual";
		} else {
			logger.info("Creating Manual...");
			this.manualService.save(manual);
			return "redirect:/settings/students/manuals";
		}
	}
}
