package com.bitwise.manageme.rssson.web.controller.student;
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
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.util.forms.NationalityList;
import com.bitwise.manageme.rssson.util.forms.StateList;
import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentActivityType;
import com.bitwise.manageme.rssson.domain.students.StudentEducationalLevel;
import com.bitwise.manageme.rssson.domain.students.StudentExaminationType;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.dto.student.StudentDto;
import com.bitwise.manageme.rssson.service.accommodation.RoomService;
import com.bitwise.manageme.rssson.service.base.BillingDetailsService;
import com.bitwise.manageme.rssson.service.base.LGAService;
import com.bitwise.manageme.rssson.service.base.StudyProgrammeService;
import com.bitwise.manageme.rssson.service.students.StudentActivityTypeService;
import com.bitwise.manageme.rssson.service.students.StudentEducationalLevelService;
import com.bitwise.manageme.rssson.service.students.StudentExaminationTypeService;
import com.bitwise.manageme.rssson.service.students.StudentService;
import com.bitwise.manageme.rssson.service.students.StudentStudyEndReasonService;
import com.bitwise.manageme.rssson.service.users.UserService;
import com.bitwise.manageme.rssson.util.search.filters.GridFilter;
import com.bitwise.manageme.rssson.util.search.filters.GridObjectMapper;
import com.bitwise.manageme.rssson.util.search.filters.StudentMapper;
import com.bitwise.manageme.rssson.util.validator.StudentValidator;
import com.bitwise.manageme.rssson.web.response.GridResponse;
import com.bitwise.manageme.rssson.web.response.UploadItem;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class StudentController {

	final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentActivityTypeService typeService;
	
	@Autowired
	private StudentExaminationTypeService examService;
	
	@Autowired
	private StudentEducationalLevelService eduLevelService;
	
	@Autowired
	private StudyProgrammeService programmeService;
	
	@Autowired
	private StudentStudyEndReasonService endReasonService;
	
	@Autowired
	private LGAService lgaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BillingDetailsService billingService;
	
	@Autowired
	private RoomService roomService;
	
	@InitBinder("student")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String requestStudentsPage(ModelMap model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		logger.info("Listing no of students " + students.size());
		return "students";
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/billinginfo", method=RequestMethod.GET)
	public ModelAndView requestBillingInfoPage() {
		ModelAndView mav = new ModelAndView();
		List<BillingDetails> billingInfos = billingService.findAll();
		mav.addObject("billingInfos", billingInfos);
		mav.setViewName("students/billinginfo");
		return mav;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/timetable", method=RequestMethod.GET)
	public ModelAndView requestTimeTablePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("students/timetable");
		return mav;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/studentinfo", method=RequestMethod.GET)
	public ModelAndView requestStudentInfoPage() {
		ModelAndView mav = new ModelAndView();
		List<Student> students = studentService.findAll();
		mav.addObject("students", students);
		mav.setViewName("students/studentinfo");
		return mav;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@RequestMapping(value="/students/accommodation", method=RequestMethod.GET)
	public ModelAndView requestAccInfoPage() {
		ModelAndView mav = new ModelAndView();
		List<Room> rooms = roomService.findAll();
		mav.addObject("rooms", rooms);
		mav.setViewName("students/accommodation");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students/createstudent", method=RequestMethod.GET)
	public ModelAndView requestAddStudentPage(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView();
		List<StudentActivityType> activities = typeService.findAll();
		mav.addObject("activities", activities);
		List<StudentExaminationType> examTypes = examService.findAll();
		mav.addObject("examTypes", examTypes);
		List<StudentEducationalLevel> eduLevels = eduLevelService.findAll();
		mav.addObject("eduLevels", eduLevels);
		List<StudyProgramme> programmes = programmeService.findAll();
		mav.addObject("programmes", programmes);
		List<StudentStudyEndReason> endReasons = endReasonService.findAll();
		mav.addObject("endReasons", endReasons);
		List<User> users = userService.findAll();
		mav.addObject("users", users);
		Map<String, String> nationalities = NationalityList.getNationalities();
		mav.addObject("nationalities", nationalities);
		Map<String, String> states = StateList.getStates();
		mav.addObject("states", states);
		List<LGA> lgas = lgaService.findAll();
		mav.addObject("lgas", lgas);
		mav.addObject("student", student);
		mav.setViewName("students/createstudent");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students/show/{id}", method=RequestMethod.GET)
	public String requestShowStudentPage(@PathVariable("id") Long id, ModelMap model) {
		Student student = studentService.findById(id);
		UploadItem uploadItem = new UploadItem();
		uploadItem.setStudentId(student.getId());
		model.addAttribute("uploadItem", uploadItem);
		model.addAttribute("student", student);
		return "students/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR') or hasRole('STUDENT')")
	@RequestMapping(value="/students/billinginfo/show/{id}", method=RequestMethod.GET)
	public String requestBillingInfoPage(@PathVariable("id") Long id, @ModelAttribute BillingDetails billingInfo, ModelMap model) {
		billingInfo = billingService.findById(id);
		model.addAttribute("billingInfo", billingInfo);
		return "students/billinginfo/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR') or hasRole('STUDENT')")
	@RequestMapping(value="/students/studentinfo/show/{id}", method=RequestMethod.GET)
	public String requestStudentInfoPage(@PathVariable("id") Long id, @ModelAttribute Student student, ModelMap model) {
		student = studentService.findById(id);
		model.addAttribute("student", student);
		return "students/studentinfo/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR') or hasRole('STUDENT')")
	@RequestMapping(value="/students/accommodation/show/{id}", method=RequestMethod.GET)
	public String requestAccInfoPage(@PathVariable("id") Long id, @ModelAttribute Room room, ModelMap model) {
		room = roomService.findById(id);
		model.addAttribute("room", room);
		return "students/accommodation/show";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students/edit/{id}", method=RequestMethod.GET)
	public String requestEditStudentPage(@PathVariable("id") Long id, @ModelAttribute Student student, ModelMap model) {
		student = studentService.findById(id);
		Map<String, String> nationalities = NationalityList.getNationalities();
		model.addAttribute("nationalities", nationalities);
		String currentNationality = student.getNationality();
		model.addAttribute("currentNationality", currentNationality);
		Map<String, String> states = StateList.getStates();
		model.addAttribute("states", states);
		String currentState = student.getStateOfOrigin();
		model.addAttribute("currentState", currentState);
		List<LGA> lgas = lgaService.findAll();
		model.addAttribute("lgas", lgas);
		String currentLga = student.getLga().getName();
		model.addAttribute("currentLga", currentLga);
		List<StudentExaminationType> examTypes = examService.findAll();
		model.addAttribute("examTypes", examTypes);
		List<StudentActivityType> activities = typeService.findAll();
		model.addAttribute("activities", activities);
		List<StudyProgramme> programmes = programmeService.findAll();
		model.addAttribute("programmes", programmes);
		List<StudentStudyEndReason> endReasons = endReasonService.findAll();
		model.addAttribute("endReasons", endReasons);
		model.addAttribute("student", student);
		return "students/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value="/students/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteStudentPage(@PathVariable("id") Long id, @ModelAttribute Student student, ModelMap model) {
		student = studentService.findById(id);
		model.addAttribute("student", student);
		return "students/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students/createstudent", method=RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute Student student, BindingResult result) {
		boolean studentAlreadyExists = student.getStudentId() != null
				&& (studentService.findByStudentId(student.getStudentId()) != null);
		if (result.hasErrors() || studentAlreadyExists) {
			if (studentAlreadyExists) {
				result.rejectValue("studentId", "validation.student.alreadyExists", "Student already exists");
			}
			return "redirect:/students/createstudent";
		} else {
			logger.info("Creating Student...");
			this.studentService.save(student);
			return "redirect:/students";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students/edit/{id}", method={RequestMethod.PUT})
	public String update(@Valid @ModelAttribute Student student, BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			this.studentService.save(student);
			return "redirect:/students/edit/" + UrlUtil.encodeUrlPathSegment(student.getId().toString(), request);
		} else {
			return "redirect:/students/edit/" + UrlUtil.encodeUrlPathSegment(student.getId().toString(), request);
		}
		
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN')")
	@RequestMapping(value="/students/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute Student student) {
		this.studentService.delete(student);
		return "redirect:/students";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/students/studentsgrid", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody GridResponse<StudentDto> studentsGrid(@RequestParam(value="page", required=false) Integer page, 
			@RequestParam(value="rows", required=false) Integer rows,
			@RequestParam(value="filters", required=false) String filters,
			@RequestParam(value="sidx", required=false) String sidx,
			@RequestParam(value="sord", required=false) String sord,
			@RequestParam(value="_search", required=false) Boolean search) {
		
		logger.info("Listing Students grid with page: {}, rows: {}", page, rows);
		logger.info("Listing Students grid with sort: {}, order: {}", sidx, sord);
		
		Sort sort = null;
		String orderBy = sidx;
		if (orderBy != null && orderBy.equals("studyStartDateString")) orderBy = "studyStartDate";
		
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
		
		Page<Student> students = studentService.findAll(pageRequest);
		List<StudentDto> studentDtos = StudentMapper.map(students);
		
		GridResponse<StudentDto> response = new GridResponse<StudentDto>();
		response.setRows(studentDtos);
		response.setRecords(students.getTotalElements());
		response.setTotal(students.getTotalPages());
		response.setPage(students.getNumber()+1);
		return response;
	}
	
	public GridResponse<StudentDto> getFilteredRecords(String filters, Pageable pageRequest) {
		String qStudentId = null;
		 
		GridFilter filter = GridObjectMapper.map(filters);
		for (GridFilter.Rule rule : filter.getRules()) {
			if (rule.getField().equals("studentId")) {
				qStudentId = rule.getData();
			}
		}
		
		Page<Student> students = null;
		if (qStudentId != null) {
			students = studentService.findByStudentId("%"+qStudentId+"%", pageRequest);
		}
		
		List<StudentDto> studentDtos = StudentMapper.map(students);
		GridResponse<StudentDto> response = new GridResponse<StudentDto>();
		response.setRows(studentDtos);
		response.setRecords(students.getTotalElements());
		response.setTotal(students.getTotalPages());
		response.setPage(students.getNumber()+1);
		return response;
	}
}
