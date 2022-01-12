package com.github.jpaspringtest.unidirectional.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "societiesonetomany")
public class SocietyOneToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private Set<EmployeeOneToMany> employeesOneToMany = new HashSet<>();

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

	public Set<EmployeeOneToMany> getEmployeesOneToMany() {
		return employeesOneToMany;
	}

	public void setEmployeesOneToMany(Set<EmployeeOneToMany> employeesOneToMany) {
		this.employeesOneToMany = employeesOneToMany;
	}

	@Override
	public String toString() {
		return "SocietyOneToMany{" +
				"id=" + id +
				", name='" + name + '\'' +
				", employeesOneToMany=" + employeesOneToMany +
				'}';
	}
}
