package entity;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -49297805263688994L;
	@Id
	@Column(name = "candidate_id")
	private String _id;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	private String gender;
	private String email;
	private String phone;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Position position;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
	private ArrayList<Experience> listExp = new ArrayList<Experience>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
	private ArrayList<Certificate> listCert = new ArrayList<Certificate>();
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Candidate(String _id, String fullName, int yearOfBirth, String gender, String email, String phone,
			String description) {
		super();
		this._id = _id;
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.description = description;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Candidate [_id=" + _id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", gender="
				+ gender + ", email=" + email + ", phone=" + phone + ", description=" + description + "]";
	}
}
