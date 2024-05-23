package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "experiences")
public class Experience implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8231012703887103392L;
	@Id
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "from_date")
	private LocalDate fromDate;
	@Column(name = "to_date")
	private LocalDate toDate;
	private String description;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Position position;
	public Experience(String companyName, LocalDate fromDate, LocalDate toDate, String description) {
		super();
		this.companyName = companyName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
	}
	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Experience [companyName=" + companyName + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", description=" + description + "]";
	}
}
