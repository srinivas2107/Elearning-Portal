package abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("username");
		String p=request.getParameter("password");
		String s=request.getParameter("role");
		if(s.equals("admin")) {
		if(n.equals("admin")&&p.equals("July@1997")) {
			 RequestDispatcher rd=request.getRequestDispatcher("admin.html");
			  rd.forward(request, response);
			  return;
		}
		}
		if(s.equals("user")) {
		try {
			boolean status=false;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
			PreparedStatement ps=conn.prepareStatement("select * from user1 where email=? and password=?");
			ps.setString(1, n);
			ps.setString(2,p);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			if(status==true) {
				RequestDispatcher rd=request.getRequestDispatcher("user.html");
				  rd.forward(request, response);
				  return;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		if(s.equals("tutor")) {
		try {
			boolean status=false;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
			PreparedStatement ps=conn.prepareStatement("select * from tutor1 where email=? and password=?");
			ps.setString(1, n);
			ps.setString(2,p);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			if(status==true) {
				RequestDispatcher rd=request.getRequestDispatcher("tutor.html");
				  rd.forward(request, response);
				  return;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		  rd.forward(request, response);
		  return;
	}

}
