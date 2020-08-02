package com.employee.api.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.api.entity.Employee;
import com.employee.api.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public List<Employee>findAll(){
		return employeeRepository.findAll();
	}
	
	public Employee findOne(Long empid) {
		Employee res = null;
		Optional <Employee> employeeOptional= employeeRepository.findById(empid);
		if (employeeOptional.isPresent()) {
			Employee employee=employeeOptional.get();
			res = employee;
		}
		return res;		
	}
	
	public void delete (Employee emp) {
		employeeRepository.delete(emp);
	}
}
