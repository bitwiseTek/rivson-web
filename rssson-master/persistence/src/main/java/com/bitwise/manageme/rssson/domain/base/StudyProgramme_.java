package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(StudyProgramme.class)
public abstract class StudyProgramme_ {

	public static volatile SingularAttribute<StudyProgramme, Long> id;
	
	public static volatile SingularAttribute<StudyProgramme, String> name;
	
	public static volatile SingularAttribute<StudyProgramme, String> code;
	
	public static volatile SetAttribute<StudyProgramme, StudyProgrammeCategory> category;
	
	public static volatile SingularAttribute<StudyProgramme, Boolean> archived;
}
