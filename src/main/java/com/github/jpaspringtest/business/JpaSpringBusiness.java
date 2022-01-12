package com.github.jpaspringtest.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.github.jpaspringtest.bidirectional.dao.AuthorManyToManyRepository;
import com.github.jpaspringtest.bidirectional.dao.AuthorOneToManyRepository;
import com.github.jpaspringtest.bidirectional.dao.BookManyToManyRepository;
import com.github.jpaspringtest.bidirectional.dao.BookOneToManyRepository;
import com.github.jpaspringtest.bidirectional.entities.AuthorManyToMany;
import com.github.jpaspringtest.bidirectional.entities.AuthorOneToMany;
import com.github.jpaspringtest.bidirectional.entities.BookManyToMany;
import com.github.jpaspringtest.bidirectional.entities.BookOneToMany;
import com.github.jpaspringtest.join.dao.DepartmentJoinRepository;
import com.github.jpaspringtest.join.dao.EmployeeJoinRepository;
import com.github.jpaspringtest.join.entities.DepartmentJoin;
import com.github.jpaspringtest.unidirectional.entities.EmployeeOneToOne;
import com.github.jpaspringtest.unidirectional.entities.SocietyManyToOne;
import com.github.jpaspringtest.unidirectional.entities.SocietyOneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jpaspringtest.join.entities.EmployeeJoin;
import com.github.jpaspringtest.unidirectional.dao.EmployeeManyToOneRepository;
import com.github.jpaspringtest.unidirectional.dao.EmployeeOneToManyRepository;
import com.github.jpaspringtest.unidirectional.dao.EmployeeOneToOneRepository;
import com.github.jpaspringtest.unidirectional.dao.SocietyManyToManyRepository;
import com.github.jpaspringtest.unidirectional.dao.SocietyManyToOneRepository;
import com.github.jpaspringtest.unidirectional.dao.SocietyOneToManyRepository;
import com.github.jpaspringtest.unidirectional.dao.SocietyOneToOneRepository;
import com.github.jpaspringtest.unidirectional.entities.EmployeeManyToMany;
import com.github.jpaspringtest.unidirectional.entities.EmployeeManyToOne;
import com.github.jpaspringtest.unidirectional.entities.EmployeeOneToMany;
import com.github.jpaspringtest.unidirectional.entities.SocietyManyToMany;
import com.github.jpaspringtest.unidirectional.entities.SocietyOneToMany;
/**
 * @author Mohamed Anouar BENCHEIKH
 * @project springredis
 */
@Service
public class JpaSpringBusiness {

	@Autowired
	EmployeeManyToOneRepository employeeManyToOneRepository;
	
	@Autowired
	EmployeeOneToOneRepository employeeOneToOneRepository;
	
	@Autowired
	SocietyManyToOneRepository societyManyToOneRepository;
	
	@Autowired
	SocietyOneToOneRepository societyOneToOneRepository;
	
	@Autowired
	SocietyOneToManyRepository societyOneToManyRepository;
	
	@Autowired
	EmployeeOneToManyRepository employeOneToManyRepository;
	
	@Autowired
	SocietyManyToManyRepository societyManyToManyRepository;
	
	@Autowired
	BookManyToManyRepository bookManyToManyRepository;
	
	@Autowired
	AuthorManyToManyRepository authorManyToManyRepository;
	
	@Autowired
	AuthorOneToManyRepository authorOneToManyRepository;
	
	@Autowired
	BookOneToManyRepository bookOneToManyRepository;
	
	@Autowired
	DepartmentJoinRepository departmentJoinRepository;
	
	@Autowired
    EmployeeJoinRepository employeeJoinRepository;
	
