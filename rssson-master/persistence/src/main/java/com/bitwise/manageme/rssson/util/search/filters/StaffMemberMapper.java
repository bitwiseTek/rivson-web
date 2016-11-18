package com.bitwise.manageme.rssson.util.search.filters;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.dto.user.StaffMemberDto;

public class StaffMemberMapper {

	
	public static StaffMemberDto map(StaffMember staff) {
		StaffMemberDto dto = new StaffMemberDto();
		dto.setId(staff.getId());
		dto.setStaffId(staff.getStaffId());
		dto.setTitle(staff.getTitle());
		dto.setNationality(staff.getNationality());
		dto.setStateOfOrigin(staff.getStateOfOrigin());
		dto.setLga(staff.getLga());
		dto.setIsAcademic(staff.getIsAcademic());
		dto.setIsTemporary(staff.getIsTemporary());
		dto.setAdditionalInfo(staff.getAdditionalInfo());
		return dto;
	}

	public static List<StaffMemberDto> map(Page<StaffMember> staff) {
		List<StaffMemberDto> dtos = new ArrayList<StaffMemberDto>();
		for (StaffMember staffMember: staff) {
			dtos.add(map(staffMember));
		}
		return dtos;
 	}
}
