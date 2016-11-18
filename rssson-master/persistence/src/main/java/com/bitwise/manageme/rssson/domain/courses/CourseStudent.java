package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@Table(name="WEB_RSSSON_COURSE_STUDENTS")
@NamedQueries({
	@NamedQuery(name="CourseStudent.findById", query="select distinct c from CourseStudent c where c.id=:id"),
	@NamedQuery(name="CourseStudent.findAll", query="select c from CourseStudent c")
})
public class CourseStudent implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseUser courseUser;
	
	private DateTime enrolmentTime = new DateTime(DateTime.now());
	
	private Student student;
	
	private Boolean archived = Boolean.FALSE;
	
	private String participationType;
	
	private String courseEnrolmentType;
	
	private Boolean lodging = Boolean.FALSE;
	
	private String courseOptionality;
	
	private BillingDetails billingDetails;
	
	private BigDecimal lodgingFee;
	
	private String lodgingFeeCurrency;
	
	private Room room;
	
	private String additionalInfo;

	@Id
	@Column(name="COURSE_STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="COURSE_USER_ID")
	public CourseUser getCourseUser() {
		return courseUser;
	}

	public void setCourseUser(CourseUser courseUser) {
		this.courseUser = courseUser;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="ENROLMENT_TIME", nullable=false)
	public DateTime getEnrolmentTime() {
		return enrolmentTime;
	}

	public void setEnrolmentTime(DateTime enrolmentTime) {
		this.enrolmentTime = enrolmentTime;
	}
	
	@Transient
	public String getEnrolmentTimeString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(enrolmentTime);
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name="PARTICIPATION_TYPE", nullable=false)
	public String getParticipationType() {
		return participationType;
	}

	public void setParticipationType(String participationType) {
		this.participationType = participationType;
	}

	@Column(name="ENROLMENT_TYPE", nullable=false)
	public String getCourseEnrolmentType() {
		return courseEnrolmentType;
	}

	public void setCourseEnrolmentType(String courseEnrolmentType) {
		this.courseEnrolmentType = courseEnrolmentType;
	}

	@Column(name="LODGING", nullable=false)
	public Boolean getLodging() {
		return lodging;
	}

	public void setLodging(Boolean lodging) {
		this.lodging = lodging;
	}

	@Column(name="COURSE_OPTIONALITY", nullable=false)
	public String getCourseOptionality() {
		return courseOptionality;
	}

	public void setCourseOptionality(String courseOptionality) {
		this.courseOptionality = courseOptionality;
	}

	@ManyToOne
	@JoinColumn(name="BILLING_DETAILS_ID")
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}

	@Column(name="LODGING_FEE")
	public BigDecimal getLodgingFee() {
		return lodgingFee;
	}

	public void setLodgingFee(BigDecimal lodgingFee) {
		this.lodgingFee = lodgingFee;
	}

	@Column(name="LODGIN_FEE_CURRENCY")
	public String getLodgingFeeCurrency() {
		return lodgingFeeCurrency;
	}

	public void setLodgingFeeCurrency(String lodgingFeeCurrency) {
		this.lodgingFeeCurrency = lodgingFeeCurrency;
	}
	
	@ManyToOne
	@JoinColumn(name="ROOM_ID")
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Column(name="ADDITIONAL_INFO")
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionInfo) {
		this.additionalInfo = additionInfo;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lodging == null) ? 0 : lodging.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CourseStudent))
			return false;
		CourseStudent other = (CourseStudent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lodging == null) {
			if (other.lodging != null)
				return false;
		} else if (!lodging.equals(other.lodging))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lodging=" + lodging + "]";
	}
}
