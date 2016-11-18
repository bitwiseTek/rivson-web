package com.bitwise.manageme.rssson.domain.support;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;

public class RoomBuilder extends EntityBuilder<Room>{

	@Override
	void initProduct() {
		this.product = new Room();
	}

	public RoomBuilder type(RoomType type) {
		this.product.setType(type);
		return this;
	}
	
	public RoomBuilder room(String name) {
		this.product.setName(name);
		return this;
	}
	
	@Override
	Room assembleProduct() {
		return this.product;
	}

}
