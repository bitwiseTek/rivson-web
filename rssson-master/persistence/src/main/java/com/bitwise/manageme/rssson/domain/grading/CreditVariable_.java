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

@StaticMetamodel(CreditVariable.class)
public abstract class CreditVariable_ {

	public static volatile SingularAttribute<CreditVariable, Long> id;
	
	public static volatile SingularAttribute<CreditVariable, String> value;
	
	public static volatile SetAttribute<CreditVariable, CreditVariableKey> key;
	
	public static volatile SetAttribute<CreditVariable, Credit> credit;

}
