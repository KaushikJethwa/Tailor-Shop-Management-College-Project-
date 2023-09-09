import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	String url="jdbc:mysql://localhost:3306/management";
	 String user="root";
	 String pass="root";
	public String login(String uname,String password) {
	String type1="";
	
	String query = "select type from login1 where username=? and password=?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,uname );
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		rs.next();
		type1=rs.getString("type");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return type1;
	}
	
	public boolean isUsernameExists(String uname) {
		boolean result = false;
		String query = "Select username from login1 where username = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,uname );
			ResultSet rs=ps.executeQuery();
			result = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int register(String uname,String password,String name, String contact) {
		int result=0;
		String query = "insert into login1 values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,uname );
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, contact);
			ps.setString(5, "worker");
			result= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
}
