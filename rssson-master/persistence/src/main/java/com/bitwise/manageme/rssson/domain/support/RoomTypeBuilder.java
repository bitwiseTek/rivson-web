package com.bitwise.manageme.rssson.domain.support;

import com.bitwise.manageme.rssson.domain.accommodation.RoomType;

public class RoomTypeBuilder extends EntityBuilder<RoomType>{

	@Override
	void initProduct() {
		this.product = new RoomType();
	}
	
	public RoomTypeBuilder type(String name) {
		this.product.setName(name);
		return this;
	}
	
	@Override
	RoomType assembleProduct() {
		return this.product;
	}

}
