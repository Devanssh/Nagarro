package aa.ser;

import java.sql.*;
import aa.dbutil.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String userid=request.getParameter("uid");
		String userpass= request.getParameter("upass");
		
		con= CrudOperation.createConnection();
		String sql="select * from login where email=? and userpass=?";
		
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setString(2,userpass);
		
			rs=ps.executeQuery();
			
			if(rs.next())
				{
				
				HttpSession hs = request.getSession();
				hs.setAttribute("userinfo", userid);
				
				
				
				
				response.sendRedirect("/aa/jsp/log.jsp");
			
				
						
					}
			
			
			else
			{
				//response.sendRedirect("/eliving/jsp/login.jsp");
				request.setAttribute("msg", "Invalid userId or Password");
				RequestDispatcher rd= request.getRequestDispatcher("/jsp/log.jsp");
				rd.forward(request, response);
				
		
			}
		
	
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

}
