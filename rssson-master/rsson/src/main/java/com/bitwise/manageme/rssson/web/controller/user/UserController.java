package com.bitwise.manageme.rssson.web.controller.user;
/**
 *  
 * @author Sika Kay
 * @date 14/09/16
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.domain.security.Role;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.dto.user.UserDto;
import com.bitwise.manageme.rssson.service.security.RoleService;
import com.bitwise.manageme.rssson.service.users.UserService;
import com.bitwise.manageme.rssson.util.forms.CitiesList;
import com.bitwise.manageme.rssson.util.forms.CountryList;
import com.bitwise.manageme.rssson.util.forms.QuestionsList;
import com.bitwise.manageme.rssson.util.forms.SexList;
import com.bitwise.manageme.rssson.util.search.filters.GridFilter;
import com.bitwise.manageme.rssson.util.search.filters.GridObjectMapper;
import com.bitwise.manageme.rssson.util.search.filters.UserMapper;
import com.bitwise.manageme.rssson.util.uuid.UUIDFactory;
import com.bitwise.manageme.rssson.util.validator.UserValidator;
import com.bitwise.manageme.rssson.web.response.GridResponse;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
@SessionAttributes("roles")
public class UserController {
	
	final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UUIDFactory uuidFactory;
	
	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/users/systemusers", method=RequestMethod.GET)
	public String requestSystemUsersPage(ModelMap model) {
		List<User> systemUsers = userService.findAll();
		model.addAttribute("systemUsers", systemUsers);
		logger.info("Listing no of system users " + systemUsers.size());
		return "users/systemusers";
	}
	
	@RequestMapping(value="/users/profile", method=RequestMethod.GET)
	public String requestProfileUsersPage(ModelMap model) {
		List<User> systemUsers = userService.findAll();
		model.addAttribute("systemUsers", systemUsers);
		return "users/profile";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/users/createsystemuser", method=RequestMethod.GET)
	public ModelAndView requestAddAuthUserPage(@ModelAttribute User systemUser) {
		ModelAndView mav = new ModelAndView();
		Map<String, String> sexes = SexList.getSexes();
		mav.addObject("sexes", sexes);
		Map<String, String> cities = CitiesList.getCities();
		mav.addObject("cities", cities);
		Map<String, String> countries = CountryList.getCountries();
		mav.addObject("countries", countries);
		Map<String, String> questions = QuestionsList.getQuestions();
		mav.addObject("questions", questions);
		List<Role> roles = roleService.findAll();
		mav.addObject("roles", roles);
		mav.addObject("systemUser", systemUser);
		mav.setViewName("users/createsystemuser");
		return mav;
	}
	
	@RequestMapping(value="/users/systemusers/edit/{id}", method=RequestMethod.GET)
	public String requestEditSystemUserPage(@PathVariable("id") Long id, @ModelAttribute User systemUser, ModelMap model) {
		systemUser = userService.findById(id);
		Map<String, String> sexes = SexList.getSexes();
		model.addAttribute("sexes", sexes);
		String currentSex = systemUser.getSex();
		model.addAttribute("currentSex", currentSex);
		Map<String, String> cities = CitiesList.getCities();
		model.addAttribute("cities", cities);
		String currentCity = systemUser.getCity();
		model.addAttribute("currentCity", currentCity);
		Map<String, String> countries = CountryList.getCountries();
		model.addAttribute("countries", countries);
		String currentCountry = systemUser.getCountry();
		model.addAttribute("currentCountry", currentCountry);
		Map<String, String> questions = QuestionsList.getQuestions();
		model.addAttribute("questions", questions);
		String currentQuestion = systemUser.getSecretQuestion();
		model.addAttribute("currentQuestion", currentQuestion);
		String currentAnswer = systemUser.getSecretAnswer();
		model.addAttribute("currentAnswer", currentAnswer);
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		//String currentRole = systemUser.getRole();
		//model.addAttribute("currentRole", currentRole);
		model.addAttribute("systemUser", systemUser);
		return "users/systemusers/edit";
	}

	@RequestMapping(value="/users/systemusers/show/{id}", method=RequestMethod.GET)
	public String requestShowSystemUserPage(@PathVariable("id") Long id, @ModelAttribute User systemUser, ModelMap model) {
		systemUser = userService.findById(id);
		model.addAttribute("systemUser", systemUser);
		return "users/systemusers/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value="/users/systemusers/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteSystemUserPage(@PathVariable("id") Long id, @ModelAttribute User systemUser, ModelMap model) {
		systemUser = userService.findById(id);
		model.addAttribute("systemUser", systemUser);
		return "users/systemusers/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/users/createsystemuser", method=RequestMethod.POST)
	public String addUserAccess(@Valid @ModelAttribute User systemUser, BindingResult result) {
		boolean userNameAlreadyExists = systemUser.getUsername() != null
				&& (userService.findByUsername(systemUser.getUsername()) != null);
		boolean systemIdAlreadyExists = systemUser.getSystemId() != null
				&& (userService.findBySystemId(systemUser.getSystemId()) != null);
		if (result.hasErrors() || userNameAlreadyExists) {
			if (userNameAlreadyExists) {
				result.rejectValue("username", "validation.username.alreadyExists", "Username already exists");
			}
			return "redirect:/users/createsystemuser";
		} else if ((result.hasErrors() || systemIdAlreadyExists)) {
			if (systemIdAlreadyExists) {
				result.rejectValue("systemId", "validation.systemId.alreadyExists", "System Id already exists");
			}
			return "redirect:/users/createsystemuser";
		} else {
			logger.info("Creating User Access...");
			systemUser.setOneTimeToken(uuidFactory.generateUUID());
			this.userService.save(systemUser);
			return "redirect:/users/systemusers";
		}
	}
	
	@RequestMapping(value="/users/systemusers/edit/{id}", method={RequestMethod.PUT})
	public String update(@Valid @ModelAttribute User systemUser, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.userService.save(systemUser);
			return "redirect:/users/systemusers/edit/" + UrlUtil.encodeUrlPathSegment(systemUser.getId().toString(), request);
		} else {
			return "redirect:/users/systemusers/edit/" + UrlUtil.encodeUrlPathSegment(systemUser.getId().toString(), request);
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value="/users/systemusers/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@PathVariable("id") Long id, @ModelAttribute User systemUser) {
		systemUser = userService.findById(id);
		this.userService.delete(systemUser);
		return "redirect:/users/systemusers";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/users/systemusers/usersgrid", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody GridResponse<UserDto> usersGrid(@RequestParam(value="page", required=false) Integer page, 
			@RequestParam(value="rows", required=false) Integer rows,
			@RequestParam(value="filters", required=false) String filters,
			@RequestParam(value="sidx", required=false) String sidx,
			@RequestParam(value="sord", required=false) String sord,
			@RequestParam(value="_search", required=false) Boolean search) {
		
		logger.info("Listing Users grid with page: {}, rows: {}", page, rows);
		logger.info("Listing Users grid with sort: {}, order: {}", sidx, sord);
		
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
		
		Page<User> users = userService.findAll(pageRequest);
		List<UserDto> userDtos = UserMapper.map(users);
		
		GridResponse<UserDto> response = new GridResponse<UserDto>();
		response.setRows(userDtos);
		response.setRecords(users.getTotalElements());
		response.setTotal(users.getTotalPages());
		response.setPage(users.getNumber()+1);
		return response;
	}
	
	public GridResponse<UserDto> getFilteredRecords(String filters, Pageable pageRequest) {
		String qSystemId = null;
		String qUsername = null;
		 
		GridFilter filter = GridObjectMapper.map(filters);
		for (GridFilter.Rule rule : filter.getRules()) {
			if (rule.getField().equals("systemId")) {
				qSystemId = rule.getData();
			} else if (rule.getField().equals("username")) {
				qUsername = rule.getData();
			} 
		}
		
		Page<User> users = null;
		if (qSystemId != null) {
			users = userService.findBySystemId("%"+qSystemId+"%", pageRequest);
		}
		
		if (qUsername != null) {
			users = userService.findByUsername("%"+qUsername+"%", pageRequest);
		}
		
		List<UserDto> userDtos = UserMapper.map(users);	
		GridResponse<UserDto> response = new GridResponse<UserDto>();
		response.setRows(userDtos);
		response.setRecords(users.getTotalElements());
		response.setTotal(users.getTotalPages());
		response.setPage(users.getNumber()+1);
		return response;
	}
}
