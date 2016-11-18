package com.bitwise.manageme.rssson.domain.resources;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount;

@Entity
@Indexed
@PrimaryKeyJoinColumn(name="RESOURCE_ID")
@Table(name="WEB_RSSSON_WORK_RESOURCES")
@NamedQueries({
	@NamedQuery(name="WorkResource.findById", query="select distinct w from WorkResource w where w.id=:id"),
	@NamedQuery(name="WorkResource.findAll", query="select w from WorkResource w")
})
public class WorkResource extends Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MonetaryAmount hourlyCost;
	
	private MonetaryAmount costPerUse;

	@Column(name="HOURLY_COST", nullable=false)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "hourly_cost_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "hourly_cost_currency"))})
	public MonetaryAmount getHourlyCost() {
		return hourlyCost;
	}

	public void setHourlyCost(MonetaryAmount hourlyCost) {
		this.hourlyCost = hourlyCost;
	}

	@Column(name="COST_PER_USE", nullable=false)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "cost_per_use_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "cost_per_use_currency"))})
	public MonetaryAmount getCostPerUse() {
		return costPerUse;
	}

	public void setCostPerUse(MonetaryAmount costPerUse) {
		this.costPerUse = costPerUse;
	}
	
	@Transient
	public ResourceType getResourceType() {
		return ResourceType.WORK_RESOURCE;
	}

}
