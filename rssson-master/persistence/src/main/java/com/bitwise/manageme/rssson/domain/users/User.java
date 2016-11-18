package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.manageme.rssson.domain.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Indexed
@Table(name="WEB_RSSSON_USERS", uniqueConstraints = @UniqueConstraint(columnNames = {
"username" }))
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="User.findById", query="select distinct u from User u where u.id=:id"),
	@NamedQuery(name="User.findByUsername", query="select distinct u from User u where u.username=:username"),
	@NamedQuery(name="User.findBySystemId", query="select distinct u from User u where u.systemId=:systemId"),
	@NamedQuery(name="User.findAll", query="select u from User u")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public User() {
		
	}
	
	public User(Long id, String username, String emailAddress, String oneTimeToken) {
		this.id = id;
		this.username = username;
		this.oneTimeToken = oneTimeToken;
	}
	
	private Long id;
	
	private String systemId;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private Date birthday;
	
	private String primaryAddress;
	
	private String secondaryAddress;
	
	private String primaryNumber;
	
	private String secondaryNumber;
	
	private String country;
	
	private String city;
	
	private String streetAddress;
	
	private String postalCode;
	
	private String sex;
	
	private Boolean secureInfo = Boolean.FALSE;
	
	private String basicInfo;
	
	private List<Role> roles = new ArrayList<Role>();
	
	private Boolean archived = Boolean.FALSE;
	
	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	private String secretQuestion;
	
	private String secretAnswer;
	
	private Boolean isActive = Boolean.TRUE;
	
	private String oneTimeToken;
	
	private DateTime lastLogin = new DateTime(DateTime.now());
	
	private DateTime lastLogout = new DateTime(DateTime.now());

	@Id
	@DocumentId
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Field(analyze=Analyze.NO, store=Store.YES)
	@Column(name="SYSTEM_ID", unique=true)
	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	@Field
	@NotEmpty
	@Column(name="MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="BIRTHDAY")
	@Temporal(value=TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@NotEmpty
	@Column(name="PRIMARY_EMAIL")
	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	@Column(name="SECONDARY_EMAIL")
	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	@NotEmpty
	@Column(name="PRIMARY_PHONE")
	public String getPrimaryNumber() {
		return primaryNumber;
	}

	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}

	@Column(name="SECONDARY_PHONE")
	public String getSecondaryNumber() {
		return secondaryNumber;
	}

	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}

	@NotEmpty
	@Column(name="COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@NotEmpty
	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@NotEmpty
	@Column(name="STREET_ADDRESS")
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(name="POSTAL_CODE")
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name="SEX")
	@Field(store=Store.NO)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Field
	@Column(name="SECURE_INFO", nullable=false)
	public Boolean getSecureInfo() {
		return secureInfo;
	}

	public void setSecureInfo(Boolean secureInfo) {
		this.secureInfo = secureInfo;
	}

	@Lob
	@Column(name="BASIC_INFO")
	@Basic(fetch=FetchType.LAZY)
	public String getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}

	@NotEmpty
	@Column(name="CONFIRM_PASSWORD")
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@NotEmpty
	@Column(name="SECRET_QUESTION")
	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	@NotEmpty
	@Column(name="SECRET_ANSWER")
	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	@JsonIgnore
	@Column(name="OTT")
	public String getOneTimeToken() {
		return oneTimeToken;
	}

	public void setOneTimeToken(String oneTimeToken) {
		this.oneTimeToken = oneTimeToken;
	}

	@Column(name="ACTIVE", nullable=false)
	public Boolean getIsActive() {
		return isActive;
	}
	
	@Transient
	public Boolean isActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Field
	@NotEmpty
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Transient
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getFirstNameSortable() {
		return firstName;
	}
	
	@Transient
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getLastNameSortable() {
		return lastName;
	}
	
	@Transient
	public String getFullName() {
		return getFirstName() + ' ' + getLastName();
	}

	@Field
	@NotEmpty
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="LINK_USERS_ROLES", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@NotEmpty
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty
	@JsonIgnore
	@Column(name="USER_PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Field
	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="LAST_USER_LOGIN", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Transient
	public String getLastLoginString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(lastLogin);
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Column(name="LAST_USER_LOGOUT", nullable=false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getLastLogout() {
		return lastLogout;
	}

	public void setLastLogout(DateTime lastLogout) {
		this.lastLogout = lastLogout;
	}

	@Transient
	public String getLastLogoutString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(lastLogout);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((systemId == null) ? 0 : systemId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (systemId == null) {
			if (other.systemId != null)
				return false;
		} else if (!systemId.equals(other.systemId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", systemId=" + systemId + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + primaryAddress + "]";
	}
}
