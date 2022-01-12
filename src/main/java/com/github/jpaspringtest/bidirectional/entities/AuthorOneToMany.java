package com.github.jpaspringtest.bidirectional.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "authorsonetomany")
public class AuthorOneToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<BookOneToMany> booksOneToMany = new HashSet<BookOneToMany>();

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

	public Set<BookOneToMany> getBooksOneToMany() {
		return booksOneToMany;
	}

	public void setBooksOneToMany(Set<BookOneToMany> booksOneToMany) {
		this.booksOneToMany = booksOneToMany;
	}

	@Override
	public String toString() {
		return "AuthorOneToMany{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
