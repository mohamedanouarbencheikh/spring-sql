package com.github.jpaspringtest.bidirectional.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.jpaspringtest.bidirectional.entities.AuthorOneToMany;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Repository
public interface AuthorOneToManyRepository extends JpaRepository<AuthorOneToMany, Long>{

}
