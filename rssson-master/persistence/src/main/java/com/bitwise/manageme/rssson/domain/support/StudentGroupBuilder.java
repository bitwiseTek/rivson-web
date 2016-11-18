package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class StudentGroupBuilder extends EntityBuilder<StudentGroup> {

	@Override
	void initProduct() {
		this.product = new StudentGroup();
	}
	
	public StudentGroupBuilder user(User creator) {
		this.product.setCreator(creator);
		return this;
	}
	
	public StudentGroupBuilder modifier(User lastModifier) {
		this.product.setLastModifier(lastModifier);
		return this;
	}

	public StudentGroupBuilder group(String name, String description, Date beginDate, Date created, Date lastModified) {
		this.product.setName(name);
		this.product.setDescription(description);
		this.product.setBeginDate(beginDate);
		this.product.setCreated(created);
		this.product.setLastModified(lastModified);
		return this;
	}

	@Override
	StudentGroup assembleProduct() {
		return this.product;
	}

}
