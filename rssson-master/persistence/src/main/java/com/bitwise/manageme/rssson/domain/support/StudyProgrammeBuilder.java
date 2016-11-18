package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;

@Component
public class StudyProgrammeBuilder extends EntityBuilder<StudyProgramme> {

	@Override
	void initProduct() {
		this.product = new StudyProgramme();
	}
	
	public StudyProgrammeBuilder studyProgrammeCategory(StudyProgrammeCategory category) {
		this.product.setCategory(category);
		return this;
	}
	
	public StudyProgrammeBuilder programme(String name, String code, Boolean archived) {
		this.product.setName(name);
		this.product.setCode(code);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	StudyProgramme assembleProduct() {
		return this.product;
	}

}
