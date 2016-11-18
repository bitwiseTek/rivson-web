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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@Table(name="WEB_RSSSON_ROOMS", uniqueConstraints = @UniqueConstraint(columnNames = {
"room_name" }))
@NamedQueries({
	@NamedQuery(name="Room.findById", query="select distinct r from Room r where r.id=:id"),
	@NamedQuery(name="Room.findAll", query="select r from Room r")
})
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private RoomType type;
	
	private Student studentId;

	@Id
	@Column(name="ROOM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="ROOM_NAME", nullable=false, unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="ROOM_TYPE_ID")
	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}
}
