package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajava
 */
@WebServlet("/ajava")
public class ajava extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>\r\n" + 
				"<head><link rel=\"stylesheet\" href=\"admin.css\" type=\"text/css\"></head>\r\n" + 
				"<body background=\"bg1.jpg\">\r\n" + 
				"\r\n" + 
				"<header>\r\n" + 
				"    <b>Elearning Poratl </b> <br/><br/>\r\n" + 
				"   \r\n" + 
				"   <p>  project 7</p>\r\n" + 
				"</header>\r\n" + 
				"\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"admin.html\">Home</a></li>\r\n" + 
				"\r\n" + 
				"<li><a href=\"luser\">List of Users</a>\r\n" + 
				"</li>\r\n" + 
				"\r\n" + 
				"<li><a href=\"ltutor\">Tutors</a>\r\n" + 
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
				"<li><a>Courses</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"ajava\">Java</a></li>\r\n" + 
				"<li><a href=\"ac\">C</a></li>\r\n" + 
				"<li><a href=\"apython\">Python</a></li>\r\n" + 
				"<li><a href=\"asql\">Sql</a></li>\r\n" + 
				"<li><a href=\"ahtml\">HTML</a></li>\r\n" + 
				"</ul>\r\n" + 
				"</li></li>\r\n" + 
				"<li><a>Profile</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"login.html\">Logout</a></li>\r\n" + 
				"</ul>\r\n" + 
				"</li>\r\n" + 
				"\r\n" + 
				"</ul>\r\n" + 
				"<br/>\r\n" + 
				"<br/>\r\n" + 
				"<article>\r\n" );
				 out.println("<h2>");
				 out.println("<table border=1 width=50% height=50%>");
	             out.println("<tr><th>Email</th><th>file links</th></tr>");
				 try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
						Statement stmt = conn.createStatement();
			            ResultSet rs = stmt.executeQuery("select * from java");
			            while (rs.next()) {
			                String n = rs.getString("file");
			                String p=rs.getString("email");
			                out.println("<tr><td>" + p + "</td><td>" + n + "</td></tr>"); 
			               
			            }
			            out.println("</table>");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				 out.println("</h2>");
				 out.println("<form action=\"ajmod\" >");
			        out.println("<p>select edit or delete</p>");
			        out.println("<select name=\"modify\">\r\n"  + 
			        		"  <option value=\"delete\">delete"
			        		+ ""
			        		+ ""
			        		+ "</option>\r\n" + 
			        		"</select>");
			        out.println("<br>");
			        out.println("Enter Email");
			        out.println("<input type=\"text\" name=\"username\" placeholder=\"Enter Username email\">");
			        out.println("<input type=\"submit\" name=\"modify\" value=\"MODIFY\">");
			        
					out.println("</form>");
				 
				out.println("   <p>\r\n" + 
				"      \r\n" + 
				"   </p>\r\n" + 
				"</article>\r\n" + 
				"</html>");
		
	}

}
