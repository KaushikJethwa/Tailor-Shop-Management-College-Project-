package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminShowOrderDao {
	String url = "jdbc:mysql://localhost:3306/management";
	String user = "root";
	String pass = "root";

	public List<ShowOrderPojo> showBlouseOrders() {
		ArrayList<ShowOrderPojo> orders = new ArrayList<ShowOrderPojo>();
		String blouseQuery = " select customerdetail.name,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,blousemeasurements.price from customerdetail,blousemeasurements where customerdetail.dateTime = blousemeasurements.dateTime";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(blouseQuery);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createOrderFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;

	}

	public List<ShowOrderPojo> showDressOrders() {
		ArrayList<ShowOrderPojo> orders = new ArrayList<ShowOrderPojo>();
		String dressQuery = "  select customerdetail.name,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,dressmeasurements.price from customerdetail,dressmeasurements where customerdetail.dateTime = dressmeasurements.dateTime";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressQuery);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createOrderFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;

	}
	
	public List<ShowOrderPojo> showDressBlouseOrders() {
		ArrayList<ShowOrderPojo> orders = new ArrayList<ShowOrderPojo>();
		String dressblouseQuery = "  select customerdetail.name,customerdetail.contact,customerdetail.cloth,customerdetail.worker,Date_Format(customerdetail.dateTime,'%d-%m-%Y %h:%i %p') as date,dressblouseboth.dressprice,dressblouseboth.blouseprice from customerdetail,dressblouseboth where customerdetail.dateTime = dressblouseboth.dateTime";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressblouseQuery);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createBothOrderFromResultSet(rs));
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;

	}

	public ShowOrderPojo createBothOrderFromResultSet(ResultSet rs) throws SQLException {
		ShowOrderPojo order = new ShowOrderPojo();
		order.setName(rs.getString("name"));
		order.setCloth(rs.getString("cloth"));
		order.setDate(rs.getString("date"));
		order.setWorker(rs.getString("worker"));
		order.setContact(rs.getString("contact"));
		order.setPrice(rs.getInt("dressprice")+rs.getInt("blouseprice"));

		return order;
	}

	public ShowOrderPojo createOrderFromResultSet(ResultSet rs) throws SQLException {
		ShowOrderPojo order = new ShowOrderPojo();
		order.setName(rs.getString("name"));
		order.setCloth(rs.getString("cloth"));
		order.setDate(rs.getString("date"));
		order.setWorker(rs.getString("worker"));
		order.setContact(rs.getString("contact"));
		order.setPrice(rs.getInt("price"));

		return order;
	}
}
