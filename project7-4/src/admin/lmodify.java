package admin;

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
 * Servlet implementation class lmodify
 */
@WebServlet("/lmodify")
public class lmodify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("username");;
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
			PreparedStatement ps=conn.prepareStatement("DELETE from user1 where email=?");
			ps.setString(1, n);
			ps.execute();
			RequestDispatcher rd=request.getRequestDispatcher("luser");
			  rd.forward(request, response);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        
		
	}

}
