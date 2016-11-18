package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
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

@Entity
@Table(name="WEB_RSSSON_EDUCATIONAL_TIME_UNITS")
@NamedQueries({
	@NamedQuery(name="EducationalTimeUnit.findById", query="select distinct e from EducationalTimeUnit e where e.id=:id"),
	@NamedQuery(name="EducationalTimeUnit.findAll", query="select e from EducationalTimeUnit e")
})
public class EducationalTimeUnit implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Double baseUnits;
	
	private String name;
	
	private Boolean archived = Boolean.FALSE;
	
	private String symbol;

	@Id
	@Column(name="EDUCATIONAL_TIME_UNIT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="BASE_UNITS", nullable=false)
	public Double getBaseUnits() {
		return baseUnits;
	}

	public void setBaseUnits(Double baseUnits) {
		this.baseUnits = baseUnits;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="SYMBOL", nullable=false)
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

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
