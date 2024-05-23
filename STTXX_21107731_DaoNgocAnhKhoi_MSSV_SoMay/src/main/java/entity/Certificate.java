package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificates")
public class Certificate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4907019760677501987L;
	@Id
	@Column(name = "certificate_id")
	private String id;
	private String name;
	private String organization;
	@Column(name = "issue_date")
	private LocalDate issueDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	public Certificate(String id, String name, String organization, LocalDate issueDate) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.issueDate = issueDate;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Certificate [id=" + id + ", name=" + name + ", organization=" + organization + ", issueDate="
				+ issueDate + "]";
	}
}
