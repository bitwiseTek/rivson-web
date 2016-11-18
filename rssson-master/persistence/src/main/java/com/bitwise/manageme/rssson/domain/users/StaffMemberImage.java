package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
 *
 */
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.util.forms.StaffImageAttachment;

@Entity
@Table(name="WEB_RSSSON_STAFF_IMAGES")
@NamedQueries({
	@NamedQuery(name="StaffMemberImage.findById", query="select distinct s from StaffMemberImage s where s.id=:id"),
	@NamedQuery(name="StaffMemberImage.findAll", query="select s from StaffMemberImage s")
})
public class StaffMemberImage extends StaffImageAttachment {

private static final long serialVersionUID = 1L;
	
	private StaffMember staff;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STAFF_MEMBER_ID")
	public StaffMember getStaff() {
		return staff;
	}

	public void setStaff(StaffMember staff) {
		this.staff = staff;
	}
}
