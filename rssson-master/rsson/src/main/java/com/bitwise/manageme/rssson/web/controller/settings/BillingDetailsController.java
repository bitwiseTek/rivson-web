package com.bitwise.manageme.rssson.web.controller.settings;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.service.base.BillingDetailsService;
import com.bitwise.manageme.rssson.service.students.StudentService;
import com.bitwise.manageme.rssson.util.uuid.UUIDFactory;

@Controller
public class BillingDetailsController {

final Logger logger = LoggerFactory.getLogger(BillingDetailsController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BillingDetailsService billingService;
	
	@Autowired
	private UUIDFactory uuidFactory;
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/billingdetails", method=RequestMethod.GET)
	public ModelAndView requestBillingDetailsPage() {
		ModelAndView mav = new ModelAndView();
		List<BillingDetails> billingDets = billingService.findAll();
		mav.addObject("billingDets", billingDets);
		mav.setViewName("settings/billingdetails");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createbillingdetails", method=RequestMethod.GET)
	public ModelAndView requestAddBillingDetailsPage(@ModelAttribute BillingDetails billingDets) {
		ModelAndView mav = new ModelAndView();
		List<Student> studentIds = studentService.findAll();
		mav.addObject("studentIds", studentIds);
		List<Student> personNames = studentService.findAll();
		mav.addObject("personNames", personNames);
		List<Student> streetAddresses = studentService.findAll();
		mav.addObject("streetAddresses", streetAddresses);
		List<Student> postalCodes = studentService.findAll();
		mav.addObject("postalCodes", postalCodes);
		List<Student> cities = studentService.findAll();
		mav.addObject("cities", cities);
		List<Student> countries = studentService.findAll();
		mav.addObject("countries", countries);
		List<Student> phoneNumbers = studentService.findAll();
		mav.addObject("phoneNumbers", phoneNumbers);
		List<Student> emailAddresses = studentService.findAll();
		mav.addObject("emailAddresses", emailAddresses);
		mav.addObject("billingDets", billingDets);
		mav.setViewName("settings/createbillingdetails");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createbillingdetails", method=RequestMethod.POST)
	public String addBilling(@ModelAttribute BillingDetails billingDets) {
		logger.info("Creating Billing Details...");
		billingDets.setReferenceNumber(uuidFactory.generateUUID());
		this.billingService.save(billingDets);
		return "redirect:/settings/billingdetails";
	}
}
