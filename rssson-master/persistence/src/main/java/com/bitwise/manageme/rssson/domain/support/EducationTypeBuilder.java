package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.EducationType;

@Component
public class EducationTypeBuilder extends EntityBuilder<EducationType> {

	@Override
	void initProduct() {
		this.product = new EducationType();
	}
	
	public EducationTypeBuilder educationType(String name, String code, Boolean archived) {
		this.product.setName(name);
		this.product.setCode(code);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	EducationType assembleProduct() {
		return this.product;
	}

}
