package com.github.jpaspringtest.join.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.jpaspringtest.join.dto.DeptEmpJoinDto;
import com.github.jpaspringtest.join.entities.EmployeeJoin;

/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
public interface EmployeeJoinRepository extends JpaRepository<EmployeeJoin, Integer> {

	@Query("SELECT new com.github.jpaspringtest.join.dto.DeptEmpJoinDto(d.name, e.name, e.email, e.address) FROM DepartmentJoin d INNER JOIN d.employeesJoin e")
	List<DeptEmpJoinDto> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.github.jpaspringtest.join.dto.DeptEmpJoinDto(d.name, e.name, e.email, e.address) FROM DepartmentJoin d, EmployeeJoin e")
	List<DeptEmpJoinDto> fetchEmpDeptDataCrossJoin();

}
