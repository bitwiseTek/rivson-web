package com.bitwise.manageme.rssson.web.controller.user;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.dto.user.StaffMemberDto;
import com.bitwise.manageme.rssson.service.base.LGAService;
import com.bitwise.manageme.rssson.service.users.StaffMemberService;
import com.bitwise.manageme.rssson.service.users.UserService;
import com.bitwise.manageme.rssson.util.forms.NationalityList;
import com.bitwise.manageme.rssson.util.forms.StateList;
import com.bitwise.manageme.rssson.util.forms.TitleList;
import com.bitwise.manageme.rssson.util.search.filters.GridFilter;
import com.bitwise.manageme.rssson.util.search.filters.GridObjectMapper;
import com.bitwise.manageme.rssson.util.search.filters.StaffMemberMapper;
import com.bitwise.manageme.rssson.util.validator.StaffMemberValidator;
import com.bitwise.manageme.rssson.web.response.GridResponse;
import com.bitwise.manageme.rssson.web.response.UploadItem;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class StaffMemberController {
	
	final Logger logger = LoggerFactory.getLogger(StaffMemberController.class);
	
	@Autowired
	private StaffMemberService staffService;
	
	@Autowired
	private LGAService lgaService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder("staff")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StaffMemberValidator());
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/staff", method=RequestMethod.GET)
	public String requestStaffPage(ModelMap model) {
		List<StaffMember> staff = staffService.findAll();
		model.addAttribute("staff", staff);
		logger.info("Listing no of staff " + staff.size());
		return "staff";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/staff/createstaff", method=RequestMethod.GET)
	public ModelAndView requestAddStaffPage(@ModelAttribute StaffMember staff) {
		ModelAndView mav = new ModelAndView();
		List<User> users = userService.findAll();
		mav.addObject("users", users);
		Map<String, String> nationalities = NationalityList.getNationalities();
		mav.addObject("nationalities", nationalities);
		Map<String, String> states = StateList.getStates();
		mav.addObject("states", states);
		List<LGA> lgas = lgaService.findAll();
		mav.addObject("lgas", lgas);
		Map<String, String> titles = TitleList.getTitles();
		mav.addObject("titles", titles);
		mav.addObject("staff", staff);
		mav.setViewName("staff/createstaff");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/staff/show/{id}", method=RequestMethod.GET)
	public String requestShowStaffPage(@PathVariable("id") Long id, ModelMap model) {
		StaffMember staff = staffService.findById(id);
		UploadItem uploadItem = new UploadItem();
		uploadItem.setStaffId(staff.getId());
		model.addAttribute("uploadItem", uploadItem);
		model.addAttribute("staff", staff);
		return "staff/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('STAFF')")
	@RequestMapping(value="/staff/edit/{id}", method=RequestMethod.GET)
	public String requestEditStaffPage(@PathVariable("id") Long id, @ModelAttribute StaffMember staff, ModelMap model) {
		staff = staffService.findById(id);
		Map<String, String> nationalities = NationalityList.getNationalities();
		model.addAttribute("nationalities", nationalities);
		String currentNationality = staff.getNationality();
		model.addAttribute("currentNationality", currentNationality);
		Map<String, String> states = StateList.getStates();
		model.addAttribute("states", states);
		String currentState = staff.getStateOfOrigin();
		model.addAttribute("currentState", currentState);
		List<LGA> lgas = lgaService.findAll();
		model.addAttribute("lgas", lgas);
		String currentLga = staff.getLga().getName();
		model.addAttribute("currentLga", currentLga);
		Map<String, String> titles = TitleList.getTitles();
		model.addAttribute("titles", titles);
		String currentTitle = staff.getTitle();
		model.addAttribute("currentTitle", currentTitle);
		model.addAttribute("staff", staff);
		return "staff/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value="/staff/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteStaffPage(@PathVariable("id") Long id, @ModelAttribute StaffMember staff, ModelMap model) {
		staff = staffService.findById(id);
		model.addAttribute("staff", staff);
		return "staff/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/staff/createstaff", method=RequestMethod.POST)
	public String addStaff(@Valid @ModelAttribute StaffMember staff, BindingResult result) {
		boolean staffAlreadyExists = staff.getStaffId() != null
				&& (staffService.findByStaffId(staff.getStaffId()) != null);
		if (result.hasErrors() || staffAlreadyExists) {
			if (staffAlreadyExists) {
				result.rejectValue("staffId", "validation.staff.alreadyExists", "Staff already exists");
			}
			return "redirect:/staff/createstaff";
		} else {
			logger.info("Creating Staff...");
			this.staffService.save(staff);
			return "redirect:/staff";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('STAFF')")
	@RequestMapping(value="/staff/edit/{id}", method={RequestMethod.PUT})
	public String updateStaff(@Valid @ModelAttribute StaffMember staff, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.staffService.save(staff);
			return "redirect:/staff/edit/" + UrlUtil.encodeUrlPathSegment(staff.getId().toString(), request);
		} else {
			return "redirect:/staff/edit/" + UrlUtil.encodeUrlPathSegment(staff.getId().toString(), request);
		}
		
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value="/staff/delete/{id}", method={RequestMethod.DELETE})
	public String deleteStaff(@ModelAttribute StaffMember staff) {
		this.staffService.delete(staff);
		return "redirect:/staff";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/staff/staffgrid", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody GridResponse<StaffMemberDto> staffGrid(@RequestParam(value="page", required=false) Integer page, 
			@RequestParam(value="rows", required=false) Integer rows,
			@RequestParam(value="filters", required=false) String filters,
			@RequestParam(value="sidx", required=false) String sidx,
			@RequestParam(value="sord", required=false) String sord,
			@RequestParam(value="_search", required=false) Boolean search) {
		
		logger.info("Listing Staff grid with page: {}, rows: {}", page, rows);
		logger.info("Listing Staff grid with sort: {}, order: {}", sidx, sord);
		
		Sort sort = null;
		String orderBy = sidx;
		if (orderBy != null && orderBy.equals("id")) orderBy = "id";
		
		if (orderBy != null && sord != null) {
			if (sord.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else {
				sort = new Sort(Sort.Direction.ASC, orderBy);
			}
		}
		
		PageRequest pageRequest = null;
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}
		
		if (search == true) {
			return getFilteredRecords(filters, pageRequest);
		}
		
		Page<StaffMember> staff = staffService.findAll(pageRequest);
		List<StaffMemberDto> staffDtos = StaffMemberMapper.map(staff);
		
		GridResponse<StaffMemberDto> response = new GridResponse<StaffMemberDto>();
		response.setRows(staffDtos);
		response.setRecords(staff.getTotalElements());
		response.setTotal(staff.getTotalPages());
		response.setPage(staff.getNumber()+1);
		return response;
	}
	
	public GridResponse<StaffMemberDto> getFilteredRecords(String filters, Pageable pageRequest) {
		String qStaffId = null;
		 
		GridFilter filter = GridObjectMapper.map(filters);
		for (GridFilter.Rule rule : filter.getRules()) {
			if (rule.getField().equals("staffId")) {
				qStaffId = rule.getData();
			} 
		}
		
		Page<StaffMember> staff = null;
		if (qStaffId != null) {
			staff = staffService.findByStaffId("%"+qStaffId+"%", pageRequest);
		}
		
		List<StaffMemberDto> staffDtos = StaffMemberMapper.map(staff);	
		GridResponse<StaffMemberDto> response = new GridResponse<StaffMemberDto>();
		response.setRows(staffDtos);
		response.setRecords(staff.getTotalElements());
		response.setTotal(staff.getTotalPages());
		response.setPage(staff.getNumber()+1);
		return response;
	}

}
