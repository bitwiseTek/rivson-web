package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.VariableType;
import com.bitwise.manageme.rssson.domain.users.UserVariableKey;

@Component
public class UserVariableKeyBuilder extends EntityBuilder<UserVariableKey> {

	@Override
	void initProduct() {
		this.product = new UserVariableKey();
	}
	
	public UserVariableKeyBuilder variableType(VariableType type) {
		this.product.setVariableType(type);
		return this;
	}
	
	public UserVariableKeyBuilder userVariableKey(String variableKey, String variableName, Boolean userEditable) {
		this.product.setVariableKey(variableKey);
		this.product.setVariableName(variableName);
		this.product.setUserEditable(userEditable);
		return this;
	}

	@Override
	UserVariableKey assembleProduct() {
		return this.product;
	}

}
