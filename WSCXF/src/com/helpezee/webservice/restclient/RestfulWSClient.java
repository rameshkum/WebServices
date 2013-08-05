package com.helpezee.webservice.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jettison.json.JSONException;
import org.xml.sax.SAXException;

import com.helpezee.dto.customer.Address;
import com.helpezee.dto.customer.Customer;

public class RestfulWSClient {
 public static void main(String[] args) throws IOException, URISyntaxException, HttpException, InterruptedException, ParserConfigurationException, SAXException, JAXBException, JSONException  {
  HttpClient client = new DefaultHttpClient();
  Customer cust= new Customer();
  Address add= new Address();
  cust.setCustomerId(3);
  cust.setCustomerName("AP");
  cust.setPhone(444);
  add.setCity("TNKU");
  add.setCountry("INDIA");
  add.setPincode(34216);
  add.setState("AP");
  add.setStreet("ssss");
  cust.setAddress(add);

  JAXBContext jaxbCtx = null;
  StringWriter xmlWriter = null;
  try {
	  
      //converting java Object to XML using JAXB
	  
      jaxbCtx = JAXBContext.newInstance(Customer.class);
      xmlWriter = new StringWriter();
      jaxbCtx.createMarshaller().marshal(cust, xmlWriter);
      System.out.println(xmlWriter);
   
      //converting XML to Java Object using JAXB
      
      /*Customer b = (Customer) jaxbCtx.createUnmarshaller().unmarshal(new StringReader(xmlWriter.toString()));
      System.out.println("XML Unmarshal example in JAva");
      System.out.println(b.toString());
      */
      
  } catch (JAXBException ex) {
      System.out.println(ex);
  }
  
//######################getCustomerById ##########################
  

  /****** Using QueryParam*******/
   
  //HttpGet post = new HttpGet("http://localhost:8080/WSCXF/services/customerService/getCustomerByIdQuery?custId=3");
 
   /********** Using PathParam**********/
  
  //HttpGet post = new HttpGet("http://localhost:8080/WSCXF/services/customerService/getCustomerByIdPath/1");
  
  /************ Using HeadParam**********/
  
  /*HttpGet post = new HttpGet("http://localhost:8080/WSCXF/services/customerService/getCustomerByIdHead");
  post.setHeader("custId","1");*/
  

  
//######################createCustomer ############################ 
   
 /*StringEntity se = new StringEntity(xmlWriter.toString());
   se.setContentType("application/xml");
   se.setContentEncoding("UTF-8");
   HttpPost post = new HttpPost("http://localhost:8080/WSCXF/services/customerService/addCustomer");
   post.setEntity(se);*/
   
   
 
//  #######################deleteCustomer###########################
   
 
   HttpDelete post = new HttpDelete("http://localhost:8080/WSCXF/services/customerService/deleteCustomer?custId=3");

  
//  ###########################updateCustomet######################### 

 /* HttpPut post = new HttpPut("http://localhost:8080/WSCXF/services/customerService/updateCustomer");
  StringEntity se = new StringEntity(xmlWriter.toString());
  se.setContentType("application/xml");
  se.setContentEncoding("UTF-8");
  post.setEntity(se);*/
  
   
  //calling the webservice and getting the response back  
   
  HttpResponse response = client.execute(post);
  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  String line = "";
  while ((line = rd.readLine()) != null) {
   System.out.println("Response---"+line);
  }
 }
}