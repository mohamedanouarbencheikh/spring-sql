package com.github.jpaspringtest.join.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.jpaspringtest.join.dto.DeptEmpJoinDto;
import com.github.jpaspringtest.join.entities.DepartmentJoin;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
public interface DepartmentJoinRepository extends JpaRepository<DepartmentJoin, Integer> {

	@Query("SELECT new com.github.jpaspringtest.join.dto.DeptEmpJoinDto(d.name, e.name, e.email, e.address) FROM DepartmentJoin d LEFT JOIN d.employeesJoin e")
	List<DeptEmpJoinDto> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.github.jpaspringtest.join.dto.DeptEmpJoinDto(d.name, e.name, e.email, e.address) FROM DepartmentJoin d RIGHT JOIN d.employeesJoin e")
	List<DeptEmpJoinDto> fetchEmpDeptDataRightJoin();

}
