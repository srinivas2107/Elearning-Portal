package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String lang=request.getParameter("option");
		String file=request.getParameter("file");
        switch(lang) {
        case "java" :
        	try {
    			boolean status=false;
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
    			PreparedStatement ps=conn.prepareStatement("insert into java values(?,?)");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("upload1.html");
    			rd.forward(request, response);
    			return;
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
        	break;
        case "c" :
        	try {
    			boolean status=false;
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
    			PreparedStatement ps=conn.prepareStatement("insert into c values(?,?)");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("upload1.html");
    			rd.forward(request, response);
    			return;
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
        	break;
        case "python" :
        	try {
    			boolean status=false;
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
    			PreparedStatement ps=conn.prepareStatement("insert into python values(?,?)");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("upload1.html");
    			rd.forward(request, response);
    			return;
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
        	break;
        case "html" :
        	try {
    			boolean status=false;
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
    			PreparedStatement ps=conn.prepareStatement("insert into html values(?,?)");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("upload1.html");
    			rd.forward(request, response);
    			return;
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
        	break;
        case "sql" :
        	try {
    			boolean status=false;
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/elearning","root","July@1997");
    			PreparedStatement ps=conn.prepareStatement("insert into sqldata values(?,?)");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("upload1.html");
    			rd.forward(request, response);
    			return;
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
        	break;
        }
	}

}
