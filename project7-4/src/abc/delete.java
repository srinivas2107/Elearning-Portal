package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
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
    			PreparedStatement ps=conn.prepareStatement("DELETE from java where email=? and file=?");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("delete.html");
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
    			PreparedStatement ps=conn.prepareStatement("DELETE from c where email=? and file=?");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("delete.html");
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
    			PreparedStatement ps=conn.prepareStatement("DELETE from python where email=? and file=?");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("delete.html");
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
    			PreparedStatement ps=conn.prepareStatement("DELETE from html where email=? and file=?");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("delete.html");
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
    			PreparedStatement ps=conn.prepareStatement("DELETE from sqldata where email=? and file=?)");
    			ps.setString(1, email);
    			ps.setString(2,file);
    			ps.execute();
    			RequestDispatcher rd=request.getRequestDispatcher("delete.html");
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
