package com.github.jpaspringtest.bidirectional.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Entity
@Table(name = "booksonetomany")
public class BookOneToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	private AuthorOneToMany authorOneToMany;

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

	public AuthorOneToMany getAuthorOneToMany() {
		return authorOneToMany;
	}

	public void setAuthorOneToMany(AuthorOneToMany authorOneToMany) {
		this.authorOneToMany = authorOneToMany;
	}

	@Override
	public String toString() {
		return "BookOneToMany{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
