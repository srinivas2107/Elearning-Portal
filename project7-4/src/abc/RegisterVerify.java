package abc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/registerverify")
public class RegisterVerify extends HttpServlet{

/**
	 *
	 */
	private static final long serialVersionUID = -6472683170513154876L;

public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  String type=request.getParameter("registertype");
	  String uname=request.getParameter("uname");
	  String password=request.getParameter("password");
	  String email=request.getParameter("email");
	  String cpassword=request.getParameter("confirmpassword");
	  if(!password.equals(cpassword)) {
		  RequestDispatcher rd=request.getRequestDispatcher("Register1.html");
		  rd.forward(request, response);
		  return;
	  }
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
		Statement st=conn.createStatement();
		if(type.equalsIgnoreCase("tutor")) {
			ResultSet rs=st.executeQuery("select uname from tutor1");
			while(rs.next()) {
				String u=rs.getString("uname");
				if(u.equalsIgnoreCase(uname)) {
					RequestDispatcher rd=request.getRequestDispatcher("Register2.html");
					rd.forward(request, response);
					return;
				}
			}
			rs=st.executeQuery("select email from tutor1");
			while(rs.next()) {
				String e=rs.getString("email");
				if(e.equalsIgnoreCase(email)) {
					RequestDispatcher rd=request.getRequestDispatcher("Register3.html");
					rd.forward(request, response);
					return;
				}
			}
			PreparedStatement ps=conn.prepareStatement("insert into tutor1 values(?,?,?)");
			ps.setString(1, uname);
			ps.setString(2,email);
			ps.setString(3, password);
			ps.execute();
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			return;
		}
		if(type.equalsIgnoreCase("user")) {
			ResultSet rs=st.executeQuery("select uname from user1");
			while(rs.next()) {
				String u=rs.getString("uname");
				if(u.equalsIgnoreCase(uname)) {
					RequestDispatcher rd=request.getRequestDispatcher("Register2.html");
					rd.forward(request, response);
					return;
				}
			}
			rs=st.executeQuery("select email from user1");
			while(rs.next()) {
				String e=rs.getString("email");
				if(e.equalsIgnoreCase(email)) {
					RequestDispatcher rd=request.getRequestDispatcher("Register3.html");
					rd.forward(request, response);
					return;
				}
			}
			PreparedStatement ps=conn.prepareStatement("insert into user1 values(?,?,?)");
			ps.setString(1, uname);
			ps.setString(2,email);
			ps.setString(3, password);
			ps.execute();
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			return;
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		out.println("Exeption");
	}
  }
}

