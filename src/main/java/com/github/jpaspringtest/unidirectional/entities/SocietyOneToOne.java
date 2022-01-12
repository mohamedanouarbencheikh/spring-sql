package com.github.jpaspringtest.unidirectional.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "societiesonetoone")
public class SocietyOneToOne {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	   // @OneToOne
	    @JoinColumn(name = "employeeonetoone_id")
		EmployeeOneToOne employeeOneToOne;

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

	public EmployeeOneToOne getEmployeeOneToOne() {
		return employeeOneToOne;
	}

	public void setEmployeeOneToOne(EmployeeOneToOne employeeOneToOne) {
		this.employeeOneToOne = employeeOneToOne;
	}

	@Override
	public String toString() {
		return "SocietyOneToOne{" +
				"id=" + id +
				", name='" + name + '\'' +
				", employeeOneToOne=" + employeeOneToOne +
				'}';
	}
}
