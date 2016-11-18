package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class StaffMemberBuilder extends EntityBuilder<StaffMember> {

	@Override
	void initProduct() {
		this.product = new StaffMember();
	}
	
	public StaffMemberBuilder user(User user) {
		this.product.setUser(user);
		return this;
	}
	
	public StaffMemberBuilder state(String state) {
		this.product.setStateOfOrigin(state);
		return this;
	}
	
	public StaffMemberBuilder lga(LGA lga) {
		this.product.setLga(lga);
		return this;
	}
	
	public StaffMemberBuilder member(String title, String staffId) {
		this.product.setTitle(title);
		this.product.setStaffId(staffId);
		return this;
	}
	
	public StaffMemberBuilder staffDetails(String additionalInfo, String nationality, Boolean isAcademic, Boolean isTemporary, Boolean archived) {
		this.product.setAdditionalInfo(additionalInfo);
		this.product.setNationality(nationality);
		this.product.setIsAcademic(isAcademic);
		this.product.setIsTemporary(isTemporary);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	StaffMember assembleProduct() {
		return this.product;
	}

}
