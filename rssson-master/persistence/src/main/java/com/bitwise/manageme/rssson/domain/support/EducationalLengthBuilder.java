package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;

@Component
public class EducationalLengthBuilder extends EntityBuilder<EducationalLength> {

	@Override
	void initProduct() {
		this.product = new EducationalLength();
	}
	
	public EducationalLengthBuilder educationalTimeUnit(EducationalTimeUnit unit) {
		this.product.setUnit(unit);
		return this;
	}
	
	public EducationalLengthBuilder length(Double units) {
		this.product.setUnits(units);
		return this;
	}

	@Override
	EducationalLength assembleProduct() {
		return this.product;
	}

}
