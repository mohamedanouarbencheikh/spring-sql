package com.github.jpaspringtest.unidirectional.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.jpaspringtest.unidirectional.entities.EmployeeOneToMany;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Repository
public interface EmployeeOneToManyRepository extends JpaRepository<EmployeeOneToMany, Long>{

}
