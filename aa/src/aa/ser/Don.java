package aa.ser;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aa.dbutil.CrudOperation;

/**
 * Servlet implementation class Don
 */
@WebServlet("/Don")
public class Don extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection con=null;
	
	PreparedStatement psreg=null;
	ResultSet rs=null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Don() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String user=request.getParameter("uid");
		String us=request.getParameter("uid1");
		String ci=request.getParameter("optradio");
		String user1=request.getParameter("uid2");
		String user2=request.getParameter("a");
		 con = CrudOperation.createConnection();
			try{
				con.setAutoCommit(false);
				
	String strreg="insert into don() values(?,?,?,?,?)";
		                psreg= con.prepareStatement(strreg);
						psreg.setString(1,user);
					    psreg.setString(2,us);
						psreg.setString(3,ci);
						psreg.setString(4,user1);
						psreg.setString(5,user2);
						int rw1=psreg.executeUpdate();
						HttpSession h = request.getSession();
						h.setAttribute("userin", user);
						if(rw1>0)
							{con.commit();
								System.out.println("row inserted");
								response.sendRedirect("/aa/jsp/don.jsp");
							}
						else
						{
							request.setAttribute("msg1", "your have filled your form");
							RequestDispatcher rd= request.getRequestDispatcher("/jsp/don.jsp");
							rd.forward(request, response);
						}}

		catch(SQLException se)
							{
								System.out.println(se);
								
							}
							finally{
								try{
									if(psreg!=null)
										psreg.close();}
								catch(SQLException e){
									System.out.println(e);
								}
								}
	}

}
