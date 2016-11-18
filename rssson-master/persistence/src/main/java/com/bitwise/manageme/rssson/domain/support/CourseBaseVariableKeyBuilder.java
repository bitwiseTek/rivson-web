package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.CourseBaseVariableKey;
import com.bitwise.manageme.rssson.domain.base.VariableType;

@Component
public class CourseBaseVariableKeyBuilder extends EntityBuilder<CourseBaseVariableKey> {

	@Override
	void initProduct() {
		this.product = new CourseBaseVariableKey();
	}
	
	public CourseBaseVariableKeyBuilder variableType(VariableType type) {
		this.product.setVariableType(type);
		return this;
	}
	
	public CourseBaseVariableKeyBuilder courseVariableKey(String variableKey, String variableName, Boolean userEditable) {
		this.product.setVariableKey(variableKey);
		this.product.setVariableName(variableName);
		this.product.setUserEditable(userEditable);
		return this;
	}

	@Override
	CourseBaseVariableKey assembleProduct() {
		return this.product;
	}

}
