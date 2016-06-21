package com.helpezee.service;

import com.helpezee.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	public Employee getEmployeeInfo(Employee emp) {
		Employee employee = new Employee();
		employee.setEmpId(emp.getEmpId());
		employee.setEmpName("Satyanarayana");
		employee.setPhone("949494949");
		return employee;
	}

}
