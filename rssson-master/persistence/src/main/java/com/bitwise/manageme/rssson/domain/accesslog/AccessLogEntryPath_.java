package com.bitwise.manageme.rssson.domain.accesslog;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AccessLogEntryPath.class)
public abstract class AccessLogEntryPath_ {
	
	public static volatile SingularAttribute<AccessLogEntryPath, Long> id;

	public static volatile SingularAttribute<AccessLogEntryPath, String> path;
	
	public static volatile SingularAttribute<AccessLogEntryPath, Boolean> active;

}
