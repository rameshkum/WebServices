package com.helpezee.service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;

import org.apache.log4j.Logger;

import com.helpezee.dto.employee.Empaddress;
import com.helpezee.dto.employee.Employee;

public class DemoEmployeeServiceImpl implements DemoEmployeeService {
	private Logger log;
	private Map<Long, Employee> employees;

	public DemoEmployeeServiceImpl() {
		log = Logger.getLogger(DemoEmployeeServiceImpl.class);
		employees = new HashMap<Long, Employee>();
	}

	public String getEmployeeById(Employee employee) {
		log.info("Executing getCustomerById operation");
		System.out.println("Executing getCustomerById operation");
		if (!employees.containsKey(employee.getCustomerId())) {
			return "Employee not found";
		}
		return Java2XML(employees.get(employee.getCustomerId()));
	}

	public String addEmployee(Employee employee) {
		log.info("Executing Add Employee operation");
		System.out.println("Executing Add Employee operation");
		if (employees.containsKey(employee.getCustomerId())) {
			return "Existing Employee found with same id.";
		}
		employees.put(employee.getCustomerId(), employee);
		log.info("Added new Employee with Employee id"
				+ employee.getCustomerId());
		return "Added new Employee with Employee id::"
				+ employee.getCustomerId();

	}

	public String deleteEmployee(Employee employee) {
		log.info("Executing Delete Employee operation");
		System.out.println("Executing Delete Employee operation");
		if (!employees.containsKey(employee.getCustomerId())) {
			return "Employee not found";
		}
		employees.remove(employee.getCustomerId());
		log.info("Removed Employee contains customerid "
				+ employee.getCustomerId());
		return "Removed Employee contains customerid ::"
				+ employee.getCustomerId();

	}

	public String updateEmployee(Employee employee) {
		log.info("Executing update Employee operation");
		System.out.println("Executing update Employee operation");
		if (!employees.containsKey(employee.getCustomerId())) {
			return "Employee not found";
		}
		employees.put(employee.getCustomerId(), employee);
		return "Updated Employee with Employee id ::"
				+ employee.getCustomerId();
	}

	/**
	 * Init method is used to prepare data which we will use for testing
	 * purpose. usage of this method is defined in bean definition.
	 */
	public void init() {
		Employee cus1 = new Employee();
		cus1.setCustomerId(1);
		cus1.setCustomerName("Kaustuv Maji");
		cus1.setPhone("9830098300l");
		Empaddress add = new Empaddress();
		add.setStreet("saltlake");
		add.setCity("kolkata");
		add.setState("westbengal");
		add.setCountry("India");
		add.setPincode("700106");
		cus1.setEmpaddress(add);
		employees.put(cus1.getCustomerId(), cus1);
		log.info("Added " + cus1.getCustomerName() + " into Customer info");
		Employee cus2 = new Employee();
		cus2.setCustomerId(2);
		cus2.setCustomerName("customer 2");
		employees.put(cus2.getCustomerId(), cus2);
		log.info("Added " + cus2.getCustomerName() + " into Customer info");
		log.info("Customer info map contains " + employees.size() + " details");
	}

	/**
	 * destroy method is also used after our testing purpose is done. usage of
	 * this method is defined in bean definition.
	 */
	public void destroy() {
		log.info("Cleaning up customers info map");
		employees.clear();
	}

	public String Java2XML(Employee employee) {

		JAXBContext jaxbCtx = null;
		StringWriter xmlWriter = null;
		try {
			jaxbCtx = JAXBContext.newInstance(Employee.class);
			xmlWriter = new StringWriter();
			jaxbCtx.createMarshaller().marshal(employee, xmlWriter);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlWriter.toString();
	}

}
