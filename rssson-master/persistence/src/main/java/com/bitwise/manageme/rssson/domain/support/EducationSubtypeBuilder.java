package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.EducationSubtype;
import com.bitwise.manageme.rssson.domain.base.EducationType;

@Component
public class EducationSubtypeBuilder extends EntityBuilder<EducationSubtype> {

	@Override
	void initProduct() {
		this.product = new EducationSubtype();
	}
	
	public EducationSubtypeBuilder educationType(EducationType type) {
		this.product.setEducationType(type);
		return this;
	}
	
	public EducationSubtypeBuilder subtype(String name, String code, Boolean archived) {
		this.product.setName(name);
		this.product.setCode(code);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	EducationSubtype assembleProduct() {
		return this.product;
	}

}
