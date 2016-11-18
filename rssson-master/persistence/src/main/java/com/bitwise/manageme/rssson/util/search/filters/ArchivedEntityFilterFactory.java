package com.bitwise.manageme.rssson.util.search.filters;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.QueryWrapperFilter;
import org.apache.lucene.search.TermQuery;
import org.hibernate.search.annotations.Factory;
import org.hibernate.search.annotations.Key;
import org.hibernate.search.filter.FilterKey;
import org.hibernate.search.filter.StandardFilterKey;

public class ArchivedEntityFilterFactory {

	private Boolean archived;
	
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	
	@Factory
	public Filter getFilter() {
		Term term = new Term("archived", this.archived.toString());
		Query query = new TermQuery(term);
		Filter filter = new QueryWrapperFilter(query);
		return filter;
	}
	
	@Key
	public FilterKey getKey() {
		StandardFilterKey key = new StandardFilterKey();
		key.addParameter(this.archived);
		return key;
	}
}
