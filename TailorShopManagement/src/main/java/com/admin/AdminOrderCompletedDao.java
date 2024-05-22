package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminOrderCompletedDao {

	String url = "jdbc:mysql://localhost:3306/management";
	String user = "root";
	String pass = "root";

	public List<OrderCompletedPOJO> showBlouseorderCompleted() {
		ArrayList<OrderCompletedPOJO> orderCompleted = new ArrayList<OrderCompletedPOJO>();
		String blouseQuery = " select customerdetail.name,customerdetail.bill_no,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,blousemeasurements.price,blousemeasurements.completed from customerdetail,blousemeasurements where customerdetail.dateTime = blousemeasurements.dateTime and blousemeasurements.completed=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(blouseQuery);
            ps.setString(1, "YES");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderCompleted.add(createorderCompletedFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderCompleted;

	}

	public List<OrderCompletedPOJO> showDressorderCompleted() {
		ArrayList<OrderCompletedPOJO> orderCompleted = new ArrayList<OrderCompletedPOJO>();
		String dressQuery = "  select customerdetail.name,customerdetail.bill_no,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,dressmeasurements.price,dressmeasurements.completed from customerdetail,dressmeasurements where customerdetail.dateTime = dressmeasurements.dateTime and dressmeasurements.completed=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressQuery);
            ps.setString(1, "YES");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderCompleted.add(createorderCompletedFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderCompleted;

	}
	
	public List<OrderCompletedPOJO> showDressBlouseorderCompleted() {
		ArrayList<OrderCompletedPOJO> orderCompleted = new ArrayList<OrderCompletedPOJO>();
		String dressblouseQuery = "  select customerdetail.name,customerdetail.bill_no,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,dressblouseboth.dressprice,dressblouseboth.blouseprice,dressblouseboth.completed from customerdetail,dressblouseboth where customerdetail.dateTime = dressblouseboth.dateTime and dressblouseboth.completed=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressblouseQuery);
			ps.setString(1, "YES");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				orderCompleted.add(createBothorderCompletedFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderCompleted;

	}

	public OrderCompletedPOJO createBothorderCompletedFromResultSet(ResultSet rs) throws SQLException {
		OrderCompletedPOJO orderRemaning = new OrderCompletedPOJO();
		orderRemaning.setName(rs.getString("name"));
		orderRemaning.setCloth(rs.getString("cloth"));
		orderRemaning.setDate(rs.getString("date"));
		orderRemaning.setWorker(rs.getString("worker"));
		orderRemaning.setContact(rs.getString("contact"));
		orderRemaning.setPrice(rs.getInt("dressprice")+rs.getInt("blouseprice"));
        orderRemaning.setBillNo(rs.getInt("bill_no"));
		return orderRemaning;
	}

	public OrderCompletedPOJO createorderCompletedFromResultSet(ResultSet rs) throws SQLException {
		OrderCompletedPOJO orderRemaning = new OrderCompletedPOJO();
		orderRemaning.setName(rs.getString("name"));
		orderRemaning.setCloth(rs.getString("cloth"));
		orderRemaning.setDate(rs.getString("date"));
		orderRemaning.setWorker(rs.getString("worker"));
		orderRemaning.setContact(rs.getString("contact"));
		orderRemaning.setPrice(rs.getInt("price"));
		orderRemaning.setBillNo(rs.getInt("bill_no"));
		return orderRemaning;
	}

}
