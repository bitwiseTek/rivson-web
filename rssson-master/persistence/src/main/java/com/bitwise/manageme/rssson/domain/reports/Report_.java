package com.bitwise.manageme.rssson.domain.reports;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Report.class)
public abstract class Report_ {
	
	public static volatile SetAttribute<Report, ReportContextType> context;
	
	public static volatile SetAttribute<Report, ReportContextType> report;
	
	public static volatile SetAttribute<Report, ReportCategory> category;

}
