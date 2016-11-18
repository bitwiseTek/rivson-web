package com.bitwise.manageme.rssson.dto.user;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import java.io.Serializable;

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.users.StaffMember;

public class StaffMemberDto extends StaffMember implements Serializable {

	public StaffMemberDto() {
		
	}
	
	public StaffMemberDto(String title, String staffId, String nationality, String stateOfOrigin, LGA lga) {
		super();
		this.staffId = staffId;
		this.title = title;
		this.nationality = nationality;
		this.stateOfOrigin = stateOfOrigin;
		this.lga = lga;
	}
	
	private static final long serialVersionUID = 1L;

	private String staffId;
	
	private String title;
	
	private String nationality;
	
	private String stateOfOrigin;
	
	private LGA lga;
	
	private Boolean isAcademic;
	
	private Boolean isTemporary;
	
	private String additionalInfo;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStateOfOrigin() {
		return stateOfOrigin;
	}

	public void setStateOfOrigin(String stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
	}

	public LGA getLga() {
		return lga;
	}

	public void setLga(LGA lga) {
		this.lga = lga;
	}

	public Boolean getIsAcademic() {
		return isAcademic;
	}

	public void setIsAcademic(Boolean isAcademic) {
		this.isAcademic = isAcademic;
	}

	public Boolean getIsTemporary() {
		return isTemporary;
	}

	public void setIsTemporary(Boolean isTemporary) {
		this.isTemporary = isTemporary;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
