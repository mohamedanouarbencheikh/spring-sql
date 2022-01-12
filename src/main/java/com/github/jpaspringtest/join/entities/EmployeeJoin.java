package com.github.jpaspringtest.join.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "employeejoin")
public class EmployeeJoin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "dept_id", insertable = false, updatable = false) // with (insertable = false, updatable = false) a dept_id = null in database
	@JoinColumn(name = "dept_id")
	@Fetch(FetchMode.JOIN)
	private DepartmentJoin departementJoin;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DepartmentJoin getDepartementJoin() {
		return departementJoin;
	}

	public void setDepartementJoin(DepartmentJoin departementJoin) {
		this.departementJoin = departementJoin;
	}

	@Override
	public String toString() {
		return "EmployeeJoin [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", departementJoin=" + departementJoin + "]";
	}

	

}