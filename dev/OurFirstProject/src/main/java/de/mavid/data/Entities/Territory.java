package de.mavid.data.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "territory")
public class Territory {
	
	@Id
	@GeneratedValue
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private long number;

	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return this.number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	

}
