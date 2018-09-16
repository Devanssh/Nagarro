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
@WebServlet("/eupdateDetails")
public class eupdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement ps;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public eupdateDetails() {
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
		
		
		
		String adrs= request.getParameter("address");
		String cty= request.getParameter("city");
		String ph=request.getParameter("phoneNo");
		String crt= request.getParameter("certificate");
		
		
		con=CrudOperation.createConnection();
		try{
			String strupdate="update exp_reg set address=?,city=?,phoneNo=?,certificate=? where expertId=?";
			
			ps=con.prepareStatement(strupdate);
			ps.setString(1,adrs);
			ps.setString(2,cty);
			ps.setString(3,ph);
			ps.setString(4,crt);
			ps.setString(5,u_id);
			
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				System.out.println("row updated");
				response.sendRedirect("/eliving/jsp/eviewProfile.jsp");
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
