package com.github.jpaspringtest.bidirectional.dao;

import com.github.jpaspringtest.bidirectional.entities.BookManyToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Repository
public interface BookManyToManyRepository extends JpaRepository<BookManyToMany, Long>{

}
