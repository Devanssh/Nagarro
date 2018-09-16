package eliving.ser;
import java.sql.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import eliving.dbutil.CrudOperation;

/**
 * Servlet implementation class News
 */
@WebServlet("/A")
public class A extends HttpServlet {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		con=CrudOperation.createConnection();
		String sub=request.getParameter("txtsub");
		String cont=request.getParameter("txtcontent");
		java.util.Date d=new java.util.Date();
		long l=d.getTime();
		Date sd=new Date(l);
		String str="insert into tips(subject,content,date) values (?,?,?)";
		try {
			ps=con.prepareStatement(str);
			ps.setString(1, sub);
			ps.setString(2, cont);
			ps.setDate(3, sd);
			int rw=ps.executeUpdate();
			
			if(rw>0)
			{
				System.out.println("news added");
				response.sendRedirect("/eliving/jsp/b.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
