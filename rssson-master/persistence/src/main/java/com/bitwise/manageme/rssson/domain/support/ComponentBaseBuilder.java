package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.ComponentBase;
import com.bitwise.manageme.rssson.domain.base.EducationalLength;

@Component
public class ComponentBaseBuilder extends EntityBuilder<ComponentBase> {

	@Override
	void initProduct() {
		this.product = new ComponentBase();
	}
	
	public ComponentBaseBuilder educationalLength(EducationalLength eduLength) {
		this.product.setLength(eduLength);
		return this;
	}
	
	public ComponentBaseBuilder base(String name, String description, Boolean archived) {
		this.product.setName(name);
		this.product.setDescription(description);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	ComponentBase assembleProduct() {
		return this.product;
	}

}
