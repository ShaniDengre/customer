/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Altran Technologies

File Name					:CustomerServicesImpl.java
Principal Author				: SHANI DENGRE
Subsystem Name        :   Core Java Training
Module Name                       :
Date of First Release            :29-7-2021
Author                                   :  SHANI DENGRE
Description                :

***********************************************************************/
package com.cg.serviceImpl;

import java.util.List;

import com.cg.daoImpl.CustomerDaoImpl;
import com.cg.model.CustomerModel;
import com.cg.service.CustomerService;

public class CustomerServiceImpl implements CustomerService 
{

	
	CustomerDaoImpl  daoimpl = new  CustomerDaoImpl();
	CustomerModel  customerModel = new  CustomerModel();
	
	
	@Override
	public String addCustomer(CustomerModel customer) {
		daoimpl.create(customer);
		return "add succesfully";
	}

	@Override
	public String deleteCustomer(int id) {
		
		
		daoimpl.delete(id);
		
		return "delete succesfully";

	}

	@Override
	public String updateCustomer( CustomerModel customer) {
		System.out.println("update called");
		if (daoimpl.getCustomers(customer.getId()).getId() == 0) {
			daoimpl.create(customer);
		} else {
			daoimpl.update(customer);
		}
		return  "update successfully";
	}
	

	@Override
	public List<CustomerModel> displayCustomerDetails() {
		 
		return   daoimpl. getCustomers();
	}

	@Override
	public CustomerModel displayCustomer(int id) {
		// TODO Auto-generated method stub
	return daoimpl. getCustomers(id);
	}
	


}
