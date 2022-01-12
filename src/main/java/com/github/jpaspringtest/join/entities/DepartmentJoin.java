package com.github.jpaspringtest.join.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "departmentjoin")
public class DepartmentJoin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	//@OneToMany(targetEntity = EmployeeJoin.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	@OneToMany(orphanRemoval = false, mappedBy = "id", fetch = FetchType.LAZY)
	private Set<EmployeeJoin> employeesJoin = new HashSet<EmployeeJoin>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Set<EmployeeJoin> getEmployeesJoin() {
		return employeesJoin;
	}

	public void setEmployeesJoin(Set<EmployeeJoin> employeesJoin) {
		this.employeesJoin = employeesJoin;
	}

	@Override
	public String toString() {
		return "DepartementJoin [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	
}