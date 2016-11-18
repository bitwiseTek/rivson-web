package com.bitwise.manageme.rssson.web.controller;
/**
 *  
 * @author Sika Kay
 * @date 14/09/16
 *
 */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitwise.manageme.rssson.domain.help.StaffManual;
import com.bitwise.manageme.rssson.domain.help.StudentManual;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentImage;
import com.bitwise.manageme.rssson.domain.students.StudentManualPDF;
import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.StaffMemberImage;
import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;
import com.bitwise.manageme.rssson.service.help.StaffManualService;
import com.bitwise.manageme.rssson.service.help.StudentManualService;
import com.bitwise.manageme.rssson.service.students.StudentService;
import com.bitwise.manageme.rssson.service.users.StaffMemberService;
import com.bitwise.manageme.rssson.web.response.UploadItem;
import com.bitwise.manageme.rssson.web.util.UrlUtil;

@Controller
public class FileUploadController {
	
	final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StaffMemberService staffService;
	
	@Autowired
	private StudentManualService studentManualService;
	
	@Autowired
	private StaffManualService staffManualService;
	
	@RequestMapping(value="/students/show/fileupload", method=RequestMethod.POST)
	public String processUpload(@RequestParam("file") Part file, UploadItem uploadItem, BindingResult result, ModelMap model, HttpServletRequest request) throws IOException {
		Long studentId = uploadItem.getStudentId();
		String uploadType = uploadItem.getUploadType();
		
		if (!result.hasErrors()) {
			if (file.getSize() > 0) {
				if (uploadType.equalsIgnoreCase("student")) {
					StudentImage image = new StudentImage();
					image.setFileName(getFileName(file));
					image.setFileData(IOUtils.toByteArray(file.getInputStream()));
					image.setContentType(file.getContentType());
					Student student = studentService.findById(studentId);
					image.setStudent(student);
					student.addImage(image);
					studentService.save(student);
				}
			}
		}
		return "redirect:/students/show/" + UrlUtil.encodeUrlPathSegment(studentId.toString(), request);
	}
	
	@RequestMapping(value="/staff/show/fileupload", method=RequestMethod.POST)
	public String processStaffUpload(@RequestParam("file") Part file, UploadItem uploadItem, BindingResult result, ModelMap model, HttpServletRequest request) throws IOException {
		Long staffId = uploadItem.getStaffId();
		String uploadType = uploadItem.getUploadType();
		
		if (!result.hasErrors()) {
			if (file.getSize() > 0) {
				if (uploadType.equalsIgnoreCase("staff")) {
					StaffMemberImage image = new StaffMemberImage();
					image.setFileName(getFileName(file));
					image.setFileData(IOUtils.toByteArray(file.getInputStream()));
					image.setContentType(file.getContentType());
					StaffMember staff = staffService.findById(staffId);
					image.setStaff(staff);
					staff.addImage(image);
					staffService.save(staff);
				}
			}
		}
		return "redirect:/staff/show/" + UrlUtil.encodeUrlPathSegment(staffId.toString(), request);
	}
	
	@RequestMapping(value="/settings/students/manuals/show/fileupload", method=RequestMethod.POST)
	public String processStudentManualUpload(@RequestParam("file") Part file, UploadItem uploadItem, BindingResult result, HttpServletRequest request) throws IOException {
		Long studentManualId = uploadItem.getStudentManualId();
		String uploadType = uploadItem.getUploadType();
		
		if (!result.hasErrors()) {
			if (file.getSize() > 0) {
				if (uploadType.equalsIgnoreCase("studentManual")) {
					StudentManualPDF pdf = new StudentManualPDF();
					pdf.setFileName(getFileName(file));
					pdf.setFileData(IOUtils.toByteArray(file.getInputStream()));
					pdf.setContentType(file.getContentType());
					StudentManual studentManual = studentManualService.findById(studentManualId);
					pdf.setStudentManual(studentManual);
					studentManual.addPDF(pdf);
					studentManualService.save(studentManual);
				}
			}
		}
		return "redirect:/settings/students/manuals/show/" + UrlUtil.encodeUrlPathSegment(studentManualId.toString(), request);
	}
	
	@RequestMapping(value="/settings/staff/manuals/fileupload", method=RequestMethod.POST)
	public String processStaffManualUpload(@RequestParam("file") Part file, UploadItem uploadItem, BindingResult result, ModelMap model, HttpServletRequest request) throws IOException {
		Long staffManualId = uploadItem.getStaffManualId();
		String uploadType = uploadItem.getUploadType();
		
		if (!result.hasErrors()) {
			if (file.getSize() > 0) {
				if (uploadType.equalsIgnoreCase("staffManual")) {
					StaffMemberManualPDF pdf = new StaffMemberManualPDF();
					pdf.setFileName(getFileName(file));
					pdf.setFileData(IOUtils.toByteArray(file.getInputStream()));
					pdf.setContentType(file.getContentType());
					StaffManual staffManual = staffManualService.findById(staffManualId);
					pdf.setStaffManual(staffManual);
					staffManual.addPDF(pdf);
					staffManualService.save(staffManual);
				}
			}
		}
		return "redirect:/settings/staff/manuals/show/" + UrlUtil.encodeUrlPathSegment(staffManualId.toString(), request);
	}
	
	private String getFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		logger.info("Part Header: " + partHeader);
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
