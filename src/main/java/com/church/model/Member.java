package com.church.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name = "members")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String LastName;
	
	@Column(name = "email")
	private String Email;
	
	@Column(name = "fellowship")
	private String Fellowship;
	
	@Column(name = "cell")
	private String Cell;
	
	@Column(name = "position")
	private String Position;
	
	@Column(name = "department")
	private String Department;
	
	@Column(name = "rhapsody")
	private String Rhapsody;
	
	@Column(name = "tithe")
	private String Tithe;
	
	@Column(name = "others")
	private String Others;
	
	public Member() {
		
	}
	
	public Member(String firstName, String lastName, String email, String fellowship, String cell, String position,
			String department, String rhapsody, String tithe, String others) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		Email = email;
		Fellowship = fellowship;
		Cell = cell;
		Position = position;
		Department = department;
		Rhapsody = rhapsody;
		Tithe = tithe;
		Others = others;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFellowship() {
		return Fellowship;
	}
	public void setFellowship(String fellowship) {
		Fellowship = fellowship;
	}
	public String getCell() {
		return Cell;
	}
	public void setCell(String cell) {
		Cell = cell;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getRhapsody() {
		return Rhapsody;
	}
	public void setRhapsody(String rhapsody) {
		Rhapsody = rhapsody;
	}
	public String getTithe() {
		return Tithe;
	}
	public void setTithe(String tithe) {
		Tithe = tithe;
	}
	public String getOthers() {
		return Others;
	}
	public void setOthers(String others) {
		Others = others;
	}


}

