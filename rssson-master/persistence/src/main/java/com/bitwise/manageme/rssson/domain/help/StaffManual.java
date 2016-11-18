package com.bitwise.manageme.rssson.domain.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

import com.bitwise.manageme.rssson.domain.users.StaffMemberManualPDF;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STAFF_MANUALS", uniqueConstraints = @UniqueConstraint(columnNames = {
"manual_version" }))
@NamedQueries({
	@NamedQuery(name="StaffManual.findById", query="select distinct s from StaffManual s where s.id=:id"),
	@NamedQuery(name="StaffManual.findByVersion", query="select distinct s from StaffManual s where s.manualVersion=:manualVersion"),
	@NamedQuery(name="StaffManual.findAll", query="select s from StaffManual s")
})
public class StaffManual implements Serializable {

	public StaffManual() {
		
	}
	
	public StaffManual(Long id, String manualName, String manualVersion) {
		this.id = id;
		this.manualName = manualName;
		this.manualVersion = manualVersion;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String manualName;
	
	private String manualVersion;
	
	private List<StaffMemberManualPDF> pdfs = new ArrayList<StaffMemberManualPDF>();

	@Id
	@DocumentId
	@Column(name="STAFF_MANUAL_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name="MANUAL_NAME")
	public String getManualName() {
		return manualName;
	}

	public void setManualName(String manualName) {
		this.manualName = manualName;
	}

	@NotEmpty
	@Column(name="MANUAL_VERSION")
	public String getManualVersion() {
		return manualVersion;
	}

	public void setManualVersion(String manualVersion) {
		this.manualVersion = manualVersion;
	}

	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, mappedBy="staffManual", cascade=CascadeType.ALL)
	public List<StaffMemberManualPDF> getPdfs() {
		return pdfs;
	}

	public void setPdfs(List<StaffMemberManualPDF> pdfs) {
		this.pdfs = pdfs;
	}
	
	@Transient
	public void addPDF(StaffMemberManualPDF pdf) {
		getPdfs().add(pdf);
	}
}