	@PostConstruct
	public void start() {
		System.out.println("*************** Unidirectional ****************");
		System.out.println("");
		System.out.println("----------------- many to one ------------------");	
		
		SocietyManyToOne societyManyToOne = new SocietyManyToOne();
		societyManyToOne.setName("society many to one");

		EmployeeManyToOne employeManyToOne = new EmployeeManyToOne();
		employeManyToOne.setName("employee many to one");
		employeManyToOne.setSocietyManyToOne(societyManyToOne);
		
		employeeManyToOneRepository.deleteAll();
		societyManyToOneRepository.deleteAll();
		
		societyManyToOneRepository.save(societyManyToOne);
		employeeManyToOneRepository.save(employeManyToOne);
		
		System.out.println(employeeManyToOneRepository.findAll().get(0));

		
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("----------------- one to one ------------------");	
		
		EmployeeOneToOne employeeOneToOne = new EmployeeOneToOne();
		employeeOneToOne.setName("employee one to one");
		
		SocietyOneToOne societeOneToOne = new SocietyOneToOne();
		societeOneToOne.setName("society one to one");
		societeOneToOne.setEmployeeOneToOne(employeeOneToOne);
		
		/***** without cascade *****/
	/*	societyOneToOneRepository.deleteAll();
		employeeOneToOneRepository.deleteAll();
		employeeOneToOneRepository.save(employeeOneToOne);
		societyOneToOneRepository.save(societeOneToOne);*/
		
				
	    /******** cascade all ******/
		societyOneToOneRepository.deleteAll();
		societyOneToOneRepository.save(societeOneToOne);

		
		System.out.println(societyOneToOneRepository.findAll().get(0));
		
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("----------------- one to many ------------------");	
		
		societyOneToManyRepository.deleteAll();
				
		EmployeeOneToMany employeOneToMany1 = new EmployeeOneToMany();
		employeOneToMany1.setName("employee1 one to many");
				
		EmployeeOneToMany employeOneToMany2 = new EmployeeOneToMany();
		employeOneToMany2.setName("employee2 one to many ");
		
		SocietyOneToMany societeOneToMany = new SocietyOneToMany();
		societeOneToMany.setName("society one to many");
		societeOneToMany.getEmployeesOneToMany().add(employeOneToMany1);
		societeOneToMany.getEmployeesOneToMany().add(employeOneToMany2);
		
		societyOneToManyRepository.save(societeOneToMany);
		System.out.println(societyOneToManyRepository.findAll());
		
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("----------------- many to many ------------------");	
		//  many to many looks like one to many in unidirectional
		societyManyToManyRepository.deleteAll();
		EmployeeManyToMany employeeManyToMany1 = new EmployeeManyToMany();
		employeeManyToMany1.setName("employee1 many to many");

		EmployeeManyToMany employeeManyToMany2 = new EmployeeManyToMany();
		employeeManyToMany2.setName("employee2 many to many");

		EmployeeManyToMany employeeManyToMany3 = new EmployeeManyToMany();
		employeeManyToMany3.setName("employee3 many to many");

		SocietyManyToMany societyManyToMany1 = new SocietyManyToMany();
		societyManyToMany1.setName("society1 many to many");

		societyManyToMany1.getEmployeesManyToMany().add(employeeManyToMany1);
		societyManyToMany1.getEmployeesManyToMany().add(employeeManyToMany2);
		societyManyToMany1.getEmployeesManyToMany().add(employeeManyToMany3);

		societyManyToManyRepository.save(societyManyToMany1);

		System.out.println(societyManyToManyRepository.findAll());

		System.out.println("------------------------------------------------");
		System.out.println("************************************************");
		
		System.out.println("");
		
		System.out.println("*************** bidirectional ****************");
		System.out.println("");
		System.out.println("----------------- many to many ------------------");	
		bookManyToManyRepository.deleteAll();

		BookManyToMany bookManyToMany1 = new BookManyToMany();
		bookManyToMany1.setName("book1");
		BookManyToMany bookManyToMany2 = new BookManyToMany();
		bookManyToMany2.setName("book2");

		AuthorManyToMany authorManyToMany1 = new AuthorManyToMany();
		AuthorManyToMany authorManyToMany2 = new AuthorManyToMany();
		AuthorManyToMany authorManyToMany3 = new AuthorManyToMany();

		authorManyToMany1.setName("author1");
		authorManyToMany2.setName("author2");
		authorManyToMany3.setName("author3");

		bookManyToMany1.getAuthorsManyToMany().add(authorManyToMany1);
		bookManyToMany1.getAuthorsManyToMany().add(authorManyToMany2);

		bookManyToMany2.getAuthorsManyToMany().add(authorManyToMany1);
		bookManyToMany2.getAuthorsManyToMany().add(authorManyToMany3);

		authorManyToMany1.getBooksManyToMany().add(bookManyToMany1);
		authorManyToMany1.getBooksManyToMany().add(bookManyToMany2);
		authorManyToMany2.getBooksManyToMany().add(bookManyToMany1);
		authorManyToMany3.getBooksManyToMany().add(bookManyToMany2);

		List<BookManyToMany> booksManyToMany = new ArrayList<>();
		booksManyToMany.add(bookManyToMany1);
		booksManyToMany.add(bookManyToMany2);

		bookManyToManyRepository.saveAll(booksManyToMany);

		// Dans toString enlever la variable Set ou liste ....
		System.out.println("-------- all books : " + bookManyToManyRepository.findAll());
		System.out.println("-------- authors of the book 1 : " + bookManyToManyRepository.findAll().get(0).getAuthorsManyToMany());
		
		System.out.println("-------- all authors : " + authorManyToManyRepository.findAll());
		System.out.println("-------- author's books 1 : " + authorManyToManyRepository.findAll().get(0).getBooksManyToMany());
		
		System.out.println("");
		System.out.println("----------------- one to many ------------------");
		
		authorOneToManyRepository.deleteAll();
		
		BookOneToMany bookOneToMany1 = new BookOneToMany();
		bookOneToMany1.setName("book1");
		BookOneToMany bookOneToMany2 = new BookOneToMany();
		bookOneToMany2.setName("book2");
		
		AuthorOneToMany auteurOneToMany = new AuthorOneToMany();
		auteurOneToMany.setName("author1");
		auteurOneToMany.getBooksOneToMany().add(bookOneToMany1);
		auteurOneToMany.getBooksOneToMany().add(bookOneToMany2);

		bookOneToMany1.setAuthorOneToMany(auteurOneToMany);
		bookOneToMany2.setAuthorOneToMany(auteurOneToMany);
		
		authorOneToManyRepository.save(auteurOneToMany);
		
		// In toString remove the variable Set or list ...
		System.out.println("-------- all authors : " + authorOneToManyRepository.findAll());
		System.out.println("-------- author's books 1 : " + authorOneToManyRepository.findAll().get(0).getBooksOneToMany());
		System.out.println("-------- all books : " + bookOneToManyRepository.findAll());
		
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("************************************************");
		
        System.out.println("");
		
		System.out.println("******************** join **********************");
		System.out.println("----------------- one to many ------------------");
		
		employeeJoinRepository.deleteAll();
		departmentJoinRepository.deleteAll();
		
		EmployeeJoin employeeJoin1 = new EmployeeJoin();
		employeeJoin1.setAddress("address1");
		employeeJoin1.setEmail("employeeJoin1@email.com");
		employeeJoin1.setName("employeeJoin1");
		
		EmployeeJoin employeeJoin2 = new EmployeeJoin();
		employeeJoin2.setAddress("address2");
		employeeJoin2.setEmail("employeeJoin2@email.com");
		employeeJoin2.setName("employeeJoin2");
		
		/*EmployeeJoin employeeJoin3 = new EmployeeJoin();
		employeeJoin3.setAddress("adresse3");
		employeeJoin3.setEmail("employeeJoin3@email.com");
		employeeJoin3.setName("employeeJoin3");*/
		
		
		DepartmentJoin departementJoin1 = new DepartmentJoin();
		departementJoin1.setName("department1");
		departementJoin1.setDescription("description1");
		
		DepartmentJoin departementJoin2 = new DepartmentJoin();
		departementJoin2.setName("department2");
		departementJoin2.setDescription("description2");
		
		DepartmentJoin departementJoin3 = new DepartmentJoin();
		departementJoin3.setName("department3");
		departementJoin3.setDescription("description3");
			
		employeeJoin1.setDepartementJoin(departementJoin1);
		employeeJoin2.setDepartementJoin(departementJoin1);
		
		departementJoin1.getEmployeesJoin().add(employeeJoin1);
		departementJoin1.getEmployeesJoin().add(employeeJoin2);
		
		List<DepartmentJoin> departementsJoin = new ArrayList<>();
		
		departementsJoin.add(departementJoin1);
		departementsJoin.add(departementJoin2);
		departementsJoin.add(departementJoin3);
		departmentJoinRepository.saveAll(departementsJoin);
		
		List<EmployeeJoin> employeesJoin = new ArrayList<>();
		
		employeesJoin.add(employeeJoin1);
		employeesJoin.add(employeeJoin2);
		//employeesJoin.add(employeeJoin3);
		
		employeeJoinRepository.saveAll(employeesJoin);
		
		System.out.println("-------- fetchEmpDeptDataInnerJoin : " + employeeJoinRepository.fetchEmpDeptDataInnerJoin());
		System.out.println("-------- fetchEmpDeptDataLeftJoin : " + departmentJoinRepository.fetchEmpDeptDataLeftJoin());
		System.out.println("-------- fetchEmpDeptDataRightJoin : " + departmentJoinRepository.fetchEmpDeptDataRightJoin());
		System.out.println("-------- fetchEmpDeptDataCrossJoin : " + employeeJoinRepository.fetchEmpDeptDataCrossJoin());
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("************************************************");
	}
}
