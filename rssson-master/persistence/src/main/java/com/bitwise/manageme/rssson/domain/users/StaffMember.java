package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.base.LGA;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STAFF_MEMBERS", uniqueConstraints = @UniqueConstraint(columnNames = {
"staff_id" }))
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="StaffMember.findById", query="select distinct s from StaffMember s where s.id=:id"),
	@NamedQuery(name="StaffMember.findByStaffId", query="select distinct s from StaffMember s where s.staffId=:staffId"),
	@NamedQuery(name="StaffMember.findAll", query="select s from StaffMember s")
})
public class StaffMember implements ArchivableEntity, Serializable {
	
	public StaffMember() {
		
	}
	
	public StaffMember(String staffId) {
		this.staffId = staffId;
	}
	
	public StaffMember(String staffId, String title, String nationality, String stateOfOrigin, LGA lga, String additionalInfo) {
		this.staffId = staffId;
		this.title = title;
		this.nationality = nationality;
		this.stateOfOrigin = stateOfOrigin;
		this.lga  = lga;
		this.additionalInfo = additionalInfo;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String staffId;
	
	private String title;
	
	private String additionalInfo;
	
	private String nationality;
	
	private String stateOfOrigin;
	
	private LGA lga;
	
	private Boolean archived = Boolean.FALSE;
	
	private Boolean isAcademic = Boolean.TRUE;
	
	private Boolean isTemporary = Boolean.FALSE;
	
	private User user;
	
	private List<StaffMemberImage> images = new ArrayList<StaffMemberImage>();

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
	@Column(name="STAFF_ID")
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@OneToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="ADDITIONAL_INFO")
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@NotEmpty
	@Column(name="NATIONALITY")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@NotEmpty
	@Column(name="STATE_ID")
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
		return lga.getName();
	}

	public void setLga(LGA lga) {
		this.lga = lga;
	}

	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	@Column(name="ACADEMIC", nullable=false)
	public Boolean getIsAcademic() {
		return isAcademic;
	}
	
	@Transient
	public Boolean isAcademic() {
		return isAcademic;
	}

	public void setIsAcademic(Boolean isAcademic) {
		this.isAcademic = isAcademic;
	}

	@Column(name="TEMPORARY", nullable=false)
	public Boolean getIsTemporary() {
		return isTemporary;
	}
	
	@Transient
	public Boolean isTemporary() {
		return isTemporary;
	}

	public void setIsTemporary(Boolean isTemporary) {
		this.isTemporary = isTemporary;
	}
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, mappedBy="staff", cascade=CascadeType.ALL)
	public List<StaffMemberImage> getImages() {
		return images;
	}

	public void setImages(List<StaffMemberImage> images) {
		this.images = images;
	}
	
	@Transient
	public void addImage(StaffMemberImage image) {
		getImages().add(image);
	}
}
