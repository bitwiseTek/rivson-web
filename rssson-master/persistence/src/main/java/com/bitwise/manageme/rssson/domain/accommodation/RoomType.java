package com.bitwise.manageme.rssson.domain.accommodation;
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
@Table(name="WEB_RSSSON_ROOM_TYPES")
@NamedQueries({
	@NamedQuery(name="RoomType.findById", query="select distinct r from RoomType r where r.id=:id"),
	@NamedQuery(name="RoomType.findAll", query="select r from RoomType r")
})
public class RoomType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;

	@Id
	@Column(name="ROOM_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="ROOM_TYPE_NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
