package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class uhtml
 */
@WebServlet("/uhtml")
public class uhtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>\r\n" + 
				"<head><link rel=\"stylesheet\" href=\"user.css\" type=\"text/css\"></head>\r\n" + 
				"<body background=\"bg1.jpg\">\r\n" + 
				"\r\n" + 
				"<header>\r\n" + 
				"    <b><h1>E-learning portal</h1></b> \r\n" + 
				"<p>             Project-7                       </p><br/>\r\n" + 
				"</header>\r\n" + 
				"<br/>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"user.html\">Home</a></li>\r\n" + 
				"<ul>\r\n" + 
				
				"<li><a>Courses</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"ujava\">Java</a></li>\r\n" + 
				"<li><a href=\"uc\">C</a></li>\r\n" + 
				"<li><a href=\"usql\">SQL</a></li>\r\n" + 
				"<li><a href=\"upython\">Python</a></li>\r\n" + 
				"<li><a href=\"uhtml\">HTML</a></li>\r\n" + 
				"</ul>\r\n" + 
				"\r\n" + 
				"</li>\r\n" + 
				"<li><a>Contact</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a>9642098057</a></li>\r\n" + 
				"<li><a>elearningportal@gmail.com</a></li>\r\n" + 
				"\r\n" + 
				"</ul>\r\n" + 
				"\r\n" + 
				"</li>\r\n" + 
				"\r\n" + 
				"<li><a>Profile</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"login.html\">Logout</a></li>\r\n" + 
				"</ul>\r\n" + 
				"</li>\r\n" + 
				"<br/>\r\n" + 
				"<br/>\r\n" + 
				"<article>\r\n" + 
				"   <h2>");
		 out.println("<table border=1 width=50% height=50%>");
         out.println("<tr><th>file links</th></tr>");
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
				Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from html");
	            while (rs.next()) {
	                String n = rs.getString("file");
	                out.println("<tr><td>" + n + "</td></tr>"); 
	               
	            }
	            out.println("</table>");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		 out.println("</h2>\r\n" + 
		 		"   <p>\r\n" + 
		 		"</article>\r\n" + 
		 		"\r\n" + 
		 		"</body>\r\n" + 
		 		"</html>");
		
	}

}
