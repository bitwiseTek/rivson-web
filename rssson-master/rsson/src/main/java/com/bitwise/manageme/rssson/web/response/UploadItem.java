package com.bitwise.manageme.rssson.web.response;
/**
 *  
 * @author Sika Kay
 * @date 13/09/16
 *
 */
public class UploadItem {
	
	private Long studentId;
	
	private Long staffId;
	
	private Long studentManualId;
	
	private Long staffManualId;
	
	private String uploadType;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public Long getStudentManualId() {
		return studentManualId;
	}

	public void setStudentManualId(Long studentManualId) {
		this.studentManualId = studentManualId;
	}

	public Long getStaffManualId() {
		return staffManualId;
	}

	public void setStaffManualId(Long staffManualId) {
		this.staffManualId = staffManualId;
	}
}
