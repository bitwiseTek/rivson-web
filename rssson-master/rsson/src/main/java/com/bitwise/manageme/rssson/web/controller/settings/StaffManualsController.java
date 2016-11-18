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

import com.bitwise.manageme.rssson.domain.help.StaffManual;
import com.bitwise.manageme.rssson.service.help.StaffManualService;
import com.bitwise.manageme.rssson.web.response.UploadItem;

@Controller
public class StaffManualsController {

	final Logger logger = LoggerFactory.getLogger(StaffManualsController.class);
	
	@Autowired
	private StaffManualService manualService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staff/manuals", method=RequestMethod.GET)
	public ModelAndView requestManualPage() {
		ModelAndView mav = new ModelAndView();
		List<StaffManual> manuals = manualService.findAll();
		mav.addObject("manuals", manuals);
		mav.setViewName("settings/staff/manuals");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staff/manuals/createmanual", method=RequestMethod.GET)
	public ModelAndView requestAddManualPage(@ModelAttribute StaffManual manual) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("manual", manual);
		mav.setViewName("settings/staff/manuals/createmanual");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staff/manuals/show/{id}", method=RequestMethod.GET)
	public String requestShowManualPage(@PathVariable("id") Long id, ModelMap model) {
		StaffManual manual = manualService.findById(id);
		UploadItem uploadItem = new UploadItem();
		uploadItem.setStudentManualId(manual.getId());
		model.addAttribute("uploadItem", uploadItem);
		model.addAttribute("manual", manual);
		return "settings/staff/manuals/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/staff/manuals/createmanual", method=RequestMethod.POST)
	public String addStudentManual(@Valid @ModelAttribute StaffManual manual, BindingResult result) {
		boolean versionAlreadyExists = manual.getManualVersion() != null
				&& (manualService.findByVersion(manual.getManualVersion()) != null);
		if (result.hasErrors() || versionAlreadyExists) {
			if (versionAlreadyExists) {
				result.rejectValue("versionId", "validation.manual.alreadyExists", "Manual already exists");
			}
			return "redirect:/settings/staff/manuals/createmanual";
		} else {
			logger.info("Creating Manual...");
			this.manualService.save(manual);
			return "redirect:/settings/staff/manuals";
		}
	}
}
