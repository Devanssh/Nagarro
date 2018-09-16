package eliving.ser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eliving.dbutil.CrudOperation;

/**
 * Servlet implementation class messaging
 */
@WebServlet("/message")
public class message extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement psnews;
	ResultSet rs=null;
	PreparedStatement psnews1;
	ResultSet rs1=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public message() {
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
		String recid=request.getParameter("txtrec");                                                       
		String sendid=request.getParameter("txtsend");
		String sub =request.getParameter("txtsub");
		String msg=request.getParameter("txtmsg");
		String upld=request.getParameter("fl");
		
		String recid1=request.getParameter("txtsend");                                                       
		String sendid1=request.getParameter("txtrec");
		String sub1 =request.getParameter("txtsub");
		String msg1=request.getParameter("txtmsg");
		String upld1=request.getParameter("fl");

		java.util.Date d=new java.util.Date();
		long l=d.getTime();
		java.sql.Date sd=new java.sql.Date(l);
	 con=CrudOperation.createConnection();
	try{
			con.setAutoCommit(false);
			String strins="insert into inbox(senderid,receiverid,subject,message,dateofmsg,documents) values(?,?,?,?,?,?)";
			String strins1="insert into sentitem(senderid,receiverid,subject,message,dateofmsg,documents) values(?,?,?,?,?,?)";
			psnews= con.prepareStatement(strins);
			psnews1=con.prepareStatement(strins1);
			
			psnews.setString(1,sendid);
			psnews.setString(2,recid);
			psnews.setString(3,sub);
			psnews.setString(4,msg);
			psnews.setDate(5,sd);
			psnews.setString(6,upld);
			
			psnews1.setString(1,sendid1);
			psnews1.setString(2,recid1);
			psnews1.setString(3,sub);
			psnews1.setString(4,msg);
			psnews1.setDate(5,sd);
			psnews1.setString(6,upld);
			int rw=psnews.executeUpdate();
			int rw1=psnews1.executeUpdate();
			if(rw>0 && rw1>0)
			{con.commit();
			System.out.println("row inserted");
			response.sendRedirect("/eliving/html/msgsnt.html");
		}}

catch(SQLException se)
		{
			System.out.println(se);
			
		}
	 finally{
			try{
				if(psnews!=null)
					psnews.close();
				if(psnews1!=null)
					psnews1.close();
				}
			catch(SQLException e){
				System.out.println(e);
			}
			}
	}

}
