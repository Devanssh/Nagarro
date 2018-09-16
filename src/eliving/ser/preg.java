package eliving.ser;

import java.io.IOException;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eliving.dbutil.CrudOperation;

/**
 * Servlet implementation class ereg
 */
@WebServlet("/preg")
public class preg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con=null;
	 PreparedStatement pslogin=null;
	 PreparedStatement psereg=null;
	 ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public preg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String expname = request.getParameter("exname");
		String pass = request.getParameter("upass");
		String adrs = request.getParameter("exadrs");
		String ph = request.getParameter("exphno");
		String eid = request.getParameter("exeid");
		String gdr = request.getParameter("gender");
		String cty= request.getParameter("exct");
		String ql = request.getParameter("exq");
		String pql = request.getParameter("fl");
		String clg = request.getParameter("exclg");
		String typ = request.getParameter("cmbtyp");
		String exp = request.getParameter("exexp");
		String skill = request.getParameter("exskl");
		String certi = request.getParameter("excrt");
		String pcerti = request.getParameter("fl1");
		
	
		
		java.util.Date d= new java.util.Date();
		long l= d.getTime();
		java.sql.Date sd= new java.sql.Date(l);
		
		con= CrudOperation.createConnection();
		
		try{
			con.setAutoCommit(false);
			String strreg= "insert into p_reg(name,address,email,city,gender,phoneNo,qualifications,college,experience,skills,certificate,type,dor,pqualifications,pcertificate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//we have written column names bcz we have added a new column oicname in table.and here were seven ?,so it would get confused and wouldnt had worked.
			
			psereg.setString(1,expname);
			psereg.setString(2,adrs);
			psereg.setString(3,eid);
			psereg.setString(4,cty);
			psereg.setString(5,gdr);
			psereg.setString(6,ph);
			psereg.setString(7,ql);
			psereg.setString(8,clg);
			psereg.setString(9,typ);
			psereg.setString(10,exp);
			psereg.setString(11,skill);
			psereg.setString(12,certi);
			psereg.setDate(13,sd);
			psereg.setString(14,pql);
			psereg.setString(15,pcerti);
			
			
			int rw1= psereg.executeUpdate();
			
			if(rw1>0)
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
		
		finally{
			try{
				if(pslogin!=null)
					pslogin.close();
				
				if(psereg!=null)
					psereg.close();
			}
			catch(SQLException se)
			{
				System.out.println(se);
			
				}
		}
	}

		

	}


