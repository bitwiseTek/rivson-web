package com.bitwise.manageme.rssson.web.controller.user;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.help.StaffManual;
import com.bitwise.manageme.rssson.service.help.StaffManualService;
import com.bitwise.manageme.rssson.web.response.UploadItem;

@Controller
public class StaffManualController {

	@Autowired
	private StaffManualService manualService;
	
	@PreAuthorize("hasRole('STAFF') or hasRole('LECTURER')")
	@RequestMapping(value="/staff/manuals", method=RequestMethod.GET)
	public ModelAndView requestStaffManualPage() {
		ModelAndView mav = new ModelAndView();
		List<StaffManual> manuals = manualService.findAll();
		mav.addObject("manuals", manuals);
		mav.setViewName("staff/manuals");
		return mav;
	}
	
	@PreAuthorize("hasRole('STAFF') or hasRole('LECTURER')")
	@RequestMapping(value="/staff/manuals/download/{id}", method=RequestMethod.GET)
	public String requestShowStaffManualPage(@PathVariable("id") Long id, ModelMap model) {
		StaffManual manual = manualService.findById(id);
		UploadItem uploadItem = new UploadItem();
		uploadItem.setStaffManualId(manual.getId());
		model.addAttribute("uploadItem", uploadItem);
		model.addAttribute("manual", manual);
		return "staff/manuals/download";
	}
}
