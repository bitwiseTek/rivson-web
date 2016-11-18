package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.bitwise.manageme.rssson.domain.base.VariableType;

@StaticMetamodel(CreditVariableKey.class)
public abstract class CreditVariableKey_ {

	public static volatile SingularAttribute<CreditVariableKey, Long> id;
	
	public static volatile SingularAttribute<CreditVariableKey, Boolean> userEditable;
	
	public static volatile SingularAttribute<CreditVariableKey, Long> version;
	
	public static volatile SingularAttribute<CreditVariableKey, String> variableName;
	
	public static volatile SingularAttribute<CreditVariableKey, String> variableKey;
	
	public static volatile SetAttribute<CreditVariableKey, VariableType> variableType;
}
