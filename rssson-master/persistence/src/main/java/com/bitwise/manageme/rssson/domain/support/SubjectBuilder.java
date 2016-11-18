package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.Subject;

@Component
public class SubjectBuilder extends EntityBuilder<Subject> {

	@Override
	void initProduct() {
		this.product = new Subject();
	}
	
	public SubjectBuilder courseBase(CourseBase base) {
		this.product.setCourseBase(base);
		return this;
	}
	
	public SubjectBuilder educationType(EducationType type) {
		this.product.setEducationType(type);
		return this;
	}
	
	public SubjectBuilder subject(String code, String name, Boolean archived) {
		this.product.setCode(code);
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	Subject assembleProduct() {
		return this.product;
	}

}
