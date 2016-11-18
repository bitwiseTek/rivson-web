package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.AcademicSemester;

@Component
public class AcademicSemesterBuilder extends EntityBuilder<AcademicSemester> {

	@Override
	void initProduct() {
		this.product = new AcademicSemester();
	}

	public AcademicSemesterBuilder semester(String name, Date startDate, Date endDate, String session, Boolean archived) {
		this.product.setName(name);
		this.product.setStartDate(startDate);
		this.product.setEndDate(endDate);
		this.product.setSession(session);
		this.product.setArchived(archived);
		return this;
	}
	
	@Override
	AcademicSemester assembleProduct() {
		return this.product;
	}

}
