package com.github.jpaspringtest.unidirectional.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "employeesmanytoone")
public class EmployeeManyToOne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "societymanytoone_id")
	private SocietyManyToOne societyManyToOne;

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

	public SocietyManyToOne getSocietyManyToOne() {
		return societyManyToOne;
	}

	public void setSocietyManyToOne(SocietyManyToOne societyManyToOne) {
		this.societyManyToOne = societyManyToOne;
	}

	@Override
	public String toString() {
		return "EmployeeManyToOne{" +
				"id=" + id +
				", name='" + name + '\'' +
				", societyManyToOne=" + societyManyToOne +
				'}';
	}
}
