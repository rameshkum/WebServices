package com.helpezee.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.helpezee.dto.customer.Customer;

/**
 * This is rest services interface . 
 * Methods 
 * i. Add customer					 * {@link #addCustomer(Customer)}. 
 * ii. Get customer by customerId	 * {@link #getCustomerById(long)}. 
 * iii. Update customer				 * {@link #updateCustomer(Customer)}.
 * iv. Delete customer				 * {@link #deleteCustomer(long)}.
  */
@Path("/")
@WebService(targetNamespace = "http://ws.helpezee.com/services/cxf", endpointInterface = "http:helpezee.wordpress.com/rest")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface DemoCustomerService {

	// RESTFUL Interfaces

	@GET
	@Path("/getCustomerByIdPath/{custId}")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Response getCustomerByIdPath(@PathParam("custId") long custId);

	@GET
	@Path("/getCustomerByIdHead")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Response getCustomerByIdHead(
			@HeaderParam(value = "custId") long custId);

	@GET
	@Path("/getCustomerByIdQuery")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Response getCustomerByIdQuery(@QueryParam("custId") long custId);

	/**
	 * This method is used to demonstrate http method POST.
	 * 
	 * @param customer
	 * @return response
	 */
	@POST
	@Path("/addCustomer")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Response addCustomer(Customer customer);

	/**
	 * This method is used to demonstrate Http method DELETE.
	 * 
	 * @param custId
	 *            will be accepted as Queryparam.
	 * @return response
	 */
	@DELETE
	@Path("/deleteCustomer")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Response deleteCustomer(@QueryParam("custId") long custId);

	/**
	 * This method is to demonstrate http method PUT.
	 * 
	 * @param customer
	 * @return response
	 */
	@PUT
	@Path("/updateCustomer")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public Response updateCustomer(Customer customer);

}