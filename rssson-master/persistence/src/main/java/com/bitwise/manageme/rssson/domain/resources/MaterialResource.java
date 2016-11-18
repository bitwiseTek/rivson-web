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
@Table(name="WEB_RSSSON_MATERIAL_RESOURCES")
@NamedQueries({
	@NamedQuery(name="MaterialResource.findById", query="select distinct m from MaterialResource m where m.id=:id"),
	@NamedQuery(name="MaterialResource.findAll", query="select m from MaterialResource m")
})
public class MaterialResource extends Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MonetaryAmount unitCost;

	@Column(name="UNIT_COST", nullable=false)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "unit_cost_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "unit_cost_currency"))})
	public MonetaryAmount getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(MonetaryAmount unitCost) {
		this.unitCost = unitCost;
	}
	
	@Transient
	public ResourceType getResourceType() {
		return ResourceType.MATERIAL_RESOURCE;
	}
}
