/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Altran Technologies

File Name					:CustomerServicesApp.java
Principal Author				: SHANI DENGRE
Subsystem Name        :   Core Java Training
Module Name                       :
Date of First Release            :29-7-2021
Author                                   :  SHANI DENGRE
Description                :

***********************************************************************/

package com.cg.controller;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cg.model.CustomerModel;
import com.cg.serviceImpl.CustomerServiceImpl;

@Path("/customer")
public class CustomerServicesApp {
	
	CustomerServiceImpl  serObj=new CustomerServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerModel> displayTable(){
		return serObj.displayCustomerDetails();
	}
	
	
	@GET
	@Path("display/{id}")
	// @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerModel getCustomers(@PathParam("id") int id) {
		System.out.println("display id called");
		return  serObj.displayCustomer(id);
		
	}
	  
	@PUT
	@Path("update")
	// @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerModel updateCustomer(CustomerModel c1) {

		serObj.updateCustomer(c1);
		return c1;

	}

	

	@POST
	@Path("create")
	// @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerModel createCustomer(CustomerModel c1) {

		System.out.println("create called");

		System.out.println(c1.toString());
	   serObj.addCustomer(c1);
		return c1;

	}
	  
	@DELETE
	@Path("delete/{id}")
	public String deleteCustomer(@PathParam("id") int id) {
		
		
		serObj.deleteCustomer(id);
		
		return "deleted Successfully";
	}
	

}
