package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount;

@Entity
@Table(name="WEB_RSSSON_OTHER_COSTS")
@NamedQueries({
	@NamedQuery(name="OtherCost.findById", query="select distinct o from OtherCost o where o.id=:id"),
	@NamedQuery(name="OtherCost.findAll", query="select o from OtherCost o")
})
public class OtherCost implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Course course;
	
	private String name;
	
	private MonetaryAmount cost;

	@Id
	@Column(name="OTHER_COST_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="COST", nullable=false)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "cost_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "cost_currency"))})
	public MonetaryAmount getCost() {
		return cost;
	}

	public void setCost(MonetaryAmount cost) {
		this.cost = cost;
	}
}
