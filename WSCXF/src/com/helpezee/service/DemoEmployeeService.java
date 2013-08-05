package com.helpezee.service;

//http://kaustuvmaji.blogspot.in/2013/04/simple-restful-web-services-example.html

/**
 *
 * Copyright (c) Kaustuv Maji , 2013
 * Repos - https://github.com/kaustuvmaji
 * Blog -  http://kaustuvmaji.blogspot.in
 *
 */

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.helpezee.dto.employee.Employee;;


/**
 * This is rest services interface . Methods i. Add Employee
 * {@link #addEmployee(Customer)}. ii. Get Employee by EmployeeId
 * {@link #getEmployeeById(long)}. iii. Update Employee
 * {@link #updateEmployee(Customer)}. iv. Delete Employee
 * {@link #deleteEmployee(long)}.
 * 
 * @since 1.0
 * @version 1.0
 * 
 * @author KMaji
 * 
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