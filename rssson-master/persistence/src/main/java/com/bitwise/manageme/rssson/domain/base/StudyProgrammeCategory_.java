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

@StaticMetamodel(StudyProgrammeCategory.class)
public abstract class StudyProgrammeCategory_ {

	public static volatile SingularAttribute<StudyProgrammeCategory, Long> id;
	
	public static volatile SingularAttribute<StudyProgrammeCategory, String> name;
	
	public static volatile SetAttribute<StudyProgrammeCategory, EducationType> educationType;
	
	public static volatile SingularAttribute<StudyProgrammeCategory, Boolean> archived;
}
