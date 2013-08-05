package com.helpezee.service;

/**
|
| Copyright (c) Kaustuv Maji , 2013
|
| Please do not use source code in production.
| Repos -  https://github.com/kaustuvmaji
| Blog  -  http://kaustuvmaji.blogspot.in
*/
 
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.helpezee.dto.customer.Address;
import com.helpezee.dto.customer.Customer;
 
/**
  This implementation class is to implement rest service interface.
  			
  			Operation  				   Methods
  			
      --   Add customer               {@link #addCustomer(Customer)}.
      --   Get customer by customerId {@link #getCustomerById(long)}.
      --   Update customer            {@link #updateCustomer(Customer)}.
      --   Delete customer            {@link #deleteCustomer(long)}.


 
 This implementation class is to implement SOAP service interface.
  			
  			Operation  				   Methods
  			
      --   Add Employee               {@link #addCustomer(Customer)}.
      --   Get Employee by employeeId {@link #getCustomerById(long)}.
      --   Update Employee            {@link #updateCustomer(Customer)}.
      --   Delete Employee            {@link #deleteCustomer(long)}.

  Common Methods
      --   init                       {@link #init()}.
      --   destory                    {@link #destroy()}.

 */
 
public class DemoCustomerServiceImpl implements DemoCustomerService {
 
  @Context
  UriInfo uriInfo;
 
  private final static String ACCESS_CONTROL_ALLOW_ORIGIN = "*";
 
  private Logger log;
 
  private Map<Long, Customer> customers;
 
  public DemoCustomerServiceImpl() {
    log = Logger.getLogger(DemoCustomerServiceImpl.class);
    customers = new HashMap<Long, Customer>();
  }
 
  //RESTFUL WebService Implementation
  
	public Response getCustomerByIdPath(long custId) { //using path param
    log.info("Executing getCustomerByIdPath operation");
    System.out.println("Executing getCustomerByIdPath operation");
    if (!customers.containsKey(custId)) {
      return Response.status(Response.Status.BAD_REQUEST)
                     .location(uriInfo.getAbsolutePath())
                     .entity("customer not found")
                     .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
                     .build();
    }
    return Response.ok(uriInfo.getAbsolutePath())
                   .entity(customers.get(custId))
                   .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
                   .build();
  }
  

  public Response getCustomerByIdHead(long custId) { //using HeaParam
	    log.info("Executing getCustomerByIdHead operation");
	    System.out.println("Executing getCustomerByIdHead operation");
	    if (!customers.containsKey(custId)) {
	      return Response.status(Response.Status.BAD_REQUEST)
	                     .location(uriInfo.getAbsolutePath())
	                     .entity("customer not found")
	                     .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
	                     .build();
	    }
	    return Response.ok(uriInfo.getAbsolutePath())
	                   .entity(customers.get(custId))
	                   .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
	                   .build();
	  }
  
  public Response getCustomerByIdQuery(long custId) { //Using QueryParam
	  log.info("Executing getCustomerByIdQuery operation");
	    System.out.println("Executing getCustomerByIdQuery operation");
	     if (!customers.containsKey(custId)) {
	      return Response.status(Response.Status.BAD_REQUEST)
	                     .location(uriInfo.getAbsolutePath())
	                     .entity("customer not found")
	                     .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
	                     .build();
	    }
	    return Response.ok(uriInfo.getAbsolutePath())
	                   .entity(customers.get(custId))
	                   .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
	                   .build();
	  }
 
  public Response addCustomer(Customer customer) {
    log.info("Executing Add Customer operation");
    System.out.println("Executing Add Customer operation");
    if (customers.containsKey(customer.getCustomerId())) {
     return Response.status(Response.Status.BAD_REQUEST)
              .location(uriInfo.getAbsolutePath())
              .entity("Exsisting customer found with same id.")
              .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
              .build();
    }
    customers.put(customer.getCustomerId(), customer);
    log.info("Added new customer with customer id" + customer.getCustomerId());
    System.out.println("Added new customer with customer id" + customer.getCustomerId());
    System.out.println("Added new customer with customer id" + customer.getCustomerId());
    return Response.ok(uriInfo.getAbsolutePath())
                   .entity(customer)
                   .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
                   .build();
  }
 
  public Response deleteCustomer(long custId) {
    log.info("Executing Delete Customer operation");
    System.out.println("Executing Delete Customer operation");
    if (!customers.containsKey(custId)) {
     return  Response.status(Response.Status.BAD_REQUEST)
              .location(uriInfo.getAbsolutePath())
              .entity("customer not found")
              .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
              .build();
    }
    customers.remove(custId);
    log.info("Removed customer contains customerid " + custId);
    System.out.println("Removed customer contains customerid " + custId);
    return Response.ok(uriInfo.getAbsolutePath())
                   .entity("Removed customer contains customerid " + custId)
                   .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
                   .build();
  }
 
  public Response updateCustomer(Customer customer) {
    log.info("Executing update Customer operation");
    System.out.println("Executing update Customer operation");
    if (!customers.containsKey(customer.getCustomerId())) {
     return Response.status(Response.Status.BAD_REQUEST)
              .location(uriInfo.getAbsolutePath())
              .entity("customer not found")
              .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
              .build();
    }
    customers.put(customer.getCustomerId(), customer);
    return Response.ok(uriInfo.getAbsolutePath())
                   .entity(customer)
                   .header("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN)
                   .build();
  }
 
  

	  
  /**
   * Init method is used to prepare data which we
   * will use for testing purpose.
   * usage of this method is defined in bean definition.
   */
  public void init() {
    Customer cus1 = new Customer();
    cus1.setCustomerId(1);
    cus1.setCustomerName("Kaustuv Maji");
    cus1.setPhone(9830098300l);
    Address add = new Address();
    add.setStreet("saltlake");
    add.setCity("kolkata");
    add.setState("westbengal");
    add.setCountry("India");
    add.setPincode(700106);
    cus1.setAddress(add);
    customers.put(cus1.getCustomerId(), cus1);
    System.out.println("Added " + cus1.getCustomerName() + " into Customer info");
    Customer cus2 = new Customer();
    cus2.setCustomerId(2);
    cus2.setCustomerName("customer 2");
    customers.put(cus2.getCustomerId(), cus2);
    System.out.println("Added " + cus2.getCustomerName() + " into Customer info");
    System.out.println("Customer info map contains " + customers.size() + " details");
  }
 
  /**
   * destroy method is also used after our testing purpose is done.
   * usage of this method is defined in bean definition.
   */
  public void destroy() {
    System.out.println("Cleaning up customers info map");
    customers.clear();
  }




  

}