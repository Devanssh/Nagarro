package eliving.ser;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/ereg")
public class ereg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con=null;
	 PreparedStatement pslogin=null;
	 PreparedStatement psereg=null;
	 ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ereg() {
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
		String expid = request.getParameter("exid");
		String pass = request.getParameter("upass");
		String adrs = request.getParameter("exadrs");
		String ph = request.getParameter("exphno");
		String eid = request.getParameter("exeid");
		String gdr = request.getParameter("gender");
		String cty= request.getParameter("exct");
		String ql = request.getParameter("exq");
		String clg = request.getParameter("exclg");
		String typ = request.getParameter("cmbtyp");
		String exp = request.getParameter("exexp");
		String skill = request.getParameter("exskl");
		String certi = request.getParameter("excrt");
		
	
		
		java.util.Date d= new java.util.Date();
		long l= d.getTime();
		java.sql.Date sd= new java.sql.Date(l);
		
		con= CrudOperation.createConnection();
		
		try{
			con.setAutoCommit(false);
			String strlogin= "insert into logininfo values(?,?,?)";
			String strreg= "insert into exp_reg(expertId,name,address,email,city,gender,phoneNo,qualifications,college,experience,skills,certificate,type,dor)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//we have written column names bcz we have added a new column oicname in table.and here were seven ?,so it would get confused and wouldnt had worked.
			
			pslogin = con.prepareStatement(strlogin);
			psereg = con.prepareStatement(strreg);
			
			pslogin.setString(1,expid);
			pslogin.setString(2,pass);
			pslogin.setString(3,"expert");
			
			int rw= pslogin.executeUpdate();
			
			psereg.setString(1,expid);
			psereg.setString(2,expname);
			psereg.setString(3,adrs);
			psereg.setString(4,eid);
			psereg.setString(5,cty);
			psereg.setString(6,gdr);
			psereg.setString(7,ph);
			psereg.setString(8,ql);
			psereg.setString(9,clg);
			psereg.setString(10,typ);
			psereg.setString(11,exp);
			psereg.setString(12,skill);
			psereg.setString(13,certi);
			psereg.setDate(14,sd);
			
			
			int rw1= psereg.executeUpdate();
			
			if(rw>0&&rw1>0)
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


