package com.bitwise.manageme.rssson.domain.reports;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_REPORT_CATEGORIES")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedReportCategory", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="ReportCategory.findById", query="select distinct r from ReportCategory r where r.id=:id"),
	@NamedQuery(name="ReportCategory.findAll", query="select r from ReportCategory r")
})
public class ReportCategory implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Integer indexColumn;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@Column(name="REPORT_CATEGORY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="IND_COL")
	public Integer getIndexColumn() {
		return indexColumn;
	}

	public void setIndexColumn(Integer indexColumn) {
		this.indexColumn = indexColumn;
	}

	@Field
	@Override
	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	@Override
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
