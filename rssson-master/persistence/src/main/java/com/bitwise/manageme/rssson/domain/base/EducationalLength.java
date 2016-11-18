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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="WEB_RSSSON_EDUCATIONAL_LENGTHS")
@NamedQueries({
	@NamedQuery(name="EducationalLength.findById", query="select distinct e from EducationalLength e where e.id=:id"),
	@NamedQuery(name="EducationalLength.findAll", query="select e from EducationalLength e")
})
public class EducationalLength implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Double units;
	
	private EducationalTimeUnit unit;

	@Id
	@Column(name="EDUCATIONAL_LENGTH_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="UNITS", nullable=false, unique=true)
	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	@ManyToOne
	@JoinColumn(name="EDUCATIONAL_TIME_UNIT_ID")
	public EducationalTimeUnit getUnit() {
		return unit;
	}

	public void setUnit(EducationalTimeUnit unit) {
		this.unit = unit;
	}
	
	@Transient
	public Double getBaseUnits() {
		return getUnits() * getUnit().getBaseUnits();
	}
	
	@Transient
	public void setBaseUnits(Double baseUnits) {
		setUnits(baseUnits / getUnit().getBaseUnits());
	}
}
