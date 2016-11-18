package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.help.StaffManual;
import com.bitwise.manageme.rssson.util.forms.StaffPDFAttachment;

@Entity
@Table(name="WEB_RSSSON_STAFF_MANUAL_PDFs")
@NamedQueries({
	@NamedQuery(name="StaffMemberManualPDF.findById", query="select distinct s from StaffMemberManualPDF s where s.id=:id"),
	@NamedQuery(name="StaffMemberManualPDF.findAll", query="select s from StaffMemberManualPDF s")
})
public class StaffMemberManualPDF extends StaffPDFAttachment {

	private static final long serialVersionUID = 1L;
	
	private StaffManual staffManual;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STAFF_MANUAL_ID")
	public StaffManual getStaffManual() {
		return staffManual;
	}

	public void setStaffManual(StaffManual staffManual) {
		this.staffManual = staffManual;
	}
}
