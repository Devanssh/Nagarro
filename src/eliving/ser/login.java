package eliving.ser;

import java.sql.*;
import eliving.dbutil.*;
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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		String sql="select * from logininfo where userid=? and userpass=?";
		
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setString(2,userpass);
		
			rs=ps.executeQuery();
			
			if(rs.next())
				{
				
				HttpSession hs = request.getSession();
				hs.setAttribute("userinfo", userid);
			
				String utype=rs.getString("usertype");
			
			
				if(utype.equals("expert"))
				response.sendRedirect("/eliving/jsp/eprofile.jsp");
		
		
				if(utype.equals("user")){
				response.sendRedirect("/eliving/jsp/uprofile.jsp");}

				}
		
		
		else
		{
			//response.sendRedirect("/eliving/jsp/login.jsp");
			request.setAttribute("msg", "Invalid userId or Password");
			RequestDispatcher rd= request.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(request, response);
		}
		
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

}
