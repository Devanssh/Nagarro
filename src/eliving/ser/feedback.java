package eliving.ser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import eliving.dbutil.CrudOperation;

/**
 * Servlet implementation class feedback
 */
@WebServlet("/feedback")
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement psnews;
	ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedback() {
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
		String user=request.getParameter("txtuser");                                                       
		String text=request.getParameter("txt");
		String expert=request.getParameter("txtexp");
	

		java.util.Date d=new java.util.Date();
		long l=d.getTime();
		java.sql.Date sd=new java.sql.Date(l);
	 con=CrudOperation.createConnection();
	try{
			con.setAutoCommit(false);
			String strins="insert into feedback(userid,date,text,expertid) values(?,?,?,?)";
			
			psnews= con.prepareStatement(strins);
		
			
			psnews.setString(1,user);
			psnews.setDate(2,sd);
			psnews.setString(3,text);
		
			psnews.setString(4,expert);
			int rw=psnews.executeUpdate();
		
			if(rw>0)
			{con.commit();
			System.out.println("row inserted");
			response.sendRedirect("/eliving/jsp/feedback.jsp");
		}
			else
			{
				request.setAttribute("msg1", "yourfeedback has been posted");
				RequestDispatcher rd= request.getRequestDispatcher("/jsp/feedback.jsp");
				rd.forward(request, response);
			}
	
	
	
	}

catch(SQLException se)
		{
			System.out.println(se);
			
		}
	 finally{
			try{
				if(psnews!=null)
					psnews.close();
				
				}
			catch(SQLException e){
				System.out.println(e);
			}
			}
	}

}
