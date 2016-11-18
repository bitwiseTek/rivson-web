package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 29/10/16
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

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.service.accommodation.RoomService;
import com.bitwise.manageme.rssson.service.accommodation.RoomTypeService;
import com.bitwise.manageme.rssson.service.students.StudentService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class AccommodationController {

final Logger logger = LoggerFactory.getLogger(AccommodationController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/accommodations", method=RequestMethod.GET)
	public String requestAccommodationsPage(ModelMap model) {
		List<Room> rooms = roomService.findAll();
		model.addAttribute("rooms", rooms);
		return "settings/accommodations";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createaccommodation", method=RequestMethod.GET)
	public ModelAndView requestAddAccPage(@ModelAttribute Room room) {
		ModelAndView mav = new ModelAndView();
		List<Student> studentIds = studentService.findAll();
		mav.addObject("studentIds", studentIds);
		List<RoomType> types = roomTypeService.findAll();
		mav.addObject("types", types);
		mav.addObject("room", room);
		mav.setViewName("settings/createaccommodation");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/accommodations/edit/{id}", method=RequestMethod.GET)
	public String requestEditAccPage(@PathVariable("id") Long id, @ModelAttribute Room room, ModelMap model) {
		room = roomService.findById(id);
		List<Student> studentIds = studentService.findAll();
		model.addAttribute("studentIds", studentIds);
		List<RoomType> types = roomTypeService.findAll();
		model.addAttribute("types", types);
		model.addAttribute("room", room);
		return "settings/accommodations/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createaccommodation", method=RequestMethod.POST)
	public String addAcc(@Valid @ModelAttribute Room room) {
		logger.info("Creating Accommodation...");
		this.roomService.save(room);
		return "redirect:/settings/accommodations";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/accommodations/edit/{id}", method={RequestMethod.PUT})
	public String update(@Valid @ModelAttribute Room room, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.roomService.save(room);
			return "redirect:/settings/accommodations/edit/" + UrlUtil.encodeUrlPathSegment(room.getId().toString(), request);
		} else {
			return "redirect:/settings/accommodations/edit/" + UrlUtil.encodeUrlPathSegment(room.getId().toString(), request);
		}
		
	}
}
