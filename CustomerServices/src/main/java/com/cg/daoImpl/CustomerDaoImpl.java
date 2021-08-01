/***********************************************************************
Altran Technologies Proprietary

This source code is the sole property of Altran Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Altran Technologies

File Name					:CustomerDaoImpl.java
Principal Author				: SHANI DENGRE
Subsystem Name        :   Core Java Training
Module Name                       :
Date of First Release            :29-7-2021
Author                                   :  SHANI DENGRE
Description                :

***********************************************************************/
package com.cg.daoImpl;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.dao.CustomerDao;
import com.cg.model.CustomerModel;

public class CustomerDaoImpl implements CustomerDao {

	
	Connection con;
	public CustomerDaoImpl()
	{
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("driver is loaded");
			con = DriverManager.getConnection(url,"system","database");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<CustomerModel> getCustomers() {
		List<CustomerModel> customers = new ArrayList<>();

		String sql = "select * from customer";

		try {
			System.out.println("connection is loaded");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				CustomerModel c = new CustomerModel();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setPinCode(rs.getInt(5));
				c.setEmail(rs.getString(6));
				c.setNumber(rs.getLong(7));
				c.setStatus(rs.getString(8));

				customers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
		
	}
	@Override
	public CustomerModel getCustomers(int id) {

		String sql = "select * from customer where id =" + id;
		CustomerModel c = new CustomerModel();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setPinCode(rs.getInt(5));
				c.setEmail(rs.getString(6));
				c.setNumber(rs.getInt(7));
				c.setStatus(rs.getString(8));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}
	@Override
	public void create(CustomerModel c1) {

		String sql = "insert into customer values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, c1.getId());
			st.setString(2, c1.getName());
			st.setString(3, c1.getAddress());
			st.setString(4, c1.getPassword());
			st.setInt(5, c1.getPinCode());
			st.setString(6, c1.getEmail());
			st.setLong(7, c1.getNumber());
			st.setString(8, c1.getStatus());
			System.out.println(st.toString());
			System.out.println(st);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(CustomerModel c1) {
		String sql = "update customer set name=?, address=?, password=?, pincode=?, email=?, number1=?, status=? where id=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(8, c1.getId());
			st.setString(1, c1.getName());
			st.setString(2, c1.getAddress());
			st.setString(3, c1.getPassword());
			st.setInt(4, c1.getPinCode());
			st.setString(5, c1.getEmail());
			st.setLong(6, c1.getNumber());
			st.setString(7, c1.getStatus());

			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String delete(int id) {
		String sql = "delete from customer where id=?";

		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Deleted successfully ";
	}
	
	
	
}
