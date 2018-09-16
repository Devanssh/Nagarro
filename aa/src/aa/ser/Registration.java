package aa.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aa.dbutil.CrudOperation;
/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pslog=null;
	PreparedStatement psreg=null;
	ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String ngoname=request.getParameter("txtuserid");
	
		String contact=request.getParameter("txtuserphone");
		String email=request.getParameter("txtuseremail");
		String city=request.getParameter("city");
	
		String pass=request.getParameter("txtuserpassword");

		
		java.util.Date d=new java.util.Date();
		long l=d.getTime();
		java.sql.Date sd=new java.sql.Date(l);
		 con = CrudOperation.createConnection();
		try{
			con.setAutoCommit(false);
			
			String strreg="insert into reg(name,contact,city,dor,email) values(?,?,?,?,?)";
			
					psreg=con.prepareStatement(strreg);
					
					psreg.setString(1,ngoname);
					
					psreg.setString(2,contact);
					psreg.setString(3,city);
					
					psreg.setDate(4,sd);
					
					psreg.setString(5,email);
					
					
				
				int rw1=psreg.executeUpdate();
				
				
				if(rw1>0)
					{con.commit();
						System.out.println("row inserted");
						response.sendRedirect("/aa/html/index.html");
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
