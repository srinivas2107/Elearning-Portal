package tutor;

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
 * Servlet implementation class tc
 */
@WebServlet("/tc")
public class tc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>\r\n" + 
				"<head><link rel=\"stylesheet\" href=\"tutor.css\" type=\"text/css\"></head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<header>\r\n" + 
				"    <b>Elearning Portal</b> <br/><br/>\r\n" + 
				"   \r\n" + 
				"   <p>  Project-7 </p>\r\n" + 
				"</header>\r\n" + 
				"\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"tutor.html\">Home</a></li>\r\n" + 
				"\r\n" + 
				"<li><a>Courses</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"tjava\">Java</a></li>\r\n" + 
				"<li><a href=\"tc\">C</a></li>\r\n" + 
				"<li><a href=\"tpython\">Python</a></li>\r\n" + 
				"<li><a href=\"tsql\">Sql</a></li>\r\n" + 
				"<li><a href=\"thtml\">HTML</a></li>\r\n" + 
				"</ul>\r\n" + 
				"</li>\r\n" + 
				"\r\n" + 
				"<li><a>Things to do</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a href=\"upload1.html\">Upload File</a></li>\r\n" + 
				"<li><a href=\"delete.html\">Delete File</a></li>\r\n" + 
				"</ul>\r\n" + 
				"\r\n" + 
				"</li>\r\n" + 
				"<li><a>Contact</a>\r\n" + 
				"<ul>\r\n" + 
				"<li><a>9642098057</a></li>\r\n" + 
				"<li><a>elearning@gmail.com</a></li>\r\n" + 
				"\r\n" + 
				"</ul>\r\n" + 
				"\r\n" + 
				"</li>\r\n" + 
				"<li><a href=\"login.html\">LOGOUT</a></li>\r\n" + 
				"</ul>\r\n" + 
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
	            ResultSet rs = stmt.executeQuery("select * from c");
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
		 		"     \r\n" + 
		 		"   </p>\r\n" + 
		 		"</article>\r\n" + 
		 		"\r\n" + 
		 		"</body>\r\n" + 
		 		"</html>");
		
	}


}
