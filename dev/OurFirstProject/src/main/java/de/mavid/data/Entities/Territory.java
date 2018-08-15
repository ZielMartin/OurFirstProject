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
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer number;

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
