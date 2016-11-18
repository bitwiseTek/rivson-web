package com.bitwise.manageme.rssson.domain.reports;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ReportContext.class)
public abstract class ReportContext_ {

	public static volatile SetAttribute<ReportContext, ReportContextType> context;
	
	public static volatile SingularAttribute<ReportContext, Report> report;
}
