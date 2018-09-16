package eliving.ser;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eliving.dbutil.CrudOperation;

/**
 * Servlet implementation class editProfile
 */
@WebServlet("/updateDetails")
public class updateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement ps;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateDetails() {
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
		
		HttpSession hs= request.getSession(false);
		String u_id=(String)hs.getAttribute("userinfo");
		
		
		String ph=request.getParameter("phoneNo");
		String adrs= request.getParameter("address");
		
		con=CrudOperation.createConnection();
		try{
			String strupdate="update user_reg set address=?,phoneNo=? where userid=?";
			
			ps=con.prepareStatement(strupdate);
			ps.setString(1,adrs);
			ps.setString(2,ph);
			ps.setString(3,u_id);
			
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				System.out.println("row updated");
				response.sendRedirect("/eliving/jsp/viewProfile.jsp");
			}
			
		}
			catch(SQLException se)
			{
				System.out.println(se);
			
				}
			
			finally{
				try{
					if(ps!=null)
						ps.close();
					
					
				}
				catch(SQLException se)
				{
					System.out.println(se);
				
					}
			}
			
	
	}
}
