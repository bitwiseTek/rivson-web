package com.bitwise.manageme.rssson.web.controller.settings;
/**
 *  
 * @author Sika Kay
 * @date 10/07/16
 *
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.manageme.rssson.service.base.AcademicSemesterService;
import com.bitwise.manageme.rssson.service.courses.CourseService;
import com.bitwise.manageme.rssson.service.courses.CourseStaffMemberService;
import com.bitwise.manageme.rssson.util.forms.LevelList;
import com.bitwise.manageme.rssson.util.forms.UnitList;
import com.bitwise.manageme.rssson.util.validator.SubjectValidator;
import com.bitwise.manageme.rssson.domain.base.AcademicSemester;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.service.base.CourseBaseService;
import com.bitwise.manageme.rssson.service.base.EducationTypeService;
import com.bitwise.manageme.rssson.service.base.SubjectService;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class SubjectController {

	final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CourseBaseService courseBaseService;
	
	@Autowired
	private EducationTypeService eduTypeService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseStaffMemberService staffService;
	
	@Autowired
	private AcademicSemesterService semesterService;
	
	@InitBinder("subject")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new SubjectValidator());
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/subjects", method=RequestMethod.GET)
	public ModelAndView requestSubjectsPage() {
		ModelAndView mav = new ModelAndView();
		List<Subject> subjects = subjectService.findAll();
		mav.addObject("subjects", subjects);
		mav.setViewName("settings/subjects");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createsubject", method=RequestMethod.GET)
	public ModelAndView requestAddSubjectPage(@ModelAttribute Subject subject) {
		ModelAndView mav = new ModelAndView();
		Map<Integer, String> levels = LevelList.getLevels();
		mav.addObject("levels", levels);
		Map<Integer, String> units = UnitList.getUnits();
		mav.addObject("units", units);
		List<CourseBase> courseBases = courseBaseService.findAll();
		mav.addObject("courseBases", courseBases);
		List<EducationType> educationTypes = eduTypeService.findAll();
		mav.addObject("educationTypes", educationTypes);
		List<Course> courses = courseService.findAll();
		mav.addObject("courses", courses);
		List<CourseStaffMember> lecturers = staffService.findAll();
		mav.addObject("lecturers", lecturers);
		List<AcademicSemester> semesters = semesterService.findAll();
		mav.addObject("semesters", semesters);
		mav.addObject("subject", subject);
		mav.setViewName("settings/createsubject");
		return mav;
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/subjects/edit/{id}", method=RequestMethod.GET)
	public String requestEditSubjectPage(@PathVariable("id") Long id, @ModelAttribute Subject subject, ModelMap model) {
		subject = subjectService.findById(id);
		Map<Integer, String> levels = LevelList.getLevels();
		model.addAttribute("levels", levels);
		Integer currentLevel = subject.getAcademicLevel();
		model.addAttribute("currentLevel", currentLevel);
		Map<Integer, String> units = UnitList.getUnits();
		model.addAttribute("units", units);
		Integer currentUnit = subject.getCreditUnit();
		model.addAttribute("currentUnit", currentUnit);
		List<CourseBase> courseBases = courseBaseService.findAll();
		model.addAttribute("courseBases", courseBases);
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		String currentCourse = subject.getCourse().getName();
		model.addAttribute("currentCourse", currentCourse);
		List<CourseStaffMember> lecturers = staffService.findAll();
		model.addAttribute("lecturers", lecturers);
		String currentLecturer = subject.getSubjectLecturer().getStaffMember().getUser().getFullName();
		model.addAttribute("currentLecturer", currentLecturer);
		List<AcademicSemester> semesters = semesterService.findAll();
		model.addAttribute("semesters", semesters);
		String currentSemester = subject.getSemester().getName();
		model.addAttribute("currentSemester", currentSemester);
		List<EducationType> educationTypes = eduTypeService.findAll();
		model.addAttribute("educationTypes", educationTypes);
		String currentEduType = subject.getEducationType().getName();
		model.addAttribute("currentEduType", currentEduType);
		model.addAttribute("subject", subject);
		return "settings/subjects/edit";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/subjects/delete/{id}", method=RequestMethod.GET)
	public String requestDeleteSubjectPage(@PathVariable("id") Long id, @ModelAttribute Subject subject, ModelMap model) {
		subject = subjectService.findById(id);
		model.addAttribute("subject", subject);
		return "settings/subjects/delete";
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/createsubject", method=RequestMethod.POST)
	public String addSubject(@Valid @ModelAttribute Subject subject, BindingResult result) {
		boolean subjectAlreadyExists = subject.getName() != null
				&& (subjectService.findByName(subject.getName()) != null);
		boolean subjectCodeAlreadyExists = subject.getCode() != null
				&& (subjectService.findByCode(subject.getCode()) != null);
		if (result.hasErrors() || subjectAlreadyExists) {
			if (subjectAlreadyExists) {
				result.rejectValue("name", "validation.subject.alreadyExists", "Subject already exists");
			}
			return "redirect:/settings/createsubject";
		} else if (result.hasErrors() || subjectCodeAlreadyExists) {
			if (subjectCodeAlreadyExists) {
				result.rejectValue("code", "validation.subjectcode.alreadyExists", "School code already exists");
			}
			return "redirect:/settings/createsubject";
		} else {
			logger.info("Creating Subject...");
			this.subjectService.save(subject);
			return "redirect:/settings/subjects";
		}
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/subjects/edit/{id}", method={RequestMethod.PUT})
	public String update(@ModelAttribute Subject subject, HttpServletRequest request) {
		this.subjectService.save(subject);
		return "redirect:/settings/subjects/edit/" + UrlUtil.encodeUrlPathSegment(subject.getId().toString(), request);
	}
	
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')")
	@RequestMapping(value="/settings/subjects/delete/{id}", method={RequestMethod.DELETE})
	public String delete(@ModelAttribute Subject subject) {
		this.subjectService.delete(subject);
		return "redirect:/settings/subjects";
	}
}
