package com.github.jpaspringtest.unidirectional.dao;

import com.github.jpaspringtest.unidirectional.entities.SocietyOneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Repository
public interface SocietyOneToOneRepository extends JpaRepository<SocietyOneToOne, Long>{

}
