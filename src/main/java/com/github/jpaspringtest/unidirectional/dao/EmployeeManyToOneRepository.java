package com.github.jpaspringtest.unidirectional.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.jpaspringtest.unidirectional.entities.EmployeeManyToOne;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Repository
public interface EmployeeManyToOneRepository extends JpaRepository<EmployeeManyToOne, Long>{

}
