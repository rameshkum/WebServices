package com.helpezee.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutFaultInterceptors;

import com.helpezee.dto.Employee;

@WebService
@InInterceptors(interceptors = {"com.helpezee.interceptors.LoggingInInterceptor" })
/*@OutInterceptors (interceptors = {"com.example.Test2Interceptor" }) */
@OutFaultInterceptors (interceptors = {"com.helpezee.interceptors.CustomFaultInterceptor" }) 
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public interface EmployeeService {
	@WebMethod
	public Employee getEmployeeInfo(Employee emp);

}
