package com.bitwise.manageme.rssson.web.controller;
/**
 *  
 * @author Sika Kay
 * @date 14/09/16
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitwise.manageme.rssson.domain.students.StudentImage;
import com.bitwise.manageme.rssson.domain.students.StudentManualPDF;
import com.bitwise.manageme.rssson.domain.users.StaffMemberImage;
import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;
import com.bitwise.manageme.rssson.service.students.StudentImageService;
import com.bitwise.manageme.rssson.service.students.StudentManualPDFService;
import com.bitwise.manageme.rssson.service.users.StaffMemberImageService;
import com.bitwise.manageme.rssson.service.users.StaffMemberManualPDFService;

@Controller
public class FileDownloadController {
	
	private Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	
	@Autowired
	private StudentImageService imageService;
	
	@Autowired
	private StaffMemberImageService staffImageService;
	
	@Autowired
	private StudentManualPDFService pdfService;
	
	@Autowired
	private StaffMemberManualPDFService staffPdfService;
	
	@ResponseBody
	@RequestMapping(value="/students/show/filedownload/student/{id}", method=RequestMethod.GET, produces="application/force-download")
	public byte[] downloadImage(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Processing download of image with ID: " + id);
		StudentImage image = imageService.findById(id);
		response.setContentType(image.getContentType());
		response.setContentLength(image.getFileData().length);
		response.setHeader("Content-Disposition", "image; filename=\"" + image.getFileName() + "\"");
		return image.getFileData();
	}
	
	@ResponseBody
	@RequestMapping(value="/staff/show/filedownload/staff/{id}", method=RequestMethod.GET, produces="application/force-download")
	public byte[] downloadStaffImage(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Processing download of image with ID: " + id);
		StaffMemberImage image = staffImageService.findById(id);
		response.setContentType(image.getContentType());
		response.setContentLength(image.getFileData().length);
		response.setHeader("Content-Disposition", "image; filename=\"" + image.getFileName() + "\"");
		return image.getFileData();
	}
	
	@ResponseBody
	@RequestMapping(value="/students/manual/filedownload/students/{id}", method=RequestMethod.GET, produces="application/force-download")
	public byte[] downloadStudentPDF(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Processing download of pdf with ID: " + id);
		StudentManualPDF pdf = pdfService.findById(id);
		response.setContentType(pdf.getContentType());
		response.setContentLength(pdf.getFileData().length);
		response.setHeader("Content-Disposition", "pdf; filename=\"" + pdf.getFileName() + "\"");
		return pdf.getFileData();
	}
	
	@ResponseBody
	@RequestMapping(value="/staff/manual/filedownload/staff/{id}", method=RequestMethod.GET, produces="application/force-download")
	public byte[] downloadStaffPDF(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Processing download of pdf with ID: " + id);
		StaffMemberManualPDF pdf = staffPdfService.findById(id);
		response.setContentType(pdf.getContentType());
		response.setContentLength(pdf.getFileData().length);
		response.setHeader("Content-Disposition", "pdf; filename=\"" + pdf.getFileName() + "\"");
		return pdf.getFileData();
	}

}
