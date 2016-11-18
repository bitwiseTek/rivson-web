package com.bitwise.manageme.rssson.util.search.filters;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.util.List;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.TermsFilter;
import org.hibernate.search.annotations.Factory;
import org.hibernate.search.annotations.Key;
import org.hibernate.search.filter.FilterKey;
import org.hibernate.search.filter.StandardFilterKey;

public class StudentIdFilterFactory {

	private List<String> studentIds;
	
	public void setStudentIds(List<String> studentIds) {
		this.studentIds = studentIds;
	}
	
	@Factory
	public Filter getFilter() {
		TermsFilter tf = new TermsFilter();
		
		for (int i = 0; i < studentIds.size(); i++) {
			tf.addTerm(new Term("students.id", studentIds.get(i).toString()));
		}
		return tf;
	}
	
	@Key
	public FilterKey getKey() {
		StandardFilterKey key = new StandardFilterKey();
		key.addParameter(this.studentIds);
		return key;
	}
}
