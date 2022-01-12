package com.github.jpaspringtest.bidirectional.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "booksmanytomany")
public class BookManyToMany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		       name = "books_authors_manytomany",
		       joinColumns = @JoinColumn(name = "book_id_manytomany"),
		       inverseJoinColumns = @JoinColumn(name = "author_id_manytomany")
		    )
	private Set<AuthorManyToMany> authorsManyToMany = new HashSet<AuthorManyToMany>();

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

	public Set<AuthorManyToMany> getAuthorsManyToMany() {
		return authorsManyToMany;
	}

	public void setAuthorsManyToMany(Set<AuthorManyToMany> authorsManyToMany) {
		this.authorsManyToMany = authorsManyToMany;
	}

	@Override
	public String toString() {
		return "BookManyToMany{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
