package eliving.ser;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eliving.dbutil.*;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Connection con=null;
	PreparedStatement ps=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
		
		String arr=request.getParameter("chkdelete");
		String strdelete="delete from logiininfo where value=?";
		con=CrudOperation.createConnection();
		
		try
		{
			ps=con.prepareStatement(strdelete);
			
			for(int i=0;i<arr.length();i++)
			{
				ps.setString(1, arr);
				ps.addBatch();        //to put data in info buffer
			}
			
		   //pass data to dbms & in dbms action of multiple delete is fired 
			
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}

}
