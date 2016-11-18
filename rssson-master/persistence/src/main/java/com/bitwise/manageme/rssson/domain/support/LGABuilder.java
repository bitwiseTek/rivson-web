package com.bitwise.manageme.rssson.domain.support;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.LGA;

@Component
public class LGABuilder extends EntityBuilder<LGA> {

	@Override
	void initProduct() {
		this.product = new LGA();
	}
	
	public LGABuilder lga(String name, String code, Boolean archived) {
		this.product.setName(name);
		this.product.setCode(code);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	LGA assembleProduct() {
		return this.product;
	}

}
