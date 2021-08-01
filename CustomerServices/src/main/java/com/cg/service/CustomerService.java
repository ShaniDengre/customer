/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Altran Technologies

File Name					:CustomerService.java
Principal Author				: SHANI DENGRE
Subsystem Name        :   Core Java Training
Module Name                       :
Date of First Release            :29-7-2021
Author                                   :  SHANI DENGRE
Description                :

***********************************************************************/
package com.cg.service;

import java.util.List;

import com.cg.model.CustomerModel;

public interface CustomerService {
	
	
	public String addCustomer(CustomerModel customer);
	public String deleteCustomer(int id);
	public String updateCustomer( CustomerModel customer);
	public List<CustomerModel> displayCustomerDetails();
	public CustomerModel displayCustomer(int id);
 	
	
	

}
