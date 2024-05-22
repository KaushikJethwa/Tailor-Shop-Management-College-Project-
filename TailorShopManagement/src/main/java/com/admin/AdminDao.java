package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
	String url = "jdbc:mysql://localhost:3306/management";
	String user = "root";
	String pass = "root";

	public int addOrder(String name, String contact, String address, String email, String worker, String cloth,
			String datetime,int advance,String urgent,String deliveryDate) {
		int result = 0;
		Timestamp timedate = Timestamp.valueOf(datetime);
		String query = "insert into customerdetail (name,contact,address,email,worker,cloth,dateTime,advance,urgent,deliveryDate) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, contact);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, worker);
			ps.setString(6, cloth);
			ps.setTimestamp(7, timedate);
			ps.setInt(8, advance);
			ps.setString(9, urgent);
			ps.setString(10, deliveryDate);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int dressDetails(String name, String dresstype, String shoulder, String lengthoftop, String lengthofhand,
			String chest, String neck, String waist, String lengthoflower, String lengthofbottom, String desc,
			int price, String dateTime, String pattern,String Aster) {
		int result = 0;
		Timestamp datetime = Timestamp.valueOf(dateTime);
		String query = "insert into dressmeasurements values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dresstype);
			ps.setString(2, shoulder);
			ps.setString(3, lengthoftop);
			ps.setString(4, lengthofhand);
			ps.setString(5, chest);
			ps.setString(6, neck);
			ps.setString(7, waist);
			ps.setString(8, lengthoflower);
			ps.setString(9, lengthofbottom);
			ps.setString(10, desc);
			ps.setString(11, name);
			ps.setInt(12, price);
			ps.setString(13, pattern);
			ps.setString(14, "NO");
			ps.setTimestamp(15, datetime);
			ps.setString(16,Aster);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public DressBillPojo generateDressBill(String username) {
		DressBillPojo bill = new DressBillPojo();
		String query = "select dressmeasurements.dresstype,customerdetail.advance,customerdetail.deliveryDate,customerdetail.bill_no,customerdetail.email,dressmeasurements.shoulder,dressmeasurements.lengthoftop,dressmeasurements.lengthofhand,dressmeasurements.chest,dressmeasurements.neck,dressmeasurements.waist,dressmeasurements.lengthoflower,dressmeasurements.lengthofbottom,dressmeasurements.name,dressmeasurements.price,Date_Format(dressmeasurements.dateTime,'%d-%m-%Y %h:%i %p') as date from dressmeasurements,customerdetail where dressmeasurements.dateTime = customerdetail.dateTime and dressmeasurements.name= ? order by customerdetail.dateTime desc";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bill.setName(rs.getString("name"));
				bill.setDresstype(rs.getString("dresstype"));
				bill.setDate(rs.getString("date"));
				bill.setShoulder(rs.getString("shoulder"));
				bill.setChest(rs.getString("chest"));
				bill.setLengthofhand(rs.getString("lengthofhand"));
				bill.setLengthoftop(rs.getString("lengthoftop"));
				bill.setNeck(rs.getString("neck"));
				bill.setWaist(rs.getString("waist"));
				bill.setLengthoflower(rs.getString("lengthoflower"));
				bill.setLengthofbottom(rs.getString("lengthofbottom"));
				bill.setPrice(rs.getInt("price"));
                bill.setEmail(rs.getString("email"));
                bill.setBillNo(rs.getInt("bill_no"));
                bill.setAdvance(rs.getInt("advance"));
                bill.setDeliveryDate(rs.getString("deliveryDate"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return bill;
	}

	public int getDressPrice(String dressType) {
		int price = 0;
		String query = "Select price from dressDetail where dressType = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dressType);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			price = resultSet.getInt("price");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return price;
	}
	public int getAsterPrice(String aster) {
		int price = 0;
		String query = "Select asterprice from aster where astertype = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, aster);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			price = resultSet.getInt("asterprice");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return price;
	}

	public int getPatternPrice(String pattern) {
		int price = 0;
		String query = "Select price from Patterns where pattern = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pattern);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			price = resultSet.getInt("price");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return price;
	}

	public int blouseDetails(String name, String shoulder, String lengthofblouse, String lengthofhand, String chest,
			String neck, String waist, String desc, int price, String dateTime, String pattern,String aster) {
		int result = 0;
		Timestamp datetime = Timestamp.valueOf(dateTime);
		String query = "insert into blousemeasurements values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, shoulder);
			ps.setString(3, lengthofblouse);
			ps.setString(4, lengthofhand);
			ps.setString(5, chest);
			ps.setString(6, waist);
			ps.setString(7, neck);
			ps.setInt(8, price);
			ps.setString(9, desc);
			ps.setString(10, pattern);
			ps.setString(11, "NO");
			ps.setTimestamp(12, datetime);
			ps.setString(13,aster);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public BlouseBillPojo generateBlouseBill(String username) {
		BlouseBillPojo bill1 = new BlouseBillPojo();
		String query = "select blousemeasurements.shoulder,customerdetail.advance,customerdetail.deliveryDate,customerdetail.bill_no,customerdetail.email,blousemeasurements.lengthofblouse,blousemeasurements.lengthofhand,blousemeasurements.chest,blousemeasurements.neck,blousemeasurements.waist,blousemeasurements.name,blousemeasurements.price,Date_Format(blousemeasurements.dateTime,'%d-%m-%Y %h:%i %p') as date from blousemeasurements,customerdetail where blousemeasurements.dateTime = customerdetail.dateTime and blousemeasurements.name = ? order by customerdetail.dateTime desc ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bill1.setName(rs.getString("name"));
				bill1.setChest(rs.getString("chest"));
				bill1.setDate(rs.getString("date"));
				bill1.setLengthofblouse(rs.getString("lengthofblouse"));
				bill1.setLengthofhand(rs.getString("lengthofhand"));
				bill1.setNeck(rs.getString("neck"));
				bill1.setWaist(rs.getString("waist"));
				bill1.setPrice(rs.getInt("price"));
				bill1.setBillNo(rs.getInt("bill_no"));
				bill1.setEmail(rs.getString("email"));
				bill1.setAdvance(rs.getInt("advance"));
				bill1.setDeliveryDate(rs.getString("deliveryDate"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return bill1;
	}

	public int dressBlouseBoth(String name, String dresstype, String dressshoulder, String dresslengthofhand,
			String dresslengthoftop, String dresschest, String dressneck, String dresswaist, String dresslengthoflower,
			String dresslengthofbottom, int dressprice, String dresspattern, String blouseshoulder, String blousechest,
			String blousewaist, String blouseneck, String lengthofblouse, String lengthofblousehand, int blouseprice,
			String blousepattern, String dateTime, String description,String dressAster,String blouseAster) {
		int result = 0;
		Timestamp datetime = Timestamp.valueOf(dateTime);
		String query = "insert into dressblouseboth values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, dresstype);
			ps.setString(3, dressshoulder);
			ps.setString(4, dresslengthofhand);
			ps.setString(5, dresslengthoftop);
			ps.setString(6, dresschest);
			ps.setString(7, dresswaist);
			ps.setString(8, dressneck);
			ps.setString(9, dresslengthoflower);
			ps.setString(10, dresslengthofbottom);
			ps.setInt(11, dressprice);
			ps.setString(12, dresspattern);
			ps.setString(13, blouseshoulder);
			ps.setString(14, blousechest);
			ps.setString(15, blousewaist);
			ps.setString(16, blouseneck);
			ps.setString(17, lengthofblouse);
			ps.setString(18, lengthofblousehand);
			ps.setInt(19, blouseprice);
			ps.setString(20, blousepattern);
			ps.setTimestamp(21, datetime);
			ps.setString(22, description);
			ps.setString(23, "No");
			ps.setString(24, dressAster);
			ps.setString(25, blouseAster);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public DressBlouseBillPojo generateDressBlouseBill(String username) {
		DressBlouseBillPojo bothBill = new DressBlouseBillPojo();
		String query = " select dressblouseboth.name,customerdetail.advance,customerdetail.deliveryDate,customerdetail.bill_no,customerdetail.email,dressblouseboth.dresstype,dressblouseboth.dressshoulder,dressblouseboth.dresslengthofhand,dressblouseboth.dresslengthoftop,dressblouseboth.dresschest,dressblouseboth.dresswaist,dressblouseboth.dressneck,dressblouseboth.dresslengthoflower,dressblouseboth.dresslengthofbottom,dressblouseboth.dressprice,dressblouseboth.blouseshoulder,dressblouseboth.blousechest,dressblouseboth.blousewaist,dressblouseboth.blouseneck,dressblouseboth.lengthofblouse,dressblouseboth.lengthofblousehand,dressblouseboth.blouseprice,Date_Format(dressblouseboth.dateTime,'%d-%m-%Y %h:%i %p') as date from dressblouseboth,customerdetail where dressblouseboth.dateTime = customerdetail.dateTime and dressblouseboth.name = ? order by customerdetail.dateTime desc";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bothBill.setName(rs.getString("name"));
				bothBill.setDresstype(rs.getString("dresstype"));
				bothBill.setDressshoulder(rs.getString("dressshoulder"));
				bothBill.setDresslengthofhand(rs.getString("dresslengthofhand"));
				bothBill.setDresslengthoftop(rs.getString("dresslengthoftop"));
				bothBill.setDresschest(rs.getString("dresschest"));
				bothBill.setDresswaist(rs.getString("dresswaist"));
				bothBill.setDressneck(rs.getString("dressneck"));
				bothBill.setDresslengthoflower(rs.getString("dresslengthoflower"));
				bothBill.setDresslengthofbottom(rs.getString("dresslengthofbottom"));
				bothBill.setDressprice(rs.getInt("dressprice"));
				bothBill.setBlouseshoulder(rs.getString("blouseshoulder"));
				bothBill.setBlousechest(rs.getString("blousechest"));
				bothBill.setBlousewaist(rs.getString("blousewaist"));
				bothBill.setBlouseneck(rs.getString("blouseneck"));
				bothBill.setLengthofblouse(rs.getString("lengthofblouse"));
				bothBill.setBlouselengthofhand(rs.getString("lengthofblousehand"));
				bothBill.setBlouseprice(rs.getInt("blouseprice"));
				bothBill.setDate(rs.getString("date"));
                bothBill.setBillNo(rs.getInt("bill_no"));
                bothBill.setEmail(rs.getString("email"));
                bothBill.setAdvance(rs.getInt("advance"));
                bothBill.setDeliveryDate(rs.getString("deliveryDate"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return bothBill;
	}



}
