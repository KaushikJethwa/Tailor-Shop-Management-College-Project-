package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminOrderRemaningDao {

	
	String url = "jdbc:mysql://localhost:3306/management";
	String user = "root";
	String pass = "root";

	public List<OrderRemaningPojo> showBlouseorderRemanings() {
		ArrayList<OrderRemaningPojo> orderRemanings = new ArrayList<OrderRemaningPojo>();
		String blouseQuery = " select customerdetail.name,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,blousemeasurements.price,blousemeasurements.completed from customerdetail,blousemeasurements where customerdetail.dateTime = blousemeasurements.dateTime and blousemeasurements.completed=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(blouseQuery);
            ps.setString(1, "NO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderRemanings.add(createorderRemaningFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderRemanings;

	}

	public List<OrderRemaningPojo> showDressorderRemanings() {
		ArrayList<OrderRemaningPojo> orderRemanings = new ArrayList<OrderRemaningPojo>();
		String dressQuery = "  select customerdetail.name,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,dressmeasurements.price,dressmeasurements.completed from customerdetail,dressmeasurements where customerdetail.dateTime = dressmeasurements.dateTime and dressmeasurements.completed=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressQuery);
            ps.setString(1, "NO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderRemanings.add(createorderRemaningFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderRemanings;

	}
	
	public List<OrderRemaningPojo> showDressBlouseorderRemanings() {
		ArrayList<OrderRemaningPojo> orderRemanings = new ArrayList<OrderRemaningPojo>();
		String dressblouseQuery = "  select customerdetail.name,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,dressblouseboth.dressprice,dressblouseboth.blouseprice,dressblouseboth.completed from customerdetail,dressblouseboth where customerdetail.dateTime = dressblouseboth.dateTime and dressblouseboth.completed=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressblouseQuery);
			ps.setString(1, "NO");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				orderRemanings.add(createBothorderRemaningFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderRemanings;

	}

	public OrderRemaningPojo createBothorderRemaningFromResultSet(ResultSet rs) throws SQLException {
		OrderRemaningPojo orderRemaning = new OrderRemaningPojo();
		orderRemaning.setName(rs.getString("name"));
		orderRemaning.setCloth(rs.getString("cloth"));
		orderRemaning.setDate(rs.getString("date"));
		orderRemaning.setWorker(rs.getString("worker"));
		orderRemaning.setContact(rs.getString("contact"));
		orderRemaning.setPrice(rs.getInt("dressprice")+rs.getInt("blouseprice"));
        
		return orderRemaning;
	}

	public OrderRemaningPojo createorderRemaningFromResultSet(ResultSet rs) throws SQLException {
		OrderRemaningPojo orderRemaning = new OrderRemaningPojo();
		orderRemaning.setName(rs.getString("name"));
		orderRemaning.setCloth(rs.getString("cloth"));
		orderRemaning.setDate(rs.getString("date"));
		orderRemaning.setWorker(rs.getString("worker"));
		orderRemaning.setContact(rs.getString("contact"));
		orderRemaning.setPrice(rs.getInt("price"));
		
		return orderRemaning;
	}
}
