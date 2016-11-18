package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;

@Component
public class StudyProgrammeCategoryBuilder extends EntityBuilder<StudyProgrammeCategory> {

	@Override
	void initProduct() {
		this.product = new StudyProgrammeCategory();
	}
	
	public StudyProgrammeCategoryBuilder educationType(EducationType type) {
		this.product.setEducationType(type);
		return this;
	}
	
	public StudyProgrammeCategoryBuilder programmeCategory(String name, Boolean archived) {
		this.product.setName(name);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	StudyProgrammeCategory assembleProduct() {
		return this.product;
	}

}
