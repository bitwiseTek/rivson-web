package com.bitwise.manageme.rssson.domain.reports;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ReportCategory.class)
public abstract class ReportCategory_ {
	
	public static volatile SetAttribute<ReportCategory, Long> id;
	
	public static volatile SetAttribute<ReportCategory, String> name;
	
	public static volatile SetAttribute<ReportCategory, Integer> indexColumn;
	
	public static volatile SetAttribute<ReportCategory, Boolean> archived;

}
