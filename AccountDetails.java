import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class AccountDetails extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			PreparedStatement ps=con.prepareStatement("select * from accountdata ");
			ResultSet rs=ps.executeQuery();

			out.println("<html><body>");
			out.println("<table border='2'>");
			out.println("<tr><th>ser no.</th><th>Name</th><th>Account No.</th><th>Adhar No.</th><th>Mobile No.</th><th>Email-Id</th><th>Father Name</th><th>Account Type</th><th>Balance</th><th>Gender</th><th>Update</th></tr>");
			int serno=1;
			while(rs.next())
			{
				out.println("<tr><td>"+serno+"</td><td>"+rs.getString(1)
					+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)
					+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)
				+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"<td>"+rs.getString(9)+"</td></td><td><a href='Update.html'>Update</a></td></tr>");
				serno++;
			}

			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}