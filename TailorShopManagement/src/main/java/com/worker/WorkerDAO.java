package com.worker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO {
	String url = "jdbc:mysql://localhost:3306/management";
	String user = "root";
	String pass = "root";

	public List<WorkerBlouseOrderPOJO> showBlouseOrders(String worker) {
		ArrayList<WorkerBlouseOrderPOJO> orders = new ArrayList<WorkerBlouseOrderPOJO>();
		String blouseQuery = "select blousemeasurements.shoulder,customerdetail.bill_no,blousemeasurements.lengthofblouse,blousemeasurements.lengthofhand,blousemeasurements.chest,blousemeasurements.neck,blousemeasurements.waist,blousemeasurements.name,blousemeasurements.dateTime as date,blousemeasurements.pattern,blousemeasurements.description from blousemeasurements,customerdetail where ((blousemeasurements.dateTime = customerdetail.dateTime) and (customerdetail.worker = ? and blousemeasurements.completed = ?)) and customerdetail.urgent=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch 
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(blouseQuery);
			ps.setString(1, worker);
			ps.setString(2, "NO");
			ps.setString(3, "NO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createBlouseOrderFromResultSet(rs));
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
	
	public List<WorkerBlouseOrderPOJO> showUrgentBlouseOrders(String worker) {
		ArrayList<WorkerBlouseOrderPOJO> orders = new ArrayList<WorkerBlouseOrderPOJO>();
		String blouseQuery = "select blousemeasurements.shoulder,customerdetail.bill_no,blousemeasurements.lengthofblouse,blousemeasurements.lengthofhand,blousemeasurements.chest,blousemeasurements.neck,blousemeasurements.waist,blousemeasurements.name,blousemeasurements.dateTime as date,blousemeasurements.pattern,blousemeasurements.description from blousemeasurements,customerdetail where ((blousemeasurements.dateTime = customerdetail.dateTime) and (customerdetail.worker = ? and blousemeasurements.completed = ?)) and customerdetail.urgent = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(blouseQuery);
			ps.setString(1, worker);
			ps.setString(2, "NO");
			ps.setString(3, "YES");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createBlouseOrderFromResultSet(rs));
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


	public List<WorkerDressOrderPOJO> showDressOrders(String worker) {
		ArrayList<WorkerDressOrderPOJO> orders = new ArrayList<WorkerDressOrderPOJO>();
		String dressQuery = "select dressmeasurements.dresstype,customerdetail.bill_no,dressmeasurements.shoulder,dressmeasurements.lengthoftop,dressmeasurements.lengthofhand,dressmeasurements.chest,dressmeasurements.neck,dressmeasurements.waist,dressmeasurements.lengthoflower,dressmeasurements.lengthofbottom,dressmeasurements.dateTime as date,dressmeasurements.pattern,dressmeasurements.name,dressmeasurements.description from dressmeasurements,customerdetail where ((dressmeasurements.dateTime = customerdetail.dateTime) and (customerdetail.worker = ? and dressmeasurements.completed = ?)) and customerdetail.urgent= ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressQuery);
			ps.setString(1, worker);
			ps.setString(2, "NO");
			ps.setString(3, "NO");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createDressOrderFromResultSet(rs));
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
	
	public List<WorkerDressOrderPOJO> showUrgentDressOrders(String worker) {
		ArrayList<WorkerDressOrderPOJO> orders = new ArrayList<WorkerDressOrderPOJO>();
		String dressQuery = "select dressmeasurements.dresstype,customerdetail.bill_no,dressmeasurements.shoulder,dressmeasurements.lengthoftop,dressmeasurements.lengthofhand,dressmeasurements.chest,dressmeasurements.neck,dressmeasurements.waist,dressmeasurements.lengthoflower,dressmeasurements.lengthofbottom,dressmeasurements.dateTime as date,dressmeasurements.pattern,dressmeasurements.name,dressmeasurements.description from dressmeasurements,customerdetail where ((dressmeasurements.dateTime = customerdetail.dateTime) and (customerdetail.worker = ? and dressmeasurements.completed = ?)) and customerdetail.urgent = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressQuery);
			ps.setString(1, worker);
			ps.setString(2, "NO");
			ps.setString(3, "YES");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createDressOrderFromResultSet(rs));
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


	public List<WorkerDressBlouseBothPOJO> showDressBlouseOrders(String worker){
		ArrayList<WorkerDressBlouseBothPOJO> orders = new ArrayList<WorkerDressBlouseBothPOJO>();
		String dressblouseQuery = "select dressblouseboth.dressshoulder,customerdetail.bill_no,dressblouseboth.dresslengthofhand,dressblouseboth.dresslengthoftop,dressblouseboth.dresschest,dressblouseboth.dressneck,dressblouseboth.dateTime as date,dressblouseboth.dresswaist,dressblouseboth.dresslengthoflower,dressblouseboth.dresslengthofbottom,dressblouseboth.blousechest,dressblouseboth.blousewaist,dressblouseboth.blouseneck,dressblouseboth.blouseshoulder,dressblouseboth.lengthofblouse,dressblouseboth.lengthofblousehand,dressblouseboth.name,dressblouseboth.dresspattern,dressblouseboth.blousepattern,dressblouseboth.description from dressblouseboth,customerdetail where ((dressblouseboth.dateTime = customerdetail.dateTime) and (customerdetail.worker = ? and dressblouseboth.completed = ?)) and customerdetail.urgent=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressblouseQuery);
			ps.setString(1, worker);
			ps.setString(2, "NO");
			ps.setString(3, "NO");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createDressBlouseOrderFromResultSet(rs));
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
	
	public List<WorkerDressBlouseBothPOJO> showUrgentDressBlouseOrders(String worker){
		ArrayList<WorkerDressBlouseBothPOJO> orders = new ArrayList<WorkerDressBlouseBothPOJO>();
		String dressblouseQuery = "select dressblouseboth.dressshoulder,customerdetail.bill_no,dressblouseboth.dresslengthofhand,dressblouseboth.dresslengthoftop,dressblouseboth.dresschest,dressblouseboth.dressneck,dressblouseboth.dateTime as date,dressblouseboth.dresswaist,dressblouseboth.dresslengthoflower,dressblouseboth.dresslengthofbottom,dressblouseboth.blousechest,dressblouseboth.blousewaist,dressblouseboth.blouseneck,dressblouseboth.blouseshoulder,dressblouseboth.lengthofblouse,dressblouseboth.lengthofblousehand,dressblouseboth.name,dressblouseboth.dresspattern,dressblouseboth.blousepattern,dressblouseboth.description from dressblouseboth,customerdetail where ((dressblouseboth.dateTime = customerdetail.dateTime) and (customerdetail.worker = ? and dressblouseboth.completed = ?)) and customerdetail.urgent=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(dressblouseQuery);
			ps.setString(1, worker);
			ps.setString(2, "NO");
			ps.setString(3, "YES");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orders.add(createDressBlouseOrderFromResultSet(rs));
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


	public WorkerDressOrderPOJO createDressOrderFromResultSet(ResultSet rs) throws SQLException {
		WorkerDressOrderPOJO order = new WorkerDressOrderPOJO();
		order.setName(rs.getString("name"));
		order.setDresstype(rs.getString("dresstype"));
		order.setDate(rs.getString("date"));
		order.setShoulder(rs.getString("shoulder"));
		order.setChest(rs.getString("chest"));
		order.setLengthofhand(rs.getString("lengthofhand"));
		order.setLengthoftop(rs.getString("lengthoftop"));
		order.setNeck(rs.getString("neck"));
		order.setWaist(rs.getString("waist"));
		order.setLengthoflower(rs.getString("lengthoflower"));
		order.setLengthofbottom(rs.getString("lengthofbottom"));
		order.setPattern(rs.getString("pattern"));
		order.setDressdescription(rs.getString("description"));
        order.setBillNo(rs.getInt("bill_no"));
		return order;
	}

	public WorkerBlouseOrderPOJO createBlouseOrderFromResultSet(ResultSet rs) throws SQLException {
		WorkerBlouseOrderPOJO order = new WorkerBlouseOrderPOJO();
		order.setName(rs.getString("name"));
		order.setChest(rs.getString("chest"));
		order.setDate(rs.getString("date"));
		order.setLengthofblouse(rs.getString("lengthofblouse"));
		order.setLengthofhand(rs.getString("lengthofhand"));
		order.setNeck(rs.getString("neck"));
		order.setShoulder(rs.getString("shoulder"));
		order.setWaist(rs.getString("waist"));
		order.setPattern(rs.getString("pattern"));
		order.setBlousedescription(rs.getString("description"));
        order.setBillNo(rs.getInt("bill_no"));
		return order;
	}

	public WorkerDressBlouseBothPOJO createDressBlouseOrderFromResultSet(ResultSet rs) throws SQLException {
		WorkerDressBlouseBothPOJO order = new WorkerDressBlouseBothPOJO();
		order.setName(rs.getString("name"));
		order.setDressshoulder(rs.getString("dressshoulder"));
		order.setDresschest(rs.getString("dresschest"));
		order.setDresslengthofhand(rs.getString("dresslengthofhand"));
		order.setDresslengthoftop(rs.getString("dresslengthoftop"));
		order.setDressneck(rs.getString("dressneck"));
		order.setDresswaist(rs.getString("dresswaist"));
		order.setDresslengthoflower(rs.getString("dresslengthoflower"));
		order.setDresslengthofbottom(rs.getString("dresslengthofbottom"));
		order.setDresspattern(rs.getString("dresspattern"));
		order.setBlousechest(rs.getString("blousechest"));
		order.setBlouselengthofhand(rs.getString("lengthofblousehand"));
		order.setLengthofblouse(rs.getString("lengthofblouse"));
		order.setBlouseneck(rs.getString("blouseneck"));
		order.setBlouseshoulder(rs.getString("blouseshoulder"));
		order.setBlousewaist(rs.getString("blousewaist"));
		order.setBlousepattern(rs.getString("blousepattern"));
		order.setDressblousebothdescription(rs.getString("description"));
		order.setDate(rs.getString("date"));
		order.setBillNo(rs.getInt("bill_no"));
		return order;
	}

	public String getPatternPath(String pattern) {
		String path = "";
		String query = "Select path from patterns where pattern = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pattern);

			ResultSet rs = ps.executeQuery();
			rs.next();
			path = rs.getString("path");
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}
	
	public int completeDress(Timestamp time) {
		int result = 0;
		String query = "Update dressmeasurements set completed = ? where dateTime = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "YES");
			ps.setTimestamp(2, time);

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int completeBlouse(Timestamp time) {
		int result = 0;
		String query = "Update blousemeasurements set completed = ? where dateTime = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "YES");
			ps.setTimestamp(2, time);

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int completeBoth(Timestamp time) {
		int result = 0;
		String query = "Update dressblouseboth set completed = ? where dateTime = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "YES");
			ps.setTimestamp(2, time);

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<String> getWorkers(){
		List<String> workers = new ArrayList<>();
		String query = "Select username from login1 where type = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch bl
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "worker");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				workers.add(rs.getString("username"));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return workers;
	}
}
