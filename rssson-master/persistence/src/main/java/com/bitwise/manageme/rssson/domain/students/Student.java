package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 10/09/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.base.BillingDetails;
import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STUDENTS", uniqueConstraints = @UniqueConstraint(columnNames = {
"student_id" }))
@NamedQueries({
	@NamedQuery(name="Student.findById", query="select distinct s from Student s where s.id=:id"),
	@NamedQuery(name="Student.findByStudentId", query="select distinct s from Student s where s.studentId=:studentId"),
	@NamedQuery(name="Student.findAll", query="select s from Student s")
})
public class Student implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	public Student() {
		
	}
	
	public Student(String studentId) {
		this.studentId = studentId;
	}
	
	public Student(String studentId, String nationality, String stateOfOrigin, 
			LGA lga, DateTime studyStartDate, DateTime studyEndDate, StudentStudyEndReason studyEndReason, 
			StudyProgramme studyProgramme) {
		this.studentId = studentId;
		this.nationality = nationality;
		this.stateOfOrigin = stateOfOrigin;
		this.lga = lga;
		this.studyStartDate = studyStartDate;
		this.studyEndDate = studyEndDate;
		this.studyEndReason = studyEndReason;
		this.studyProgramme = studyProgramme;
	}
	
	private Long id;
	
	private String studentId;
	
	private String nickname;
	
	private String additionalInfo;
	
	private String nationality;
	
	private String stateOfOrigin;
	
	private LGA lga;
	
	private StudentActivityType activityType;
	
	private StudentExaminationType examinationType;
	
	private StudentEducationalLevel educationalLevel;
	
	private Date studyTimeEnd;
	
	private StudyProgramme studyProgramme;
	
	private Double previousStudies;
	
	private Boolean lodging = Boolean.FALSE;
	
	private DateTime studyStartDate = new DateTime(DateTime.now());
	
	private DateTime studyEndDate = new DateTime(DateTime.now().plusDays(1095));
	
	private StudentStudyEndReason studyEndReason;
	
	private String studyEndText;
	
	private List<StudentImage> images = new ArrayList<StudentImage>();
	
	private User user;
	
	private List<BillingDetails> billingDets = new ArrayList<BillingDetails>();
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@DocumentId
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name="STUDENT_ID")
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Column(name="NICKNAME")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/*@Transient
	@Field(store=Store.NO)
	public String getFullName() {
		return this.user.getFirstName() + ' ' + this.user.getLastName();
	}*/

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ADDITIONAL_INFO")
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="NATIONALITY", nullable=false)
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@NotEmpty
	@Column(name="STATE_OF_ORIGIN")
	public String getStateOfOrigin() {
		return stateOfOrigin;
	}

	public void setStateOfOrigin(String stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
	}
	
	@ManyToOne
	@JoinColumn(name="LGA_ID")
	public LGA getLga() {
		return lga;
	}
	
	@Transient
	public String lgaString() {
		return new LGA().getName();
	}

	public void setLga(LGA lga) {
		this.lga = lga;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_ACTIVITY_TYPE_ID")
	public StudentActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(StudentActivityType activityType) {
		this.activityType = activityType;
	}

	@ManyToOne
	@JoinColumn(name="EXAMINATION_TYPE_ID")
	public StudentExaminationType getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(StudentExaminationType examinationType) {
		this.examinationType = examinationType;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_EDUCATIONAL_LEVEL_ID")
	public StudentEducationalLevel getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(StudentEducationalLevel educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	@Column(name="STUDY_TIME_END")
	@Temporal(value=TemporalType.DATE)
	public Date getStudyTimeEnd() {
		return studyTimeEnd;
	}

	public void setStudyTimeEnd(Date studyTimeEnd) {
		this.studyTimeEnd = studyTimeEnd;
	}

	@ManyToOne
	@JoinColumn(name="STUDY_PROGRAMME_ID")
	public StudyProgramme getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	@Column(name="PREVIOUS_STUDIES")
	public Double getPreviousStudies() {
		return previousStudies;
	}

	public void setPreviousStudies(Double previousStudies) {
		this.previousStudies = previousStudies;
	}

	@Column(name="LODGING", nullable=false)
	public Boolean getLodging() {
		return lodging;
	}

	public void setLodging(Boolean lodging) {
		this.lodging = lodging;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="STUDY_START_DATE", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getStudyStartDate() {
		return studyStartDate;
	}

	public void setStudyStartDate(DateTime studyStartDate) {
		this.studyStartDate = studyStartDate;
	}
	
	@Transient
	public String getStudyStartDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(studyStartDate);
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="STUDY_END_DATE", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getStudyEndDate() {
		return studyEndDate;
	}

	public void setStudyEndDate(DateTime studyEndDate) {
		this.studyEndDate = studyEndDate;
	}
	
	@Transient
	public String getStudyEndDateString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(studyEndDate);
	}
	
	@ManyToOne
	@IndexedEmbedded
	@JoinColumn(name="STUDY_END_REASON_ID")
	public StudentStudyEndReason getStudyEndReason() {
		return studyEndReason;
	}

	public void setStudyEndReason(StudentStudyEndReason studyEndReason) {
		this.studyEndReason = studyEndReason;
	}
	
	@Transient
	public boolean getActive() {
		return getHasStartedStudies() && !getHasFinishedStudies();
	}
	
	@Transient
	public boolean getHasStartedStudies() {
		return studyStartDate != null && studyStartDate.isBeforeNow();
	}
	
	@Transient
	public boolean getHasFinishedStudies() {
		return studyEndDate != null && studyEndDate.isBeforeNow();
	}

	@Basic(fetch=FetchType.LAZY)
	@Column(name="STUDY_END_TEXT")
	public String getStudyEndText() {
		return studyEndText;
	}

	public void setStudyEndText(String studyEndText) {
		this.studyEndText = studyEndText;
	}
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
	public List<StudentImage> getImages() {
		return images;
	}

	public void setImages(List<StudentImage> images) {
		this.images = images;
	}
	
	@Transient
	public void addImage(StudentImage image) {
		getImages().add(image);
	}

	@OneToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<BillingDetails> getBillingDets() {
		return billingDets;
	}

	public void setBillingDets(List<BillingDetails> billingDets) {
		this.billingDets = billingDets;
	}

	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
}
