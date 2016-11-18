package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="WEB_RSSSON_BILLING_DETAILS")
@NamedQueries({
	@NamedQuery(name="BillingDetails.findById", query="select distinct b from BillingDetails b where b.id=:id"),
	@NamedQuery(name="BillingDetails.findAll", query="select b from BillingDetails b")
})
public class BillingDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Student personName;
	
	private String companyName;
	
	private Student streetAddress1;
	
	private String streetAddress2;
	
	private Student postalCode;
	
	private Student city;
	
	private Student country;
	
	private Student phoneNumber;
	
	private Student emailAddress;
	
	private String companyIdentifier;
	
	private String referenceNumber;
	
	private Student studentId;
	
	private List<CourseStudent> courseStudents = new ArrayList<CourseStudent>();
	
	private String notes;
	
	@Id
	@Column(name="BILLING_DETAILS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_FULL_NAME")
	public Student getPersonName() {
		return personName;
	}

	public void setPersonName(Student personName) {
		this.personName = personName;
	}

	@Column(name="NAME_OF_COMPANY")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_ADDRESS")
	public Student getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(Student streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	@Column(name="STREET_ADDRESS_ALT")
	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_POSTAL_CODE")
	public Student getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Student postalCode) {
		this.postalCode = postalCode;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_CITY")
	public Student getCity() {
		return city;
	}

	public void setCity(Student city) {
		this.city = city;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_COUNTRY")
	public Student getCountry() {
		return country;
	}

	public void setCountry(Student country) {
		this.country = country;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_PHONE_NO")
	public Student getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Student phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_EMAIL")
	public Student getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(Student emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name="COMPANY_IDENTIFIER")
	public String getCompanyIdentifier() {
		return companyIdentifier;
	}

	public void setCompanyIdentifier(String companyIdentifier) {
		this.companyIdentifier = companyIdentifier;
	}

	@NotEmpty
	@JsonIgnore
	@Column(name="REFERENCE_NUMBER")
	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="billingDetails", orphanRemoval=true)
	public List<CourseStudent> getCourseStudents() {
		return courseStudents;
	}

	public void setCourseStudents(List<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
