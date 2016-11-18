package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.grading.GradingScale;

@Component
public class GradingScaleBuilder extends EntityBuilder<GradingScale> {

	@Override
	void initProduct() {
		this.product = new GradingScale();
	}
	
	public GradingScaleBuilder scale(String name, String description, Boolean archived) {
		this.product.setName(name);
		this.product.setDescription(description);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	GradingScale assembleProduct() {
		return this.product;
	}

}
