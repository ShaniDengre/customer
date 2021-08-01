/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Altran Technologies

File Name					:CustomerDao.java
Principal Author				: SHANI DENGRE
Subsystem Name        :   Core Java Training
Module Name                       :
Date of First Release            :29-7-2021
Author                                   :  SHANI DENGRE
Description                :

***********************************************************************/
package com.cg.dao;
import java.util.List;

import  com.cg.model.*;
public interface CustomerDao {

	public  List<CustomerModel> getCustomers() ;
	public CustomerModel getCustomers(int id);
	public void create(CustomerModel c1);
	public void update(CustomerModel c1);
	public String delete(int id);


}
