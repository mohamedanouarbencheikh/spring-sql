package com.github.jpaspringtest.bidirectional.entities;

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
@Table(name = "authorsmanytomany")
public class AuthorManyToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "authorsManyToMany", cascade = CascadeType.ALL)
	private Set<BookManyToMany> booksManyToMany = new HashSet<BookManyToMany>();

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

	public Set<BookManyToMany> getBooksManyToMany() {
		return booksManyToMany;
	}

	public void setBooksManyToMany(Set<BookManyToMany> booksManyToMany) {
		this.booksManyToMany = booksManyToMany;
	}

	@Override
	public String toString() {
		return "AuthorManyToMany{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
