package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.domain.users.User;

@Component
public class ProjectBuilder extends EntityBuilder<Project> {

	@Override
	void initProduct() {
		this.product = new Project();
	}

	public ProjectBuilder user(User user) {
		this.product.setCreator(user);
		return this;
	}
	
	public ProjectBuilder modifier(User lastModifier) {
		this.product.setLastModifier(lastModifier);
		return this;
	}

	public ProjectBuilder educationalLength(EducationalLength length) {
		this.product.setOptionalStudiesLength(length);
		return this;
	}
	
	public ProjectBuilder projectDetails(String name, String description, Date created, Date lastModified, Boolean archived) {
		this.product.setName(name);
		this.product.setDescription(description);
		this.product.setCreated(created);
		this.product.setLastModified(lastModified);
		this.product.setArchived(archived);
		return this;
	}
	
	@Override
	Project assembleProduct() {
		return this.product;
	}

}
