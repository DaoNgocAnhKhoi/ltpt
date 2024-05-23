package entity;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9136446140618596694L;
	@Id
	@Column(name = "position_id")
	private String id;
	private String name;
	private String description;
	private Double salary;
	private int number;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
	private ArrayList<Candidate> listCandidate = new ArrayList<Candidate>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
	private ArrayList<Experience> listExp = new ArrayList<Experience>();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Position(String id, String name, String description, Double salary, int number) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.salary = salary;
		this.number = number;
	}
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", description=" + description + ", salary=" + salary
				+ ", number=" + number + "]";
	}
	
}
