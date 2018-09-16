package eliving.ser;

import java.sql.*;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eliving.dbutil.CrudOperation;
/**
 * Servlet implementation class ureg
 */
@WebServlet("/ureg")
public class ureg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Connection con = null;
	private static PreparedStatement pslogin=null;
	private static PreparedStatement psureg=null;
	ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ureg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  userid= request.getParameter("uid");
		String  name= request.getParameter("uname");
		
		String  pass= request.getParameter("upass");
		String  adrs= request.getParameter("adrs");
		String  ph= request.getParameter("phno");
		String  email= request.getParameter("eid");
		String  dob= request.getParameter("dob");
		String gender= request.getParameter("uid");
		
		java.util.Date d= new java.util.Date();
		long l= d.getTime();
		java.sql.Date sd= new java.sql.Date(l);
		
		con=CrudOperation.createConnection();
		
		try{
			con.setAutoCommit(false);
			
			String strlogin= "insert into logininfo values (?,?,?)";
			String strreg="insert into user_reg(userid,name,address,email,gender,phoneNo,dob,dor) values(?,?,?,?,?,?,?,?)";
		
			pslogin=con.prepareStatement(strlogin);
			psureg=con.prepareStatement(strreg);
			
			pslogin.setString(1,userid);
			pslogin.setString(2,pass);
			pslogin.setString(3,"user");
			
			int rw= pslogin.executeUpdate();
			
			psureg.setString(1, userid);
			psureg.setString(2, name);
			psureg.setString(3, adrs);
			psureg.setString(4, email);
			psureg.setString(5, gender);
			psureg.setString(6, ph);
			psureg.setString(7, dob);
			psureg.setDate(8, sd);
			
		
			int rw1=psureg.executeUpdate();
			
			if(rw>0&&rw1>0)
			{
				con.commit();
				System.out.println("row inserted");
				response.sendRedirect("/eliving/jsp/login.jsp");
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		
		finally
		{
			try{
				if(pslogin!=null)
					pslogin.close();
				if(psureg!=null)
					psureg.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
	}

}
