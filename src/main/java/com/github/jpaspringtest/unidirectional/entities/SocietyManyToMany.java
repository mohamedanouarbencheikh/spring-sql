package com.github.jpaspringtest.unidirectional.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "societiesmanytomany")
public class SocietyManyToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<EmployeeManyToMany> employeesManyToMany = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeManyToMany> getEmployeesManyToMany() {
		return employeesManyToMany;
	}

	public void setEmployeesManyToMany(Set<EmployeeManyToMany> employeesManyToMany) {
		this.employeesManyToMany = employeesManyToMany;
	}

	@Override
	public String toString() {
		return "SocietyManyToMany{" +
				"id=" + id +
				", name='" + name + '\'' +
				", employeesManyToMany=" + employeesManyToMany +
				'}';
	}
}
