package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="WEB_RSSSON_PASSWORD_RESET_REQUEST")
@NamedQueries({
	@NamedQuery(name="PasswordResetRequest.findById", query="select distinct p from PasswordResetRequest p where p.id=:id"),
	@NamedQuery(name="PasswordResetRequest.findAll", query="select p from PasswordResetRequest p")
})
public class PasswordResetRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private User user;
	
	private String secretAnswer;
	
	private Date date;

	@Id
	@Column(name="STUDENT_PASSWORD_RESET_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="SECRET", nullable=false)
	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	@Temporal(value=TemporalType.DATE)
	@Column(name="DATE", nullable=false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
