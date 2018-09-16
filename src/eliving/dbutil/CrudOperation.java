package eliving.dbutil;
import java.sql.*;
public class CrudOperation {




	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	public static Connection con=null;
	
	public static Connection createConnection(){
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//forName() is used to instantiate driver class
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eliving","root","root");
		}
		
		catch(SQLException | ClassNotFoundException cse){
			
			System.out.println(cse);
			
		}
		
		return con;
	}
		
	public  static ResultSet fetchData(String id,String sql)
	{
		ResultSet rs = null;
		try
		{
			con=createConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		
		}
		return rs;
		
		}
	
	public  static ResultSet fetchData(String typ,String cty,String sql)
	{
		ResultSet rs = null;
		try
		{
			con=createConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,typ);
			ps.setString(2,cty);
			rs=ps.executeQuery();
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		
		}
		return rs;
		
		}
	
	public  static ResultSet fetchData(String sql)
	{
		ResultSet rs = null;
		try
		{
			con=createConnection();
			PreparedStatement ps = con.prepareStatement(sql);
	
			rs=ps.executeQuery();
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		
		}
		return rs;
		
		}
	

	public  static ResultSet fetchData(int ui,String sql)
	{
		ResultSet rs = null;
		try
		{
			con=createConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,ui);
			rs=ps.executeQuery();
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		
		}
		return rs;
		
		}
	
	
}

