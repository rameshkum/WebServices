package com.helpezee.service;


import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.helpezee.dto.employee.Employee;;


/**
 * This is SOAP services interface . 
 * Methods 
 * i. Add Employee                {@link #addEmployee(Employee)}. 
 * ii. Get Employee by EmployeeId {@link #getEmployeeById(Employee)}. 
 * iii. Update Employee           {@link #updateEmployee(Employee)}. 
 * iv. Delete Employee            {@link #deleteEmployee(Employee)}.
 */

@WebService(targetNamespace = "http://ws.helpezee.com/services/cxf", endpointInterface = "http:helpezee.wordpress.com/soap")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DemoEmployeeService {

	// SOAP Interfaces

	@WebMethod(operationName = "getEmployeeById")
	@WebResult(name = "Status")
	public String getEmployeeById(Employee employee);

	@WebMethod(operationName = "addEmployee")
	@WebResult(name = "Status")
	public String addEmployee(Employee employee);

	@WebMethod(operationName = "deleteEmployee")
	@WebResult(name = "Status")
	public String deleteEmployee(Employee employee);

	@WebMethod(operationName = "updateEmployee")
	@WebResult(name = "Status")
	public String updateEmployee(Employee employee);
}