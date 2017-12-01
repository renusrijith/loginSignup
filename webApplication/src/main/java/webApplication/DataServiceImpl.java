package webApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class DataServiceImpl implements DataService{
	//private Database database;
	
	
	
	

	@Override
	public boolean isUserNameAvailable(String name) {
		
		User user=this.getUser(name);
		if(user!=null) return false ;
		
		return true;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Connection connection = Database.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO user(username,password) VALUES (?,?);");
			 ps.setString(1, user.getUsername());
		        ps.setString(2, user.getPassword());
		        System.out.println(ps);
		        int i = ps.executeUpdate();
		        if(i == 1) {
		            return true;
		          }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		return false;
	}

	@Override
	public User loginUser(String username ,String password) {
		
		Connection connection = Database.getConnection();
		try {
			//String selectSQL = "SELECT  USERNAME FROM DBUSER WHERE USER_ID = ?";
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	    return extractUserFromResultSet(rs);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
		
	}
	
	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
	    User user = new User();
//	    user.setId( rs.getInt("id") );
//	    user.setName( rs.getString("name") );
//	    user.setPass( rs.getString("pass") );
//	    user.setAge( rs.getInt("age") );
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    return user;
	}
	
	public User getUser(String username) 
	{
		Connection connection = Database.getConnection();
	    try {
	    	PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username = ? ");
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	            return extractUserFromResultSet(rs);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	       
	    }
	    
	    
	    return null;
		
	}

}
