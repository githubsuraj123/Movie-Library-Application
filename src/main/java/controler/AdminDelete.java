package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.Movie_DAO;

@WebServlet("/DeleteAdmin")
public class AdminDelete extends HttpServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		Movie_DAO dao = new Movie_DAO();
		try {
			//dao.deleteDetails(id);
			
			int result = dao.deleteDetails(id);
			
			if(result >= 1)
			{
				req.setAttribute("message", dao.findAll());
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
				dispatcher.include(req, res);
			}
			else
			{
				req.setAttribute("message", "Something Went Wrong Please Check...!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("AdminHome.jsp");
				dispatcher.include(req, res);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}