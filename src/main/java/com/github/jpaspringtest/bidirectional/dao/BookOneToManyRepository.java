package com.github.jpaspringtest.bidirectional.dao;

import com.github.jpaspringtest.bidirectional.entities.BookOneToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Repository
public interface BookOneToManyRepository extends JpaRepository<BookOneToMany, Long>{

}
