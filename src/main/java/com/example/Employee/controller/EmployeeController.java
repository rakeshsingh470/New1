package com.example.Employee.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.exception.ResourceNotFoundException;

import lombok.Data;


@Data
@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	
	
	@PostMapping("/employees")
	  public Employee createUser(@RequestBody Employee emp) {
		  System.out.println("test");
		
	    return employeeRepository.save(emp);
	  }
		
	
	 @GetMapping("/employees/{id}")
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empId)
			  throws ResourceNotFoundException   {
		 System.out.println("emp 1..."+empId);
		 Employee employee =
	    		employeeRepository
	            .findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + empId));
		 System.out.println("emp 2...");       
	    return ResponseEntity.ok().body(employee);
	  }
	 
	 
	 @PutMapping("/employees/{id}")
	  public ResponseEntity<Employee> updateEmployee(
	      @PathVariable(value = "id") Long empId, @RequestBody Employee empDetails)
		 throws ResourceNotFoundException {
		 Employee emp =
				 employeeRepository
			            .findById(empId)
			            .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + empId));

		 emp.setName(empDetails.getName());
		 emp.setAge(empDetails.getAge());
		 emp.setGender(empDetails.getGender());
		 emp.setAddress(empDetails.getAddress());
		 final Employee updatedEmp = employeeRepository.save(emp);
		  return ResponseEntity.ok(updatedEmp);
	  }
	 
	 
	 @DeleteMapping("/employees/{id}")
	  public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long empId) throws Exception {
		 Employee emp =
				 employeeRepository
			            .findById(empId)
			            .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + empId));

		 employeeRepository.delete(emp);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	
	 @GetMapping("/employees")
	  public List<Employee> getAllEmployee() {
	    return employeeRepository.findAll();
	  }

}
