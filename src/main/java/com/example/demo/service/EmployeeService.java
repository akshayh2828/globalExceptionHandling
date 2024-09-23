package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.advice.BusinessException;
import com.example.demo.entity.Employee;
import com.example.demo.repos.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface
{

	@Autowired
	private EmployeeCrudRepo crudRepo;
	@Override
	public Employee addEmployee(Employee employee) {
		
		try {
			if(employee.getName().isEmpty() || employee.getName().length()==0)
			{
				throw new BusinessException("601","input field are empty");
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();

		}
			
		
		Employee saveEmployee=crudRepo.save(employee);
		return saveEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> empList=crudRepo.findAll();
		
		try {
			if(empList.isEmpty())
			{
				throw new BusinessException("601","hello list completely empty");
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
			
		 
		
		return empList;
	}

	@Override
	public Employee getEmpById(Long empidL) {
		
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
		
	}

}
